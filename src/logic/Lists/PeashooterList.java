package logic.Lists;

import logic.Objects.Peashooter;

public class PeashooterList {
	public Peashooter[] peas;
	private int contador;

	public PeashooterList(int tam) {
		peas = new Peashooter[tam];
	}
	
	public void addPeashooter(Peashooter peashooter) {
		peas[contador] = peashooter;
		contador++;
	}
}