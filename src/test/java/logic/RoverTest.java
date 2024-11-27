package logic;

import data.Direction;
import data.Instruction;
import data.Position;
import input.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void calculateUpdatedPosition_singleMove() {
        //Arrange
        Position expected = new Position(4, 4, Direction.N);

        Rover actual = new Rover(new Position(4, 3, Direction.N), new char[]{'#'});

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("M");

        //Act
        for (int i = 0; i < instructions.length; i++) {
            actual.setPosition(actual.calculateUpdatedPosition(instructions[i]));
        }

        //Assert
        assertEquals(expected.getFacing(), actual.getPosition().getFacing());
        assertEquals(expected.getY(), actual.getPosition().getY());
        assertEquals(expected.getX(), actual.getPosition().getX());

    }

    @Test
    void calculateUpdatedPosition_straightLine() {
        //Arrange
        Position expected = new Position(4, 6, Direction.N);

        Rover actual = new Rover(new Position(4, 3, Direction.N), new char[]{'#'});

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("MMM");

        //Act
        for (int i = 0; i < instructions.length; i++) {
            actual.setPosition(actual.calculateUpdatedPosition(instructions[i]));
        }

        //Assert
        assertEquals(expected.getFacing(), actual.getPosition().getFacing());
        assertEquals(expected.getY(), actual.getPosition().getY());
        assertEquals(expected.getX(), actual.getPosition().getX());

    }

    @Test
    void calculateUpdatedPosition_straightLineRightMoveOnce() {
        //Arrange
        Position expected = new Position(5, 6, Direction.E);

        Rover actual = new Rover(new Position(4, 3, Direction.N), new char[]{'#'});

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("MMMRM");

        //Act
        for (int i = 0; i < instructions.length; i++) {
            actual.setPosition(actual.calculateUpdatedPosition(instructions[i]));
        }

        //Assert
        assertEquals(expected.getFacing(), actual.getPosition().getFacing());
        assertEquals(expected.getY(), actual.getPosition().getY());
        assertEquals(expected.getX(), actual.getPosition().getX());

    }


    @Test
    void calculateUpdatedPosition_straightLineRightMoveRightMove() {
        //Arrange
        Position expected = new Position(5, 5, Direction.S);

        Rover actual = new Rover(new Position(4, 3, Direction.N), new char[]{'#'});

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("MMMRMRM");

        //Act
        for (int i = 0; i < instructions.length; i++) {
            actual.setPosition(actual.calculateUpdatedPosition(instructions[i]));
        }

        //Assert
        assertEquals(expected.getFacing(), actual.getPosition().getFacing());
        assertEquals(expected.getY(), actual.getPosition().getY());
        assertEquals(expected.getX(), actual.getPosition().getX());

    }


    @Test
    void calculateUpdatedPosition_acceptsLowerCaseInput() {
        //Arrange
        Position expected = new Position(5, 5, Direction.S);

        Rover actual = new Rover(new Position(4, 3, Direction.N), new char[]{'#'});

        InputParser inputParser = new InputParser();

        Instruction[] instructions = inputParser.getInstructions("mmmrmrm");

        //Act
        for (int i = 0; i < instructions.length; i++) {
            actual.setPosition(actual.calculateUpdatedPosition(instructions[i]));
        }

        //Assert
        assertEquals(expected.getFacing(), actual.getPosition().getFacing());
        assertEquals(expected.getY(), actual.getPosition().getY());
        assertEquals(expected.getX(), actual.getPosition().getX());

    }
}