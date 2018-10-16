package logic;

import java.util.Random;

import logic.Lists.PeashooterList;
import logic.Lists.SunflowerList;
import logic.Lists.ZombieList;
import logic.Objects.Peashooter;
import logic.Objects.Sunflower;
import logic.Objects.Zombie;


public class Game {
	private PeashooterList peaList;
	private SunflowerList  sunList;
	private ZombieList zomList;
	private Random rand;
	
	// O CREAR EN LAS LISTAS METODOS QUE AUMENTEN EL CONTADOR Y CREEN OBJETOS CON PARAMETROS
	
	public static int contador = 0;
	public Game()
	{
		peaList = new PeashooterList(20);
		sunList = new SunflowerList(20);
		zomList = new ZombieList(20);
	} 
	
	public void addZombie(Zombie zombie) {
		zomList.addZombie(zombie);
	}
	
	public void addPeashooter(Peashooter peashooter) {
		peaList.addPeashooter(peashooter);
	}
	
	public void addSunflower(Sunflower sunflower) {
		sunList.addSunflower(sunflower);
	}
	
	public Sunflower getSFInPosition(int x, int y) {
		Sunflower a = null;
		for(int i = 0; i < sunList.contador; i++) {
		if(sunList.sunflowers[i].posX == x && sunList.sunflowers[i].posY == y) {
			a= sunList.sunflowers[i];
		}
		}
		return a;
	}
	
	public Peashooter getPSInPosition(int x, int y) {
		Peashooter a = null;
		for(int i = 0; i < peaList.contador; i++) {
		if(peaList.peashooters[i].posX == x && peaList.peashooters[i].posY == y) {
			a= peaList.peashooters[i];
		}
		}
		return a;
	}
	
	public Zombie getZInPosition(int x, int y) {
		Zombie a = null;
		for(int i = 0; i < sunList.contador; i++) {
		if(zomList.zombies[i].posX == x && zomList.zombies[i].posY == y) {
			a = zomList.zombies[i];
		}
		}
		return a;
	}
	
	
	/*
	public void generateZombie(ZombieList zL, int contZomb,int dificultad) {
		rand = new Random(System.nanoTime());
		int x;
		//dificultad 10,20,30;
		if(dificultad < rand) {
			x=7;
		}
		rand = new Random(System.nanoTime());
		    int y=rand;
		    
			zomList[contZomb] = addZombie(x,y);
		
		
	}
	*/
	


	public int update() {
	 
		
		
		return 0;
	}
	
	
	
	/*public boolean avanzar(int posx, int posy)
	{
		boolean puede=true;
		int x=posx-1;
		
		verificarP(list,x,posy);
		list.getlist();
		return puede;
	}*/

}
