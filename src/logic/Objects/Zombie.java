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
	
	public boolean update(PeashooterList peashooter, SunflowerList sunflower) {
			boolean ganaZombie = false;
			boolean encontradoP = false;
			boolean encontradoS = false;
			
			int i = posX-1;
			int j = posY;
			if (isAlive()) {
				if (i > 0) {
					int o = 0;
					int p = 0;
					while(o < peashooter.contador && !encontradoP) {
						if (peashooter.peashooters[o].posY == this.posY) {
							if (peashooter.peashooters[o].posX == i && peashooter.peashooters[i].isAlive()) {
								encontradoP = true;
							}
						}
						o++;
					}
					
					while(p < sunflower.contador && !encontradoS) {
						if (sunflower.sunflowers[p].posY == this.posY) {
							if(sunflower.sunflowers[p].posX == i && sunflower.sunflowers[p].isAlive()) {
								encontradoS = true;
							}
						}
						p++;
					}
					
					if(!encontradoP && !encontradoS)
						posX--;
					else if (encontradoP)
						peashooter.peashooters[o].vida --;
					else if (encontradoS)
						sunflower.sunflowers[p].vida --;	
				}
				else if (i == 0) {
					ganaZombie=true;
				}	
			}
			return ganaZombie;
	}
	
	
	
	public boolean isAlive() {
		return (vida > 0);
	}
}