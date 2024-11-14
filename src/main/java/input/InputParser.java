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
    public Position getRoverStartPosition(String input) {



        return new Position(0,0, Direction.N);
    }


    //example input "LMLMMLLMMMR"
    public Instruction[] getInstruction(String input){

        return new Instruction[]{Instruction.L};


    }



}
