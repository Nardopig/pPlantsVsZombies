package logic.Objects;

import logic.Game;
import logic.Lists.PeashooterList;
import logic.Lists.SunflowerList;

public class Zombie {
    public int posX;
    public int posY;
    public int vida = 5;
    private Game game;
    public int turnoCreado;

    public Zombie(int posX, int posY, Game game) {
        turnoCreado = game.cycleCount;
        this.game = game;
        this.posX = posX;
        this.posY = posY;
    }

    public void update() {
        boolean encontradoP = false;
        boolean encontradoS = false;

        PeashooterList peashooter = game.getPeaList();
        SunflowerList sunflower = game.getSunList();

        int posNext2Zombie = posY - 1;

        if (isAlive()) {
            if (posNext2Zombie >= 0) {
                int i = 0;
                while (i < peashooter.contador && !encontradoP) {
                    if (peashooter.peashooters[i].posX == posX) {
                        if (peashooter.peashooters[i].posY == posNext2Zombie && peashooter.peashooters[i].isAlive()) {
                            encontradoP = true;
                        }
                    }
                    i++;
                }
                int j = 0;
                while (j < sunflower.contador && !encontradoS) {
                    if (sunflower.sunflowers[j].posX == posX) {
                        if (sunflower.sunflowers[j].posY == posNext2Zombie && sunflower.sunflowers[j].isAlive()) {
                            encontradoS = true;
                        }
                    }
                    j++;
                }

                if (!encontradoP && !encontradoS) {
                    if (shouldMove())
                        posY--;
                } else if (encontradoP) {
                    peashooter.peashooters[i - 1].vida--;
                    turnoCreado = game.cycleCount - 1;
                    if (!peashooter.peashooters[i - 1].isAlive())
                        peashooter.eliminatePeashooter(i - 1);
                } else if (encontradoS) {
                    sunflower.sunflowers[j - 1].vida--;
                    turnoCreado = game.cycleCount - 1;
                    if (!sunflower.sunflowers[j - 1].isAlive())
                        sunflower.eliminateSunflower(j - 1);
                }
            }
        }
    }

    public boolean shouldMove() {
        return (turnoCreado != game.cycleCount && turnoCreado % 2 == game.cycleCount % 2);
    }

    public boolean zombieWon() {
        return posY == 0 && shouldMove();
    }


    public boolean isAlive() {
        return (vida > 0);
    }
}