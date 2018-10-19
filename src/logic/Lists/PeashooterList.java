package logic.Lists;

import logic.Objects.Peashooter;

public class PeashooterList {
	public Peashooter[] peashooters;
	public int contador;

	public PeashooterList(int tam) {
		peashooters = new Peashooter[tam];
		contador = 0;
	}
	
	public void addPeashooter(Peashooter peashooter) {
		peashooters[contador] = peashooter;
		contador++;
	}
	
	public void eliminatePeashooter(Peashooter peashooter) {
		for(int i = 0;i<contador;i++) {
		if (!peashooters[i].isAlive()) {
			for(int j = contador; j > i;j--) {
				peashooters[j-1]= peashooters[j];
			}
			contador--;
		}
		}
	}
}