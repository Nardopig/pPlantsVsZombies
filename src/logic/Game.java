package logic;

import logic.Lists.PeashooterList;
import logic.Lists.SunflowerList;
import logic.Lists.ZombieList;
import logic.Managers.SuncoinManager;
import logic.Managers.ZombieManager;
import logic.Objects.Peashooter;
import logic.Objects.Sunflower;
import logic.Objects.Zombie;

import java.util.Random;


public class Game {
    private PeashooterList peaList;
    private SunflowerList sunList;
    private ZombieList zomList;
    private ZombieManager zManager;
    private SuncoinManager sManager;
    private GamePrinter gamePrinter;
    private Random rand;

    public final int LINES = 4;
    public final int ROWS = 8;

    public int cycleCount;

    public Game(Level level) {
        cycleCount = 0;
        sManager = new SuncoinManager(this);
        zManager = new ZombieManager();
        peaList = new PeashooterList(20);
        sunList = new SunflowerList(20);
        zomList = new ZombieList(20);
        rand = new Random(System.nanoTime());
        setLevel(level);
    }

    public boolean userWon() {
        return (zManager.zombiesLeftToAppear == 0 && zomList.contador == 0);
    }

    public boolean computerWon() {
        boolean zombiesWon = false;
        for (int i = 0; i < zomList.zombies.length; i++) {
            if (zomList.zombies[i] != null && zomList.zombies[i].zombieWon()) {
                zombiesWon = true;
                break;
            }
        }

        return zombiesWon;
    }


    public String toString() {
        gamePrinter = new GamePrinter(this, LINES, ROWS);
        return gamePrinter.toString();
    }

    public int getSuncoins() {
        return sManager.sunCoins;
    }

    public int getZombiesLeftToAppear() {
        return zManager.zombiesLeftToAppear;
    }


    public void addZombie() {
        if (zManager.isZombieAdded()) {
            int randomLine = rand.nextInt(LINES);
            zomList.addZombie(new Zombie(randomLine, ROWS - 1, this));
            zManager.zombiesLeftToAppear--;
        }
    }

    public void addPeashooter(int line, int row) {
        if (sManager.posibleCompraPeashooter()) {
            sManager.compraPeashooter();
            peaList.addPeashooter(new Peashooter(line, row, this));
        }
    }

    public void addSunflower(int line, int row) {
        if (sManager.posibleCompraSunflower()) {
            sManager.compraSunflower();
            sunList.addSunflower(new Sunflower(line, row, this));
        }
    }

    public Sunflower getSFInPosition(int line, int row) {
        Sunflower a = null;
        for (int i = 0; i < sunList.contador; i++) {
            if (sunList.sunflowers[i].posX == line && sunList.sunflowers[i].posY == row) {
                a = sunList.sunflowers[i];
            }
        }
        return a;
    }

    public Peashooter getPSInPosition(int line, int row) {
        Peashooter a = null;
        for (int i = 0; i < peaList.contador; i++) {
            if (peaList.peashooters[i].posX == line && peaList.peashooters[i].posY == row) {
                a = peaList.peashooters[i];
            }
        }
        return a;
    }

    public Zombie getZInPosition(int line, int row) {
        Zombie a = null;
        for (int i = 0; i < zomList.contador; i++) {
            if (zomList.zombies[i].posX == line && zomList.zombies[i].posY == row) {
                a = zomList.zombies[i];
            }
        }
        return a;
    }

    public boolean isZInPosition(int line, int row) {
        boolean found = false;
        for (int i = 0; i < zomList.contador; i++) {
            if (zomList.zombies[i].posX == line && zomList.zombies[i].posY == row) {
                found = true;
            }
        }
        return found;
    }

    public boolean isSFInPosition(int line, int row) {
        boolean found = false;
        for (int i = 0; i < sunList.contador; i++) {
            if (sunList.sunflowers[i].posX == line && sunList.sunflowers[i].posY == row) {
                found = true;
            }
        }
        return found;
    }

    public boolean isPSInPosition(int line, int row) {
        boolean found = false;
        for (int i = 0; i < peaList.contador; i++) {
            if (peaList.peashooters[i].posX == line && peaList.peashooters[i].posY == row) {
                found = true;
            }
        }
        return found;
    }

    public void setLevel(Level level) {
        switch (level) {
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

        for (int i = 0; i < sunList.contador; i++) {
            sunList.sunflowers[i].update();
        }
        for (int i = 0; i < peaList.contador; i++) {
            peaList.peashooters[i].update();
        }
        for (int i = 0; i < zomList.contador; i++) {
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
