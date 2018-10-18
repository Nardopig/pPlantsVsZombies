package logic.Objects;


import logic.*;
import logic.Lists.ZombieList;

public class Peashooter {
	public int posX;
	public int posY;
	public int vida = 3;
	public final int damage = 1;
	public final int coste = 50;
	private Game game;
	

	public Peashooter(int posX, int posY, Game game) {
		this.game = game;
		this.posX=posX;
		this.posY=posY;
	}
	
	public void update(ZombieList zombies) {
		disparar(zombies);
	}
	
	public void disparar(ZombieList zombies) {
		int i = 0;
		boolean encontrado = false;
		if (isAlive()) {
		while ( i<zombies.contador && !encontrado) {
		    if (zombies.zombies[i].posY==this.posY) {
		    	int j = posX + 1;
		    	while ( j < 8 && !encontrado) {
		    		if(zombies.zombies[i].posX == j && zombies.zombies[i].isAlive())
		    			encontrado = true;
		    		j++;
		    	}
		    }  
		    i++;
			}
		}
		if (encontrado)
			zombies.zombies[i].vida --;
	}
	
	public boolean isAlive() {
		return (vida > 0);
	}
	
		public void encuentraZombie() {
			
		}
		
	}