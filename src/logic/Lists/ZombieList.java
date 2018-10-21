package logic.Lists;

import logic.Objects.Peashooter;
import logic.Objects.Zombie;

public class ZombieList {
	public Zombie[] zombies;
	public int contador;

	public ZombieList(int tam) {
		zombies = new Zombie[tam];
		contador = 0;
	}
	
	public void addZombie(Zombie zombie) {
		zombies[contador]=zombie;
		contador++;
	}
	
	public void eliminateZombies(int i) {
		int j = contador;
		zombies[j-1]=null;
			if(contador > 1) {
				while(j > i) {
					zombies[j-1]= zombies[j];
					j--;
			}
		}
				contador--;
	}
		
}