package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @org.junit.jupiter.api.Test
    void getPlateau_validInput() {
        //Arrange
        char[][] expected = new char[3][3];
        Plateau plateau = new Plateau(3,3);

        //Act
        char[][] actual = plateau.getPlateau();

        //Assert
        assertArrayEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void getPlateau_emptyPlateau() {
        //Arrange
        char[][] expected = new char[0][0];
        Plateau plateau = new Plateau(0,0);

        //Act
        char[][] actual = plateau.getPlateau();

        //Assert
        assertArrayEquals(expected,actual);

    }

    @org.junit.jupiter.api.Test
    void toString_testExpectedInput() {
        //Arrange
        Plateau plateau = new Plateau(5,5);

        //Act
        String plateauDisplay = plateau.toString();
        System.out.println(plateauDisplay);

        //Assert
        assertEquals("\0\0\0\0\0\n\0\0\0\0\0\n\0\0\0\0\0\n\0\0\0\0\0\n\0\0\0\0\0\n", plateauDisplay);


    }

    @Test
    void isValidPosition_invalidPosition() {
        //Arrange
        Position position = new Position(100,100,Direction.N);

        Plateau plateau = new Plateau(5,5);

        //Act
        boolean actual = plateau.isValidPosition(position);

        //Assert
        assertFalse(actual);

    }

    @Test
    void isValidPosition_validPosition() {
        //Arrange
        Position position = new Position(3,2,Direction.N);

        Plateau plateau = new Plateau(5,5);

        //Act
        boolean actual = plateau.isValidPosition(position);

        //Assert
        assertTrue(actual);

    }
}