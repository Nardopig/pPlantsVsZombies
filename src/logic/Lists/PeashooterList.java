package logic.Lists;

import logic.Objects.Peashooter;

public class PeashooterList {
    public Peashooter[] peashooters;
    public int contador;

    public PeashooterList(int tam) {
        peashooters = new Peashooter[tam];
        contador = 0;
    }

    public void addPeashooter(Peashooter peashooter) {
        peashooters[contador] = peashooter;
        contador++;
    }

    public void eliminatePeashooter(int i) {
        int j = contador;
        peashooters[j - 1] = null;
        if (contador > 1) {
            while (j > i) {
                peashooters[j - 1] = peashooters[j];
                j--;
            }
        }
        contador--;
    }
}