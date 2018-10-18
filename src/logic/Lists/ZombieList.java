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
	
	public void eliminateZombies(Peashooter peashooter) {
		for(int i = 0;i<contador;i++) {
		if (zombies[i].vida == 0) {
			for(int j = contador; j > i;j--) {
				zombies[j-1]= zombies[j];
			}
			contador--;
		}
		}
	}
}