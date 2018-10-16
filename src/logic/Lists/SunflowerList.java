package logic.Lists;

import logic.Objects.Sunflower;

public class SunflowerList {
	public Sunflower[] sun;
    int contador;
    
	public SunflowerList(int tam) {
		sun = new Sunflower[tam];
		contador = 0;
	}
	
    public void addSunflower(Sunflower sunflower) {
		sun[contador] = sunflower;
        contador++;
	}
	
}