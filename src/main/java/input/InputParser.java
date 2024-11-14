package input;

import data.Direction;
import data.Instruction;
import data.Position;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

//TODO split input parser into separate classes to handle different input types
public class InputParser {

    //example input "5 5"
    public int[] getPlateauSize(String input) throws InputMismatchException, NotEqualToTwoIntegersException{
        int[] output;
        char[] inputArr = input.toCharArray();
        try {
            output = new String(inputArr).chars()
                .filter(c -> c != ' ')
                .map(c -> c - 48)
                .limit(2)
                .toArray();
        }

        catch (InputMismatchException e){
            throw new InputMismatchException("Please re-enter plateau size coordinates without letters!");
        }

        if(output.length != 2){
            throw new NotEqualToTwoIntegersException("Please write TWO integers only");
        }

        return output;


    }


    //example input "1 2 N"
    public Position getRoverStartPosition(String input) throws InputMismatchException{

        int x;
        int y;
        Direction facing = Direction.N;

        //doesn't deal with positions outside the Plateau - SRP
        Pattern pattern = Pattern.compile("^([0-9]+) ([0-9]+) [N|E|S|W]$");

        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){

            String[] inputArr = input.split(" ");

            x = Integer.valueOf(inputArr[0]);

            y = Integer.valueOf(inputArr[1]);

            switch (inputArr[2]) {
                case "N":
                    facing = Direction.N;
                    break;
                case "S":
                    facing = Direction.S;
                    break;

                case "E":
                    facing = Direction.E;
                    break;

                case "W":
                    facing = Direction.W;
                    break;
            }
            return new Position(x, y, facing);
        }
        else{
            throw new InputMismatchException("Please re-enter initial position in the following format: X Y D, for example 0 1 N");
        }
    }


    //example input "LMLMMLLMMMR"
    public Instruction[] getInstruction(String input){


        return new Instruction[]{Instruction.L};


    }



}
