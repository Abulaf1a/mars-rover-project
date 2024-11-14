package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    //can't be tested...
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
}