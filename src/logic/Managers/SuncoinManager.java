package logic.Managers;

import logic.Game;

public class SuncoinManager {

    public int sunCoins;
    private int precioPeashooter;
    private int precioSunflower;
    Game game;

    public SuncoinManager(Game game) {
        sunCoins = 50;
        precioPeashooter = 50;
        precioSunflower = 50;
        this.game = game;
    }

    public void sumaMonedas() {
        sunCoins += 10;
    }

    public void compraSunflower() {
        sunCoins -= precioSunflower;
    }

    public void compraPeashooter() {
        sunCoins -= precioPeashooter;
    }

    public boolean posibleCompraPeashooter() {
        return (sunCoins >= precioPeashooter);
    }

    public boolean posibleCompraSunflower() {
        return (sunCoins >= precioSunflower);
    }

    public int getSunCoins() {
        return sunCoins;
    }

    public void setSunCoins(int sunCoins) {
        this.sunCoins = sunCoins;
    }
}
