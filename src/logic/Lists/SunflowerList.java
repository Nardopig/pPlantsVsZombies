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
    
    public void eliminateSunflower(Sunflower sunflower) {
		for(int i = 0;i<contador;i++) {
		if (!sunflowers[i].isAlive()) {
			for(int j = contador; j > i;j--) {
				sunflowers[j-1]= sunflowers[j];
			}
			contador--;
		}
		}
	}
	
}