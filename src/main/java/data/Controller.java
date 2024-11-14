package data;

public class Controller {

    private Plateau plateau;

    private Position roverPosition;


    public Controller(int[] plateauSize, Position position){

        plateau = new Plateau(plateauSize[0], plateauSize[1]);
        roverPosition = position;
    }

    public void moveRover(Instruction instruction){

        Position newPosition = roverPosition.calculateUpdatedPosition(instruction);

        if(plateau.isValidPosition(newPosition)){
            roverPosition = newPosition;
        }
    }

    public Position getRoverPosition() {
        return roverPosition;
    }




    //TODO move to a UI class as this breaks the single responsibility principle..
    public String renderScene(){

        StringBuilder sceneBuilder = new StringBuilder();



        for (int i = plateau.getY() -1; i > -1; i--) {
            //if(i > 0) sceneBuilder.append(" ");
            for (int j = 0; j < plateau.getX(); j++) {
                if(j == roverPosition.getX() && i == roverPosition.getY()){
                    sceneBuilder.append('#');
                }
                else{
                    sceneBuilder.append(plateau.getPlateau()[j][i]);
                }
            }
            sceneBuilder.append("\n");
        }

        //sceneBuilder.append( plateau.getY());
        //TODO import StringUtils to add flexible Y co-ord in bottom right hand side of screen!

        return sceneBuilder.toString();

    }





}
