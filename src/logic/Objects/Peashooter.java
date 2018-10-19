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
		this.posX = posX;
		this.posY =	posY;
	}
	
	public void update() {
		disparar();
	}
	
	public void disparar() {
		int i = 0;
		boolean encontrado = false;
		ZombieList zList = game.getZomList();
		if (isAlive()) {
			while ( i<zList.contador && !encontrado) {
			    if (zList.zombies[i].posY==this.posY) {
			    	int j = posX + 1;
			    	while ( j < 8 && !encontrado) {
			    		if(zList.zombies[i].posX == j && zList.zombies[i].isAlive())
			    			encontrado = true;
			    		j++;
			    	}
			    }  
			    i++;
			}
		}
		if (encontrado)
			zList.zombies[i].vida --;
	}
	
	public boolean isAlive() {
		return (vida > 0);
	}
	
		public void encuentraZombie() {
			
		}
		
	}