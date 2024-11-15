package data;

public class Controller {

    private Plateau plateau;
    private Position roverPosition;

    public Controller(int[] plateauSize, Position position){

        plateau = new Plateau(plateauSize[0], plateauSize[1]);
        roverPosition = position;
    }

    public Position getRoverPosition() {
        return roverPosition;
    }

    public void moveRover(Instruction instruction){

        Position newPosition = roverPosition.calculateUpdatedPosition(instruction);

        if(plateau.isValidPosition(newPosition)){
            roverPosition = newPosition;
        }
    }

    //TODO move to a UI class as this breaks the single responsibility principle..
    public String renderScene(){

        StringBuilder sceneBuilder = new StringBuilder();

        String red = "\u001B[31m";
        String background = " \u001B[43m";
        String reset = "\u001B[0m";

        for (int i = plateau.getY() -1; i > -1; i--) {
            sceneBuilder.append(red + background);

            for (int j = 0; j < plateau.getX(); j++) {
                if(j == roverPosition.getX() && i == roverPosition.getY()){
                    sceneBuilder.append("\u001B[30m");

                    sceneBuilder.append('#');
                    sceneBuilder.append(red);

                }
                else{
                    sceneBuilder.append(plateau.getPlateau()[j][i]);
                }
            }
            sceneBuilder.append(reset);
            sceneBuilder.append("\n");

        }

        return sceneBuilder.toString();

    }

}
