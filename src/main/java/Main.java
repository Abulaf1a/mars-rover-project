import data.*;
import logic.Controller;
import userinterface.UI;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        ///NOTE SEE NOTES FROM CALL WITH BELA 19/11 ON STUFF TO ADD!
        UI ui = new UI();


        int[] size = ui.getPlateauSizeInput();
        Position start = ui.getStartPosition();
        Instruction[] instructions = ui.getInstructions();

        Controller controller = new Controller(size, start);

        //game logic
        while(true){

            ArrayList<Returnable> arr;
            for(Instruction i: instructions){
                arr = controller.returnData();
                ui.renderScene(arr);//currently I have a situation where I can not update the UI after the controller updates.
                controller.moveRover(i); //research how to do MVC properly - research SWING
            }
            arr = controller.returnData();
            ui.renderScene(arr);

            instructions = ui.getInstructions();

            System.out.println();

        }
    }
}
