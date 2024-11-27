package data;

import java.util.ArrayList;
import java.util.Random;



public class Plateau implements Returnable {

    //TODO x and y values can become PlateauSize
    private int x;
    private int y;
    private char[][] plateau;
    private ArrayList<int[]> obstacles;

    //TODO PlateauSize could be the constructor and getters for coordinates

    //TODO -- separate out logic and data layers, eg. data layer for plateau size
    public Plateau(int x, int y, Position roverStartPosition) {
        this.x = x;
        this.y = y;
        plateau = new char[x][y];

        generateObstacles(roverStartPosition);

    }

    //Override constructor for previous test compatability
    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
        plateau = new char[x][y];

        generateObstacles(new Position(0,0,Direction.N));
    }

    private void generateObstacles(Position roverStartPosition){ //rover position NOT currently used!!

        Random rand = new Random();

        for (int i = 0; i < x/2; i++) { //possible error if the plateau is too small?
            int[] temp = new int[]{rand.nextInt(x), rand.nextInt(y)};

            plateau[temp[0]][temp[1]] = '@';
        }
    }

    public boolean isValidPosition(Position position){

        int checkX = position.getX();
        int checkY = position.getY();

        if(0 < checkY && checkY < y && 0 < checkX && checkX < x){
            System.out.println("location contains rock!");
            return plateau[checkX][checkY] != '@';
        }
        return false;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char[][] getPlateau(){
        return plateau;
    }
}
