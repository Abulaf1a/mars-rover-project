import data.Controller;
import data.Direction;
import data.Instruction;
import data.Position;
import input.InputParser;

public class Main {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();

        Controller controller = new Controller(new int[]{5,7}, new Position(1, 2, Direction.N));

        System.out.println(controller.renderScene());
        System.out.println("rover is at position: " + controller.getRoverPosition());
        System.out.println();

        controller.moveRover(Instruction.M);
        System.out.println(controller.renderScene());
        System.out.println("rover is at position: " + controller.getRoverPosition());
        System.out.println();

        controller.moveRover(Instruction.M);
        System.out.println(controller.renderScene());
        System.out.println("rover is at position: " + controller.getRoverPosition());
        System.out.println();

        controller.moveRover(Instruction.L);
        System.out.println(controller.renderScene());
        System.out.println("rover is at position: " + controller.getRoverPosition());
        System.out.println();

        controller.moveRover(Instruction.M);
        System.out.println(controller.renderScene());
        System.out.println("rover is at position: " + controller.getRoverPosition());
        System.out.println();


    }




}
