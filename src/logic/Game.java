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
	private GamePrinter gamePrinter;
	public int cycleCount;
	public static int columnas = 8;
	public static int filas = 4;
	
	
	public Game(Level level)
	{
		cycleCount = 0;
		this.level = level;
		sManager = new SuncoinManager(this);
		zManager = new ZombieManager();
		peaList = new PeashooterList(20);
		sunList = new SunflowerList(20);
		zomList = new ZombieList(20);
	} 
	
	public boolean userWon() {
		return (zManager.zombiesLeftToAppear == 0 && zomList.contador == 0);
	}
	
	public boolean computerWon() {
		int i = 0;
		while (i< zomList.contador && !zomList.zombies[i].zombieWon()) {
			i++;
		}
		return (zomList.contador > 0 && zomList.zombies[i-1].zombieWon());
	}
	
	
	public String toString() {
	gamePrinter = new GamePrinter(this,8,4);
		return gamePrinter.toString();
	}
	
	public int getSuncoins() {
		return sManager.sunCoins;
	}
	
	public int getZombiesLeftToAppear(){
		return zManager.zombiesLeftToAppear;
	}
	
	
	public void addZombie() {
		if (zManager.isZombieAdded()) {
		int j = zManager.numAleatorio();
		zomList.addZombie(new Zombie(7,j,this));
		zManager.zombiesLeftToAppear--;
		}
	}
	
	public void addPeashooter(int i,int j) {
		if (sManager.posibleCompraPeashooter()) {
			sManager.compraPeashooter();
			peaList.addPeashooter(new Peashooter(i,j,this));
		}
	}
	
	public void addSunflower(int i,int j) {
		if (sManager.posibleCompraSunflower()) {
			sManager.compraSunflower();
			sunList.addSunflower(new Sunflower(i,j,this));
		}
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
		for(int i = 0; i < zomList.contador; i++) {
			if(zomList.zombies[i].posX == x && zomList.zombies[i].posY == y) {
			a = zomList.zombies[i];
			}
		}
		return a;
	}
	
	public boolean isZInPosition(int x,int y) {
		boolean found = false; 
		for(int i = 0; i < zomList.contador; i++) {
			if(zomList.zombies[i].posX == x && zomList.zombies[i].posY == y) {
				found = true;
			}
		}
		return found;
	}
	
	public boolean isSFInPosition(int x, int y) {
		boolean found = false; 
		for(int i = 0; i < sunList.contador; i++) {
			if(sunList.sunflowers[i].posX == x && sunList.sunflowers[i].posY == y) {
				found = true;
			}
		}
		return found;
	}
	
	public boolean isPSInPosition(int x, int y) {
		boolean found = false; 
		for(int i = 0; i < peaList.contador; i++) {
			if(peaList.peashooters[i].posX == x && peaList.peashooters[i].posY == y) {
				found = true;
			}
		}
		return found;
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
		
		for(int i = 0;i<sunList.contador;i++) {
			 sunList.sunflowers[i].update();
		 }
		 for(int i = 0;i<peaList.contador;i++) {
			 peaList.peashooters[i].update();
		 }
		 for(int i = 0;i<zomList.contador;i++) {
			 zomList.zombies[i].update();
		 }
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
