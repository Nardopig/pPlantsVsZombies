package logic.Lists;

import logic.Objects.Peashooter;
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
    	int j = contador;
		sunflowers[j-1]=null;
			if(contador > 1) {
				while(j > i) {
					sunflowers[j-1]= sunflowers[j];
					j--;
			}
		}
				contador--;
	}
	
}