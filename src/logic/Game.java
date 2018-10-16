package logic;

import java.util.Random;

import logic.Lists.PeashooterList;
import logic.Lists.SunflowerList;
import logic.Lists.ZombieList;
import logic.Objects.Zombie;

public class Game {
	private PeashooterList peaList;
	private SunflowerList  sunList;
	private ZombieList zomList;
	private Random rand;
	public static int contCiclos, contSoles, contPea, contSun, contZom;
	
	// O CREAR EN LAS LISTAS METODOS QUE AUMENTEN EL CONTADOR Y CREEN OBJETOS CON PARAMETROS
	
	public static int contador = 0;
	public Game()
	{
		peaList = new PeashooterList(4);
		sunList = new SunflowerList();
		zomList = new ZombieList();
	} 
	
	public void addZombie(Zombie zom) {
		zomList.addZombie(zom);
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
	
	
	
	private Object addZombie(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}


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
