package input;

import data.Direction;
import data.Instruction;
import data.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

//TODO split input parser into separate classes to handle different input types
public class InputParser {

    //example input "5 5"
    //PlateauSize instance output here instead of int[] array.
    public int[] getPlateauSize(String input) throws InputMismatchException{
        int[] output;

        Pattern pattern = Pattern.compile("^([0-9]+)( )+([0-9]+)( )*$");
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){
            input = input.replaceAll("\\s+", " ").trim();

            output = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            return output;
        }
        else{
            throw new InputMismatchException("Please re-enter input in format X Y where X and Y are numbers separated by only a space");
        }

    }

    //example input "1 2 N"
    public Position getRoverStartPosition(String input) throws InputMismatchException{
        int x;
        int y;
        Direction facing = Direction.N;

        //doesn't deal with positions outside the Plateau - SRP
        Pattern pattern = Pattern.compile("^([0-9]+) ([0-9]+) [NESW]$");

        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){

            String[] inputArr = input.split(" ");

            x = Integer.valueOf(inputArr[0]);

            y = Integer.valueOf(inputArr[1]);

            facing = switch (inputArr[2]) {
                case "N" -> Direction.N;
                case "S" -> Direction.S;
                case "E" -> Direction.E;
                case "W" -> Direction.W;
                default -> throw new InputMismatchException("Please enter a cardinal direction N E S W");
            };
            return new Position(x, y, facing);
        }
        else{
            throw new InputMismatchException("Please re-enter initial position in the following format: X Y D, for example 0 1 N");
        }
    }


    //example input "LMLMMLLMMMR"
    public Instruction[] getInstructions(String input) throws InputMismatchException{

        ArrayList<Instruction> instructions = new ArrayList<>();

        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {

            switch (input.charAt(i)){

                case 'L':
                    instructions.add(Instruction.L);
                    break;

                case 'R':
                    instructions.add(Instruction.R);
                    break;

                case 'M':
                    instructions.add(Instruction.M);
                    break;
            }

        }

        if(!instructions.isEmpty()){
            return instructions.toArray(new Instruction[0]);
        }
        else{
            throw new InputMismatchException("No valid input, please re-enter movement instructions" +
                    "valid characters are: L, R, M");
        }

    }

}
