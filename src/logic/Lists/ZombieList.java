package logic.Lists;

import logic.Objects.Zombie;

public class ZombieList {
	public Zombie[] zombies;
	private int contador;

	public ZombieList(int tam) {
		zombies = new Zombie[tam];
		contador = 0;
	}
	
	public void addZombie(Zombie zombie) {
		zombies[contador]=zombie;
		contador++;
	}
}