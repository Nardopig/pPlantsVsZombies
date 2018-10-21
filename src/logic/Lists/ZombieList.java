package logic.Lists;

import logic.Objects.Zombie;

public class ZombieList {
    public Zombie[] zombies;
    public int contador;

    public ZombieList(int tam) {
        zombies = new Zombie[tam];
        contador = 0;
    }

    public void addZombie(Zombie zombie) {
        zombies[contador] = zombie;
        contador++;
    }

    public void eliminateZombies(int i) {
        zombies[i] = null;
        if (contador > 1) {
            while (i < contador) {
                zombies[i] = zombies[i + 1];
                i++;
            }
        }
        contador--;
    }
}