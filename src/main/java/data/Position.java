package data;

public class Position implements Returnable {

    private int x;
    private int y;
    private Direction facing;

    public Position(int x, int y, Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public Position calculateUpdatedPosition(Instruction instruction){
        /*this position has not yet been checked by the plateau class for obstacles or falling off the edge of the map
        this logic calculates the new position, the controller then passes that position to the plateau,
        which returns whether the new position is valid, only then is this position updated with the new position calculated here.*/
        Position uncheckedUpdatePosition;

        if(instruction.equals(Instruction.M)) uncheckedUpdatePosition = calculateMovePosition();
        else uncheckedUpdatePosition = calculateRotatePosition(instruction);

        return uncheckedUpdatePosition;
    }

    private Position calculateMovePosition(){
        Position tempPosition = new Position(x, y, facing);

        switch(facing){
            case N -> tempPosition.y++;
            case E -> tempPosition.x++;
            case S -> tempPosition.y--;
            case W -> tempPosition.x--;
        }
        return tempPosition;

    }

    private Position calculateRotatePosition(Instruction instruction){

        Position tempPosition = new Position(x, y, facing);
        tempPosition.facing = facing.rotate(instruction);
        return tempPosition;

    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", facing=" + facing +
                '}';
    }

    //getters solely for test classes
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }

}
