package control;

import java.util.Scanner;

import logic.Game;

public class Controller {
	private Game game;
	private Scanner in;
	boolean finish;
	int zombiesLeftToAppear;
	
	public Controller() {
		game = new Game();
		in = new Scanner(System.in);
		finish = false;
	}
	
	
	public void run()
	{
		System.out.println("Introduce la dificultad:");
		int level = in.nextInt();
		game.setLevel(level);
		
		while(!finish)
		{
			
		}
	}
}
