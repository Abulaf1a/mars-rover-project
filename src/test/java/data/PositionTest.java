package data;

import input.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void calculateUpdatedPosition_singleMove() {
        //Arrange
        Position expected = new Position(3,3,Direction.N);

        Position currentPosition = new Position(4,3,Direction.N);

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("M");

        //Act
        for (int i = 0; i < instructions.length; i++) {

            Position nextPosition = currentPosition.calculateUpdatedPosition(instructions[i]);
            currentPosition = nextPosition;

        }

        //Assert
        assertEquals(expected.getFacing(), currentPosition.getFacing());
        assertEquals(expected.getY(), currentPosition.getY());
        assertEquals(expected.getX(), currentPosition.getX());

    }

    @Test
    void calculateUpdatedPosition_straightLine() {
        //Arrange
        Position expected = new Position(0,3,Direction.N);

        Position currentPosition = new Position(3,3,Direction.N);

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("MMM");

        //Act
        for (int i = 0; i < instructions.length; i++) {

            Position nextPosition = currentPosition.calculateUpdatedPosition(instructions[i]);
            currentPosition = nextPosition;

        }

        //Assert
        assertEquals(expected.getFacing(), currentPosition.getFacing());
        assertEquals(expected.getY(), currentPosition.getY());
        assertEquals(expected.getX(), currentPosition.getX());

    }

    @Test
    void calculateUpdatedPosition_straightLineRightMoveOnce() {
        //Arrange
        Position expected = new Position(0,4,Direction.E);

        Position currentPosition = new Position(3,3,Direction.N);

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("MMMRM");

        //Act
        for (int i = 0; i < instructions.length; i++) {

            Position nextPosition = currentPosition.calculateUpdatedPosition(instructions[i]);
            currentPosition = nextPosition;

        }

        //Assert
        assertEquals(expected.getFacing(), currentPosition.getFacing());
        assertEquals(expected.getY(), currentPosition.getY());
        assertEquals(expected.getX(), currentPosition.getX());

    }

    @Test
    void calculateUpdatedPosition_straightLineRightMoveRightMove() {
        //Arrange
        Position expected = new Position(1,4,Direction.S);

        Position currentPosition = new Position(3,3,Direction.N);

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("MMMRMRM");

        //Act
        for (int i = 0; i < instructions.length; i++) {

            Position nextPosition = currentPosition.calculateUpdatedPosition(instructions[i]);
            currentPosition = nextPosition;

        }

        //Assert
        assertEquals(expected.getFacing(), currentPosition.getFacing());
        assertEquals(expected.getY(), currentPosition.getY());
        assertEquals(expected.getX(), currentPosition.getX());

    }

    @Test
    void calculateUpdatedPosition_acceptsLowerCaseInput() {
        //Arrange
        Position expected = new Position(1,4,Direction.S);

        Position currentPosition = new Position(3,3,Direction.N);

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("mmmrmrm");

        //Act
        for (int i = 0; i < instructions.length; i++) {

            Position nextPosition = currentPosition.calculateUpdatedPosition(instructions[i]);
            currentPosition = nextPosition;

        }

        //Assert
        assertEquals(expected.getFacing(), currentPosition.getFacing());
        assertEquals(expected.getY(), currentPosition.getY());
        assertEquals(expected.getX(), currentPosition.getX());

    }
}