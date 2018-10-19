package plantsVsZombies;

import control.Controller;
import logic.*;
import logic.GamePrinter;
import logic.Level;
import logic.Objects.Peashooter;
import logic.Objects.Sunflower;
import logic.Objects.Zombie;

public class Main {
	

	public static void main(String[] args) {
		Controller controller = new Controller(Level.valueOf(args[0]));
		controller.run();
	}

}
