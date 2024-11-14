import java.util.Arrays;

public class Plateau {

    private int x;
    private int y;
    private int[][] plateau;



    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
        plateau = new int[x][y];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getPlateau(){
        return plateau;
    }


    @Override
    public String toString() {

        StringBuilder plateauDisplay = new StringBuilder();
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {

                plateauDisplay.append(plateau[i][j]);
            }
            plateauDisplay.append("\n");
        }
        return plateauDisplay.toString();

    }
}
