package logic.Lists;

import logic.Objects.Sunflower;

public class SunflowerList {
	public Sunflower[] sun;
    int contador;
    
	public SunflowerList() {
		sun = new Sunflower[20];
	}
	
    public void addSunflower(Sunflower sunflower) {
		sun[contador] = sunflower;
        contador++;
	}
	
}