import data.Controller;
import data.Direction;
import data.Instruction;
import data.Position;
import input.InputParser;
import input.NotEqualToTwoIntegersException;

public class Main {

    public static void main(String[] args) {

        String[] testInput = new String[]{"5 5",
                "1 2 N" ,
                "LMLMLMLMM" ,
                "3 3 E" ,
                "MMRMMRMRRM"};

        InputParser inputParser = new InputParser();

        try{
            Controller controllerA = new Controller(inputParser.getPlateauSize(testInput[0]),
                    inputParser.getRoverStartPosition(testInput[1]));

            Instruction[] instructions = inputParser.getInstructions(testInput[2]);

            for(Instruction i : instructions){
                controllerA.moveRover(i);

                System.out.println(controllerA.renderScene());
            }
            System.out.println("rover is at position: " + controllerA.getRoverPosition());


            Controller controllerB = new Controller(inputParser.getPlateauSize(testInput[0]),
                    inputParser.getRoverStartPosition(testInput[3]));

            instructions = inputParser.getInstructions(testInput[4]);
            for(Instruction i : instructions){
                controllerB.moveRover(i);

                System.out.println(controllerB.renderScene());
            }

            System.out.println("rover is at position: " + controllerB.getRoverPosition());




        } catch (NotEqualToTwoIntegersException e) {
            throw new RuntimeException(e);
        }


        String red = "\u001B[31m";
        String background = " \u001B[43m";
        String reset = "\u001B[0m";
        System.out.println(red + background+ " hello this is green " + reset);


    }




}
