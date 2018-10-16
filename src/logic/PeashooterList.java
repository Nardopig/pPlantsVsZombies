package logic;

public class PeashooterList {
	public Peashooter[] peas;

	public PeashooterList(int tam) {
		peas = new Peashooter[tam];
	}
	
	
	public Peashooter addPeashooter(int posx , int posy) {
		Peashooter a = null;
		a.posx=posx;
		a.posy=posy;
	return a;
	}
}