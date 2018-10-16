package logic.Lists;

import logic.Objects.Zombie;

public class ZombieList {
	public Zombie[] zombies;
	private int contador;

	public ZombieList() {
		zombies = new Zombie[20];
		contador = 0;
	}
	
	public void addZombie(Zombie zombie) {
		zombies[contador]=zombie;
		contador++;
	}
}