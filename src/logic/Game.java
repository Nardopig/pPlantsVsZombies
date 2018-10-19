package logic;

import java.util.Random;
import logic.Lists.*;
import logic.Managers.*;
import logic.Objects.*;



public class Game {
	private PeashooterList peaList;
	private SunflowerList  sunList;
	private ZombieList zomList;
	private Random rand;
	private ZombieManager zManager;
	private SuncoinManager sManager;
	private Level level;
	public int contadorCiclos;
	public static int columnas = 8;
	public static int filas = 4;
	
	
	public Game(Level level)
	{
		contadorCiclos = 0;
		this.level = level;
		sManager = new SuncoinManager(this);
		zManager = new ZombieManager();
		peaList = new PeashooterList(20);
		sunList = new SunflowerList(20);
		zomList = new ZombieList(20);
	} 
	
	
	public void addZombie() {
		if (zManager.isZombieAdded()) {
		int j = zManager.numAleatorio();
		zomList.addZombie(new Zombie(7,j,this));
		}
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
	
	public void setLevel(Level level) {
		switch(level) {
		case EASY:
			zManager.setZombiesLeftToAppear(3);
			zManager.setFrecuencia(0.1);
			break;
		case MEDIUM:
			zManager.setZombiesLeftToAppear(5);
			zManager.setFrecuencia(0.2);
			break;
		case HARD:
			zManager.setZombiesLeftToAppear(10);
			zManager.setFrecuencia(0.3);
			break;
		}
	}
	
	public void update() {
	 for(int i = 0;i<zomList.contador;i++) {
		 zomList.zombies[i].update();
	 }
	 for(int i = 0;i<sunList.contador;i++) {
		 sunList.sunflowers[i].update();
	 }
	 for(int i = 0;i<peaList.contador;i++) {
		 peaList.peashooters[i].update();
	 }
	}
	
	public boolean compraPeashooter() {
		return true;
	}
	
	public boolean compraSunflower() {
		return true;
	}
	
	public PeashooterList getPeaList() {
		return peaList;
	}



	public void setPeaList(PeashooterList peaList) {
		this.peaList = peaList;
	}



	public SunflowerList getSunList() {
		return sunList;
	}



	public void setSunList(SunflowerList sunList) {
		this.sunList = sunList;
	}



	public ZombieList getZomList() {
		return zomList;
	}


	public void setZomList(ZombieList zomList) {
		this.zomList = zomList;
	}


	public ZombieManager getzManager() {
		return zManager;
	}


	public void setzManager(ZombieManager zManager) {
		this.zManager = zManager;
	}


	public SuncoinManager getsManager() {
		return sManager;
	}


	public void setsManager(SuncoinManager sManager) {
		this.sManager = sManager;
	}
	

}
