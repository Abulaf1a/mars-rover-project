package data;

import java.util.ArrayList;

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

    public ArrayList<Returnable> returnData(){

        ArrayList<Returnable> returnables = new ArrayList<>();

        returnables.add(plateau);
        returnables.add(roverPosition);

        return returnables;
    }

}
