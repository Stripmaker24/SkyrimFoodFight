package Model;

import java.util.Random;

public class Fruit extends GameObject {
	private FruitType fruit;
	private Random rand;
	public Fruit() {
		rand = new Random();
		switch(rand.nextInt(2)) {
		case 0: fruit = FruitType.BIG; setHitBox(45); break;
		case 1: fruit = FruitType.SMALL; setHitBox(30); break;
		}
	}
	
	public FruitType getFruit() {
		return fruit;
	}
	
	public int givePoints() {
		int point = 0;
		switch(fruit) {
		case BIG: point = 50; break;
		case SMALL: point = 30; break;
		}
		return point;
	}
	
}
