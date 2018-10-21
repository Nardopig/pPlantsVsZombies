package plantsVsZombies;

import control.Controller;
import logic.Level;

public class Main {


    public static void main(String[] args) {
        Controller controller = new Controller(Level.valueOf(args[0]));
        controller.run();
    }

}
