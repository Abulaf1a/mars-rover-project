package data;

import input.InputParser;
import input.NotEqualToTwoIntegersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {


    @Test
    void moveRover() {
        //Arrange
        Controller controller = new Controller(new int[]{10,10}, new Position(3,2,Direction.N));
        controller.moveRover(Instruction.M);
        Position expectedPosition = new Position(3,3, Direction.N);

        //Act
        Position newPosition = controller.getRoverPosition();

        //Assert
        assertEquals(expectedPosition.getX(), newPosition.getX());
        assertEquals(expectedPosition.getY(), newPosition.getY());
        assertEquals(expectedPosition.getFacing(), newPosition.getFacing());
    }

    //test fails due to colour output
    @Test
    void renderScene() {
        //Arrange
        Controller controller = new Controller(new int[]{5,5}, new Position(2,2,Direction.N));

        String expected =
                "\0\0\0\0\0\n" +
                "\0\0\0\0\0\n" +
                "\0\0#\0\0\n" +
                "\0\0\0\0\0\n" +
                "\0\0\0\0\0\n";

        //Act
        String actual = controller.renderScene();

        //Assert
        assertEquals(expected,actual);
    }



    @Test
    void integrationTest(){
        //Arrange
        String[] testInput = new String[]{"5 5",
                "1 2 N" ,
                "LMLMLMLMM" ,
                "3 3 E" ,
                "MMRMMRMRRM"};

        InputParser inputParser = new InputParser();

        Position expected = new Position(1, 3, Direction.N);


        try{
            Controller controller = new Controller(inputParser.getPlateauSize(testInput[0]),
                    inputParser.getRoverStartPosition(testInput[1]));

            Instruction[] instructions = inputParser.getInstructions(testInput[2]);

            //Act
            for(Instruction i : instructions){
                controller.moveRover(i);

                System.out.println(controller.renderScene());
            }

            //Assert
            assertEquals(expected.getX(), controller.getRoverPosition().getX());
            assertEquals(expected.getY(), controller.getRoverPosition().getY());
            assertEquals(expected.getFacing(), controller.getRoverPosition().getFacing());


        } catch (NotEqualToTwoIntegersException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void integrationTestB(){
        //Arrange
        String[] testInput = new String[]{"5 5",
                "1 2 N" ,
                "LMLMLMLMM" ,
                "3 3 E" ,
                "MMRMMRMRRM"};

        InputParser inputParser = new InputParser();

        Position expected = new Position(5, 1, Direction.E);

        try {

            Controller controller = new Controller(inputParser.getPlateauSize(testInput[0]),
                    inputParser.getRoverStartPosition(testInput[3]));

            Instruction[] instructions = inputParser.getInstructions(testInput[4]);

            //Act
            for (Instruction i : instructions) {
                controller.moveRover(i);

                System.out.println(controller.renderScene());
            }

            //Assert
            assertEquals(expected.getX(), controller.getRoverPosition().getX());
            assertEquals(expected.getY(), controller.getRoverPosition().getY());
            assertEquals(expected.getFacing(), controller.getRoverPosition().getFacing());


            System.out.println("rover is at position: " + controller.getRoverPosition());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void integrationTestMultiDigitPlateau(){
        //Arrange
        String[] testInput = new String[]{"10 10",
                "1 2 N" ,
                "LMLMLMLMM" ,
                "3 3 E" ,
                "MMRMMRMRRM"};

        InputParser inputParser = new InputParser();



        Position expected = new Position(5, 1, Direction.E);

        try {

            Controller controller = new Controller(inputParser.getPlateauSize(testInput[0]),
                    inputParser.getRoverStartPosition(testInput[3]));

            Instruction[] instructions = inputParser.getInstructions(testInput[4]);

            //Act
            for (Instruction i : instructions) {
                controller.moveRover(i);

                System.out.println(controller.renderScene());
            }

            //Assert
            assertEquals(expected.getX(), controller.getRoverPosition().getX()); //expected 5 actual 3.
            assertEquals(expected.getY(), controller.getRoverPosition().getY());
            assertEquals(expected.getFacing(), controller.getRoverPosition().getFacing());


            System.out.println("rover is at position: " + controller.getRoverPosition());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    void integrationTestLargePlateau(){
        //Arrange
        String[] testInput = new String[]{"100 100",
                "1 2 N" ,
                "LMLMLMLMM" ,
                "3 3 E" ,
                "MMRMMRMRRM"};

        InputParser inputParser = new InputParser();



        Position expected = new Position(5, 1, Direction.E);

        try {

            Controller controller = new Controller(inputParser.getPlateauSize(testInput[0]),
                    inputParser.getRoverStartPosition(testInput[3]));

            Instruction[] instructions = inputParser.getInstructions(testInput[4]);

            //Act
            for (Instruction i : instructions) {
                controller.moveRover(i);

                System.out.println(controller.renderScene());
            }

            //Assert
            assertEquals(expected.getX(), controller.getRoverPosition().getX()); //expected 5 actual 3.
            assertEquals(expected.getY(), controller.getRoverPosition().getY());
            assertEquals(expected.getFacing(), controller.getRoverPosition().getFacing());


            System.out.println("rover is at position: " + controller.getRoverPosition());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void integrationTestVeryLargePlateau(){
        //Arrange
        String[] testInput = new String[]{"1000 1000",
                "1 2 N" ,
                "LMLMLMLMM" ,
                "3 3 E" ,
                "MMRMMRMRRM"};

        InputParser inputParser = new InputParser();



        Position expected = new Position(5, 1, Direction.E);

        try {

            Controller controller = new Controller(inputParser.getPlateauSize(testInput[0]),
                    inputParser.getRoverStartPosition(testInput[3]));

            Instruction[] instructions = inputParser.getInstructions(testInput[4]);

            //Act
            for (Instruction i : instructions) {
                controller.moveRover(i);

                System.out.println(controller.renderScene());
            }

            //Assert
            assertEquals(expected.getX(), controller.getRoverPosition().getX()); //expected 5 actual 3.
            assertEquals(expected.getY(), controller.getRoverPosition().getY());
            assertEquals(expected.getFacing(), controller.getRoverPosition().getFacing());


            System.out.println("rover is at position: " + controller.getRoverPosition());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}