package userinterface;

import data.Plateau;
import data.Position;
import data.Returnable;

import java.util.ArrayList;

public class UI {

    //Takes the rendered scene from the
    public void renderScene(ArrayList<Returnable> arr){

        try{
            Plateau plateau = validatePlateau(arr.get(0));
            Position roverPosition = validatePosition(arr.get(1));

            StringBuilder sceneBuilder = new StringBuilder();

            String red = "\u001B[31m";
            String background = " \u001B[43m";
            String reset = "\u001B[0m";

            for (int i = plateau.getY() -1; i > -1; i--) {
                sceneBuilder.append(red + background);

                for (int j = 0; j < plateau.getX(); j++) {
                    if(j == roverPosition.getX() && i == roverPosition.getY()){
                        sceneBuilder.append("\u001B[30m");

                        sceneBuilder.append('#');
                        sceneBuilder.append(red);

                    }
                    else{
                        sceneBuilder.append(plateau.getPlateau()[j][i]);
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

    private Position validatePosition(Returnable position) throws IllegalArgumentException{

        if (position instanceof  Position){
            return (Position) position;
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
