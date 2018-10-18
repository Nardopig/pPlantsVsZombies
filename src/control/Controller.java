package control;

import java.util.Scanner;
import logic.Level;
import logic.Game;

public class Controller {
	private Game game;
	private Scanner in;
	boolean finish;
	int zombiesLeftToAppear;
	
	public Controller(Level level) {
		game = new Game(level);
		in = new Scanner(System.in);
		finish = false;
	}
	
	
	public void run()
	{
		
		while(!finish)
		{
			
		}
	}
}
