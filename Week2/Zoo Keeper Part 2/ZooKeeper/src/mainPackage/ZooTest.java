package mainPackage;

import animalPackage.Bat;
import animalPackage.Gorilla;

public class ZooTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla gorilla1 = new Gorilla(100);
		
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		
		gorilla1.eatBananas();
		gorilla1.eatBananas();
		
		gorilla1.climb();
		
		gorilla1.displayEnergy();
		
		Bat bat1 = new Bat();
		
		bat1.attackTown();
		bat1.attackTown();
		bat1.attackTown();
		
		bat1.eatHumans();
		bat1.eatHumans();
		
		bat1.fly();
		bat1.fly();
		
		bat1.displayEnergy();
	}

}
