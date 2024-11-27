package userinterface;

import data.*;
import input.InputParser;
import logic.Rover;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    private static InputParser inputParser = new InputParser();

    //Takes the rendered scene from the
    public int[] getPlateauSizeInput(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            try{

                System.out.println("Please enter plateau size ");

                int[] size = inputParser.getPlateauSize(scanner.nextLine());
                return size;
            } catch (Exception e) {
                System.out.println();
            }
        }
    }


    public Position getStartPosition(){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);

                System.out.println("Please enter rover start position");

                Position position = inputParser.getRoverStartPosition(scanner.nextLine());

                return position;
            }
            catch (Exception e){
                System.out.println();
            }
        }
    }

    public Instruction[] getInstructions(){

        while(true){
            try{
                System.out.println("Please enter instructions:");

                Scanner scanner = new Scanner(System.in);

                return inputParser.getInstructions(scanner.nextLine());
            } catch (Exception e) {
                System.out.println();
            }
        }
    }


    //TODO use methods to update positions of rover according to instructions
    public void renderScene(ArrayList<Returnable> arr){

        try{
            Plateau plateau = validatePlateau(arr.get(0)); //instanceof
            Rover rover = validateRover(arr.get(1));

            StringBuilder sceneBuilder = new StringBuilder();

            String black = "\u001B[30m";
            String yellow = "\u001B[33m";
            String red = "\u001B[31m";
            String background = " \u001B[43m";
            String reset = "\u001B[0m";

            for (int i = plateau.getY() -1; i > -1; i--) {
                sceneBuilder.append( background);

                for (int j = 0; j < plateau.getX(); j++) {

                    if(rover.getPosition().getFacing() == Direction.E || rover.getPosition().getFacing() == Direction.W){
                        if(j == rover.getPosition().getX() && i == rover.getPosition().getY() - (rover.getBody().length/2)){
                            sceneBuilder.append(black);
                            sceneBuilder.append(rover.getBody()[0]);
                            sceneBuilder.append(yellow);
                            sceneBuilder.append(background);

                            j++;
                        }
                        else if(j == rover.getPosition().getX() && i == rover.getPosition().getY()){
                            sceneBuilder.append(black);
                            sceneBuilder.append(rover.getBody()[1]);
                            sceneBuilder.append(yellow);
                            sceneBuilder.append(background);

                            j++;
                        }
                        else if(j == rover.getPosition().getX() && i == rover.getPosition().getY() + (rover.getBody().length/2)){
                            sceneBuilder.append(black);
                            sceneBuilder.append(rover.getBody()[2]);
                            sceneBuilder.append(yellow);
                            sceneBuilder.append(background);

                            j++;
                        }
                        else{
                            if(plateau.getPlateau()[j][i] == '@'){
                                sceneBuilder.append(red);
                            }
                            sceneBuilder.append(plateau.getPlateau()[j][i]);
                            sceneBuilder.append(yellow);
                        }
                    }
                    else if(rover.getPosition().getFacing() == Direction.N || rover.getPosition().getFacing() == Direction.S){
                        if(j == rover.getPosition().getX()-(rover.getBody().length/2) && i == rover.getPosition().getY()){
                            sceneBuilder.append(black);
                            for(char c: rover.getBody()){
                                sceneBuilder.append(c);
                            }
                            j+=rover.getBody().length;
                            sceneBuilder.append(yellow);
                            sceneBuilder.append(background);

                        }

                        else{
                            if(plateau.getPlateau()[j][i] == '@'){
                                sceneBuilder.append(red);
                            }
                            sceneBuilder.append(plateau.getPlateau()[j][i]);
                            sceneBuilder.append(yellow);
                        }
                    }
                }
                sceneBuilder.append(reset);
                sceneBuilder.append("\n");
            }
            System.out.println(sceneBuilder.toString());
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    private Rover validateRover(Returnable rover) throws IllegalArgumentException{

        if (rover instanceof Rover){
            return (Rover) rover;
        }
        else{
            throw new IllegalArgumentException("Unable to convert returnable back to position");
        }
    }

    private Plateau validatePlateau(Returnable plateau){
        if (plateau instanceof  Plateau){
            return (Plateau) plateau;
        }
        else{
            throw new IllegalArgumentException("Unable to convert returnable back to position");
        }
    }

}
