package control;

import java.util.Scanner;
import logic.Level;
import logic.Objects.Peashooter;
import logic.Game;

public class Controller {
	private Game game;
	private Scanner in;
	boolean finish;
	Peashooter peashooter;
	Level level;

	
	public Controller(Level level) {
		this.level = level;
		game = new Game(level);
		in = new Scanner(System.in);
		finish = false;
		peashooter = new Peashooter(0,0,game);
	}
	
	
	public void run()
	{
		game.setLevel(level);
		game.addZombie();
		game.addPeashooter(peashooter);
		game.update();
		
		/*while(!finish)
		{	
		}*/
	}
}
