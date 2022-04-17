package animalPackage;

public class Bat extends Mammal {
	
	public Bat() {
		super(300);
	}
	
	public void fly() {
		System.out.println("*wings flapping aggressively*");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("*obnoxious slurping*");
		energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("MY LEG!! (spongebob reference)");
		energyLevel -= 100;
	}
}
