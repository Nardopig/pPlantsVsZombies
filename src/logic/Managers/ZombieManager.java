package logic.Managers;

import java.util.Random;

public class ZombieManager {
	int zombiesLeftToAppear;
	Random rand;
	double frecuencia;
	
	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}

	public ZombieManager(){
		rand = new Random(System.nanoTime());	
	}

	public boolean isZombieAdded() {
		double x;
		x = rand.nextDouble();
		
		return (zombiesLeftToAppear > 0 && x < frecuencia);			
	}
	
	public int getZombiesLeftToAppear() {
		return zombiesLeftToAppear;
	}
	
	public void setZombiesLeftToAppear(int zombiesLeftToAppear) {
		this.zombiesLeftToAppear = zombiesLeftToAppear;
	}
	
	public void restarZombiesLeftToAppear() {
		zombiesLeftToAppear--;
	}
}
