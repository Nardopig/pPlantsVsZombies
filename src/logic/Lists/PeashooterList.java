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
        peashooters[i] = null;
        if (contador > 1) {
            while (i < contador) {
                peashooters[i] = peashooters[i + 1];
                i++;
            }
        }
        contador--;
    }
}