package control;

import java.util.Scanner;
import logic.Level;
import logic.Lists.ZombieList;
import logic.Objects.Peashooter;
import logic.Game;

public class Controller {
	private Game game;
	private Scanner in;
	boolean finish;
	Level level;

	
	public Controller(Level level) {
		this.level = level;
		game = new Game(level);
		game.setLevel(level);
		in = new Scanner(System.in);
		finish = false;
	}
	
	
	public void run()
	{
		while(!finish) {
		game.update();
		System.out.println("Number of cycles: "+ game.cycleCount);
		System.out.println("Sun coins: "+ game.getSuncoins());
		System.out.println("Remaining zombies: " + game.getZombiesLeftToAppear());
		System.out.println();
		System.out.print(game.toString());
		System.out.println();
		comandExe();
		System.out.println();
		
		game.addZombie();
		if(game.computerWon()||game.userWon()) {
			finish = true;
		}
		else {
			game.cycleCount++;
		}
		}
	}

	private void comandExe() {
	System.out.print("Command > ");
	String comando;
	comando=in.next();
	comando = comando.toLowerCase(); //pone el string entero a minusculas
		if(comando.equals("add") || comando.equals("a"))
		{
		comando = in.next();
		comando.toLowerCase();
		int i,j;
		i = in.nextInt();
		j = in.nextInt();
		if(comando.equals("p")) {
			game.addPeashooter(i, j);
		}else if (comando.equals("s")) {
			game.addSunflower(i, j);
		}
		}
		else if(comando.equals("list")||comando.equals("l"))
		{
			System.out.println("[S]unflower: Cost: 20 suncoins Harm: 0");
			System.out.println("[P]eashooter: Cost: 50 suncoins Harm: 1");
			
		}
		else if(comando.equals("reset")||comando.equals("r"))
		{
			game = new Game(level);
			game.setLevel(level);
		}
		else if(comando.equals("help")|| comando.equals("h"))
		{
			System.out.println("Add <plant> <x> <y>: Adds a plant in position x, y.");
			System.out.println("List: Prints the list of available plants.");
			System.out.println("Reset: Starts a new game.");
			System.out.println("Help: Prints this help message.");
			System.out.println("Exit: Terminates the program.");
			System.out.println("[none]: Skips cycle.");
		}
		else if(comando.equals("exit")||comando.equals("e"))
		{
			System.out.println("Game Over");
			finish = true;
		}
		else if(comando.equals("none")||comando.equals("n")||comando.equals(null))
		{
			
		}
		
	}
}
