package logic;

import data.Instruction;
import data.Plateau;
import data.Position;
import data.Returnable;

import java.util.ArrayList;

public class Controller {

    private Plateau plateau;
    private Rover rover;

    public Controller(int[] plateauSize, Position position){

        plateau = new Plateau(plateauSize[0], plateauSize[1], position);

        rover = new Rover(position, new char[]{'O','#','O'});

    }
    
    public Position getRoverPosition() {

        return rover.getPosition();
    }

    public void moveRover(Instruction instruction){
        Position check = rover.calculateUpdatedPosition(instruction);
        if(plateau.isValidPosition(check)){
            rover.setPosition(check);
        }
        else{
            System.out.println("Error: Rover must move within Plateau bounds");
        }
    }

    public ArrayList<Returnable> returnData(){

        ArrayList<Returnable> returnables = new ArrayList<>();

        returnables.add(plateau);
        returnables.add(rover);

        return returnables;
    }

}
