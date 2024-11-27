package logic;

import data.Actor;
import data.Instruction;
import data.Position;
import data.Returnable;

public class Rover extends Actor implements Returnable {

    private char[] body;

    public Rover(Position position, char[] body){
        super(position);
        this.body = body;
    }

    public char[] getBody(){
        return body;
    }

    /*this position has not yet been checked by the plateau class for obstacles or falling off the edge of the map
          this logic calculates the new position, the controller then passes that position to the plateau,
          which returns whether the new position is valid, only then is this position updated with the new position calculated here.*/
    public Position calculateUpdatedPosition(Instruction instruction){

        Position uncheckedUpdatePosition;

        if(instruction.equals(Instruction.M)) uncheckedUpdatePosition = calculateMovePosition();
        else uncheckedUpdatePosition = calculateRotatePosition(instruction);

        //if I had an observer pattern i'd call the relevant method from here.

        return uncheckedUpdatePosition;
    }

    private Position calculateMovePosition(){
        Position tempPosition = new Position(position.getX(), position.getY(), position.getFacing());

        switch(position.getFacing()){
            case N -> tempPosition.setY(tempPosition.getY()+1);
            case E -> tempPosition.setX(tempPosition.getX()+1);
            case S -> tempPosition.setY(tempPosition.getY()-1);
            case W -> tempPosition.setX(tempPosition.getX()-1);
        }
        return tempPosition;
    }

    private Position calculateRotatePosition(Instruction instruction){
        Position tempPosition = new Position(position.getX(), position.getY(), position.getFacing());

        tempPosition.setFacing(tempPosition.getFacing().rotate(instruction));
        return tempPosition;
    }

}
