package input;

import data.Direction;
import data.Instruction;
import data.Position;
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
            assertEquals("Please re-enter input in format X Y where X and Y are numbers separated by only a space", e.getMessage());
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
            assertEquals("Please re-enter input in format X Y where X and Y are numbers separated by only a space", e.getMessage());
        }

    }

    @Test
    @DisplayName("Tests the getPlateauSize method returns a plateau given a multi-digit input" +
            "a typical input")
    void getPlateauSize_testMultiDigitInput(){
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        try{
            int[] plateauSize = inputParser.getPlateauSize("10 10");

            //Assert
            assertArrayEquals(new int[]{10,10}, plateauSize);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Tests the getPlateauSize method throws an error given a negative input")
    void getPlateauSize_testNegativeInput(){
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        try{
            inputParser.getPlateauSize("-5 -5");

        } catch (Exception e){
            //Assert
            assertEquals("Please re-enter input in format X Y where X and Y are numbers separated by only a space", e.getMessage());

        }
    }


    @Test
    @DisplayName("Tests whether the Input Parser getRoverStartPosition method returns a new Position object with the expected values" +
            " this is a typical input")
    void getRoverStartPosition_testExpectedInput() {
        //Arrange
        InputParser inputParser = new InputParser();
        Position expected = new Position(0,0,Direction.N);

        //Act
        try{
            Position position = inputParser.getRoverStartPosition("0 0 N");

            //Assert
            assertEquals(expected.getX(), position.getX());
            assertEquals(expected.getY(), position.getY());
            assertEquals(expected.getFacing(), position.getFacing());

        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @DisplayName("Tests whether the Input Parser getRoverStartPosition method " +
            "returns a position object given multi-digit x and y coordinates" +
            " this is a typical input")
    void getRoverStartPosition_testMultiDigit(){
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        var position = inputParser.getRoverStartPosition("23 22 E");
        Position expected = new Position(23, 22, Direction.E);

        //Assert
        assertEquals(expected.getX(), position.getX());
        assertEquals(expected.getY(), position.getY());
        assertEquals(expected.getFacing(), position.getFacing());

    }

    @Test
    @DisplayName("Tests whether the Input Parser getRoverStartPosition method " +
            "returns a position object given different length x and y coordinates" +
            " this is a typical input")
    void getRoverStartPosition_testMultiDigitDifferentLengths(){
        //Arrange
        InputParser inputParser = new InputParser();
        Position expected = new Position(23, 2, Direction.E);

        //Act
        Position position = inputParser.getRoverStartPosition("23 2 E");


        //Assert
        assertEquals(expected.getX(), position.getX());
        assertEquals(expected.getY(), position.getY());
        assertEquals(expected.getFacing(), position.getFacing());

    }

    @Test
    @DisplayName("Tests whether the Input Parser getRoverStartPosition method " +
            "throws an error when given an empty input")
    void getRoverStartPosition_testEmptyInputThrowsError(){
        //Arrange
        InputParser inputParser = new InputParser();


        //Act
        try{
            Position position = inputParser.getRoverStartPosition("");
        }
        catch (InputMismatchException e) {

            //Assert
            assertEquals("Please re-enter initial position in the following format: X Y D, for example 0 1 N", e.getMessage());
        }

    }

    @Test
    @DisplayName("Tests whether the Input Parser getRoverStartPosition method " +
            "throws an error when given an input that doesn't conform to expected format " +
            "(non-existant direction 'X')")
    void getRoverStartPosition_throwsErrorWithNonExistentDirection(){
        //Arrange
        InputParser inputParser = new InputParser();

        //Act
        try{
            Position position = inputParser.getRoverStartPosition("23 2 X");
        } catch (InputMismatchException e) {

            //Assert
            assertEquals("Please re-enter initial position in the following format: X Y D, for example 0 1 N", e.getMessage());
        }

    }

    @Test
    @DisplayName("Tests whether the getInstruction method returns an array of instructions given an input string of " +
            "valid characters ('L', 'R', and 'M')")
    void getInstructions_testReturnsInstructionArrayGivenExpectedInput() {
        //Arrange
        InputParser inputParser = new InputParser();
        Instruction[] actual;
        Instruction[] expected = new Instruction[]{
                Instruction.L,
                Instruction.R,
                Instruction.M,
                Instruction.M,
                Instruction.R,
                Instruction.M
        };
        String input = "LRMMRM";

        //Act
        actual = inputParser.getInstructions(input);

        //Assert
        assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Tests whether the getInstruction method returns an array of instructions given an input string of " +
            "valid characters ('L', 'R', and 'M'), single input")
    void getInstructions_testReturnsInstructionArrayGivenSingleExpectedInput() {
        //Arrange
        InputParser inputParser = new InputParser();
        Instruction[] actual;
        Instruction[] expected = new Instruction[]{
                Instruction.L
        };
        String input = "L";

        //Act
        actual = inputParser.getInstructions(input);

        //Assert
        assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Tests whether the getInstruction method allows invalid characters as long as some valid characters are in string")
    void getInstructions_testReturnsInstructionArrayGivenMixedValidAndInvalidInput() {
        //Arrange
        InputParser inputParser = new InputParser();
        Instruction[] actual;
        Instruction[] expected = new Instruction[]{
                Instruction.L,
                Instruction.R,
                Instruction.M,
                Instruction.M
        };
        String input = "LRMXt4X2m";

        //Act
        actual = inputParser.getInstructions(input);

        //Assert
        assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Tests whether the getInstruction method returns correct exception (InputMisMatchException)" +
            "if no valid characters are found in the input string")
    void getInstructions_testReturnsExceptionGivenInvalidInput() {
        //Arrange
        InputParser inputParser = new InputParser();

        String input = "DC4eS[";

        //Act
        try{
            inputParser.getInstructions(input);
        }
        catch(InputMismatchException e){

            //Assert
            assertEquals("No valid input, please re-enter movement instructions" +
                    "valid characters are: L, R, M", e.getMessage());
        }
    }

    @Test
    @DisplayName("Tests whether the getInstruction method returns correct exception (InputMisMatchException)" +
            "given empty string input")
    void getInstructions_testReturnsExceptionGivenEmptyInput() {
        //Arrange
        InputParser inputParser = new InputParser();

        String input = "";

        //Act
        try{
            inputParser.getInstructions(input);
        }
        catch(InputMismatchException e){

            //Assert
            assertEquals("No valid input, please re-enter movement instructions" +
                    "valid characters are: L, R, M", e.getMessage());
        }
    }


}