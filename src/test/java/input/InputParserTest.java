package input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("Tests getPlateauSize method returns array of two integers" +
            "given input string of two integers separated by a space, " +
            "the expected input")
    void getPlateauSize_testExpectedInput() {
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        try{
            int[] plateauSize = inputParser.getPlateauSize("1 5");

            //Assert
            assertArrayEquals(new int[]{1,5}, plateauSize);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    @DisplayName("Tests the getPlateauSize method returns array of two integers " +
            "given input string of two integers separated by multiple spaces, " +
            "a non typical input")
    void getPlateauSize_testMultipleSpaces(){
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        try{
            int[] plateauSize = inputParser.getPlateauSize("1   5   ");

            //Assert
            assertArrayEquals(new int[]{1,5}, plateauSize);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @Test
    @DisplayName("Tests the getPlateauSize method throws an exception " +
            "given input string of more than two integers separated by multiple spaces, " +
            "a non typical input")
    void getPlateauSize_testAdditionalIntegers(){
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        try{
            int[] plateauSize = inputParser.getPlateauSize("1   5 3 553  ");


        } catch (Exception e) {

            //Assert
            assertEquals("Please write TWO integers only", e.getMessage());
        }


    }


    @Test
    @DisplayName("Tests the getPlateauSize method throws an error" +
            "given input string of non-integers, " +
            "a non typical input")
    void getPlateauSize_testNonIntegerInput(){
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        try{
            int[] plateauSize = inputParser.getPlateauSize("1 sdfw  5 3 553  ");

        } catch (Exception e){
            //Assert
            assertEquals("Please re-enter plateau size coordinates without letters!", e.getMessage());
        }

    }


    @Test
    void getRoverStartPosition() {
    }

    @Test
    void getInstruction() {
    }
}