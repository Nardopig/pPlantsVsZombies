package logic.Objects;


import logic.Game;
import logic.Lists.ZombieList;

public class Peashooter {
    public int posX;
    public int posY;
    public int vida = 3;
    public final int damage = 1;
    public final int coste = 50;
    private Game game;
    public int turnoCreado;


    public Peashooter(int posX, int posY, Game game) {
        turnoCreado = game.cycleCount;
        this.game = game;
        this.posX = posX;
        this.posY = posY;
    }

    public void update() {
        disparar();
    }

    public void disparar() {
        int i = 0;
        boolean encontrado = false;
        ZombieList zList = game.getZomList();
        if (isAlive()) {
            while (i < zList.contador && !encontrado) {
                if (zList.zombies[i].posY == this.posY) {
                    int j = posX + 1;
                    while (j < 8 && !encontrado) {
                        if (zList.zombies[i].posX == j && zList.zombies[i].isAlive())
                            encontrado = true;
                        j++;
                    }
                }
                i++;
            }
        }
        if (encontrado && turnoCreado != zList.zombies[i - 1].turnoCreado) {
            zList.zombies[i - 1].vida--;
            if (!zList.zombies[i - 1].isAlive())
                zList.eliminateZombies(i - 1);
        }
    }

    public boolean isAlive() {
        return (vida > 0);
    }

    public void encuentraZombie() {

    }

}