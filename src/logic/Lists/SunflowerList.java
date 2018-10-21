package logic.Lists;

import logic.Objects.Sunflower;

public class SunflowerList {
    public Sunflower[] sunflowers;
    public int contador;

    public SunflowerList(int tam) {
        sunflowers = new Sunflower[tam];
        contador = 0;
    }

    public void addSunflower(Sunflower sunflower) {
        sunflowers[contador] = sunflower;
        contador++;
    }
    
    public void eliminateSunflower(int i) {
        sunflowers[i] = null;
        if (contador > 1) {
            while (i < contador) {
                sunflowers[i] = sunflowers[i];
                i++;
            }
        }
        contador--;
    }

}