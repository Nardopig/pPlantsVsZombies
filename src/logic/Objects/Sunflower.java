package logic.Objects;

import logic.Game;

public class Sunflower {
	public int posX;
	public int posY;
	public int vida = 1;
	public final int coste = 50;
	public int turnoCreado;
	private Game game;

	public Sunflower(int posX, int posY, Game game) {
		this.game = game;
		this.posX=posX;
		this.posY=posY;
	}
	
	
	
	public boolean update() {
	boolean generaSol = false;
	int mod = turnoCreado%2;
	if(isAlive()) {
		if (game.contadorCiclos != turnoCreado && mod == game.contadorCiclos % 2)
			generaSol = true;
	}	
	return generaSol;
	}
	
	public boolean isAlive() {
		return (vida > 0);
	}
}