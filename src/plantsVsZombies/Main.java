package plantsVsZombies;

import logic.Game;
import logic.GamePrinter;
import logic.Objects.Peashooter;
import logic.Objects.Sunflower;
import logic.Objects.Zombie;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		Zombie zombie = new Zombie(0,0);
		Peashooter peashooter = new Peashooter(0, 0);
		Sunflower sunflower = new Sunflower(0,0);
		game.addZombie(zombie);
		game.addPeashooter(peashooter);
		game.addSunflower(sunflower);
		
	}

}
