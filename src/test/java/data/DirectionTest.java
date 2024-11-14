package data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DirectionTest {

    @Test
    void rotate_testExpectedInputNorthLeftWest() {
        //Arrange
        Direction expected = Direction.W;

        //Act
        Direction actual = Direction.N.rotate(Instruction.L);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void rotate_testExpectedInputNorthRightEast() {
        //Arrange
        Direction expected = Direction.E;

        //Act
        Direction actual = Direction.N.rotate(Instruction.R);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void rotate_testExpectedInputWestLeftSouth() {
        //Arrange
        Direction expected = Direction.S;

        //Act
        Direction actual = Direction.W.rotate(Instruction.L);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void rotate_testExpectedInputWestRightNorth() {
        //Arrange
        Direction expected = Direction.N;

        //Act
        Direction actual = Direction.W.rotate(Instruction.R);

        //Assert
        assertEquals(expected,actual);
    }


    @Test
    void rotate_testExpectedInputSouthLeftEast() {
        //Arrange
        Direction expected = Direction.E;

        //Act
        Direction actual = Direction.S.rotate(Instruction.L);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void rotate_testExpectedInputSouthRightWest() {
        //Arrange
        Direction expected = Direction.W;

        //Act
        Direction actual = Direction.S.rotate(Instruction.R);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void rotate_testExpectedInputEastLeftNorth() {
        //Arrange
        Direction expected = Direction.N;

        //Act
        Direction actual = Direction.E.rotate(Instruction.L);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    void rotate_testExpectedInputEastRightSouth() {
        //Arrange
        Direction expected = Direction.S;

        //Act
        Direction actual = Direction.E.rotate(Instruction.R);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Current logic for Direction Enum includes M within else case, treating it as left")
    void rotate_testUnexepctedInputM() {
        //Arrange
        Direction expected = Direction.N;

        //Act
        Direction actual = Direction.E.rotate(Instruction.M);

        //Assert
        assertEquals(expected,actual);
    }

}