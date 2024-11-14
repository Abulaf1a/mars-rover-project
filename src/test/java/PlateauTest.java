import data.Plateau;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @org.junit.jupiter.api.Test
    void getPlateau_() {
    }

    @org.junit.jupiter.api.Test
    void toString_testExpectedInput() {
        //Arrange
        Plateau plateau = new Plateau(5,5);

        //Act
        String plateauDisplay = plateau.toString();
        System.out.println(plateauDisplay);

        //Assert
        assertEquals("00000\n00000\n00000\n00000\n00000\n", plateauDisplay);


    }
}