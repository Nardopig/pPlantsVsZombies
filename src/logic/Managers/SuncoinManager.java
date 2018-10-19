package logic.Managers;

import logic.Game;

public class SuncoinManager {

	public int sunCoins;
	Game game;
	
	public SuncoinManager(Game game)
	{
		  sunCoins = 50;
		  this.game = game;
	  }
	
	public void sumaMonedas() {
		sunCoins += 10; 
	}
	
	public int getSunCoins() {
		return sunCoins;
	}

	public void setSunCoins(int sunCoins) {
		this.sunCoins = sunCoins;
	}
}
