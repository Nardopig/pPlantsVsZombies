package logic;

public class ZombieList {
	public Zombie[] zombies;
	private int numZombies;

	public ZombieList() {
		zombies = new Zombie[20];
		numZombies = 0;
	}
	
	public void addZombie(Zombie zom) {
		zombies[numZombies]=zom;
		numZombies++;
	}
}