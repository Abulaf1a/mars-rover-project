package data;

public class Plateau {

    private int x;
    private int y;
    private char[][] plateau;

    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
        plateau = new char[x][y];
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

    //Unused except in test functionality has been moved to controller class.
    @Override
    public String toString() {

        StringBuilder plateauDisplay = new StringBuilder();
        for (int i = y; i > 0; i--) { // y axis
            for (int j = 0; j < x; j++) {

                plateauDisplay.append(plateau[j][i]); //i = y, j = x
            }
            plateauDisplay.append("\n");
        }
        return plateauDisplay.toString();

    }

    public boolean isValidPosition(Position position){
        return(position.getY() <= y && position.getX() <= x);
    }
}
