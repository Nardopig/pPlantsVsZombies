package logic.Objects;

import logic.Game;
import logic.Lists.PeashooterList;
import logic.Lists.SunflowerList;

public class Zombie {
	public int posX;
	public int posY;
	public int vida = 5;
	private Game game;

	public Zombie(int posX, int posY , Game game) {
		this.game = game;
		this.posX=posX;
		this.posY=posY;
	}
	
	public void update() {
			boolean encontradoP = false;
			boolean encontradoS = false;
			
			PeashooterList peashooter = game.getPeaList();
			SunflowerList sunflower = game.getSunList();
			
			int posNext2Zombie = posX-1;
			
			if (isAlive()) {
				if (posNext2Zombie > 0) {
					int i = 0;
					while(i < peashooter.contador && !encontradoP) {
						if (peashooter.peashooters[i].posY == posY) {
							if (peashooter.peashooters[i].posX == posNext2Zombie && peashooter.peashooters[i].isAlive()) {
								encontradoP = true;
							}
						}
						i++;
					}
					int j = 0;
					while(j < sunflower.contador && !encontradoS) {
						if (sunflower.sunflowers[j].posY == posY) {
							if(sunflower.sunflowers[j].posX == posNext2Zombie && sunflower.sunflowers[j].isAlive()) {
								encontradoS = true;
							}
						}
						j++;
					}
					
					if(!encontradoP && !encontradoS)
						posX--;
					else if (encontradoP)
						peashooter.peashooters[i-1].vida --;
					else if (encontradoS)
						sunflower.sunflowers[j-1].vida --;	
				}
			}
	}
	
	public boolean ganaZombie() {
		 return (posX-1 == 0);
	}
	
	
	public boolean isAlive() {
		return (vida > 0);
	}
}