package Model;

import java.util.Random;

import Timer.AnimationTimerEXT;

public class GameObject {
	private Direction direction;
	private double x;
	private double y;
	//elk object heeft een eigen timer voor het veranderen van de snelheid.
	private AnimationTimerEXT speedTimer;
	private double speed;
	private double rotation;
	private double rotationSpeed;
	private double hitBox;
	private Random rand;
	public GameObject() {
		//geef het object een random vliegsnelheid, rotatiesnelheid en directie.
		rand = new Random();
		speed = rand.nextInt(4)+4;
		switch(rand.nextInt(3)) {
			case 0: direction = Direction.LEFT_UP; x = 520; y = rand.nextInt(249)+251; break;
			case 1: direction = Direction.RIGHT_UP; x = -20; y = rand.nextInt(249)+251; break;
			case 2: direction = Direction.UP; y = 520; x = rand.nextInt(439)+11; break;
		}
		rotation = rand.nextInt(360);
		rotationSpeed = rand.nextInt(4);
		speedTimer = new AnimationTimerEXT(20) {
			//zodra de snelheid op 1 komt te zitten verander de richting van het object want "zwaartekracht"
			public void doAction() {
			 switch(direction) {
			 	case UP: speed = speed-0.1; if(speed <= 1) {direction = Direction.DOWN;}; break;
			 	case DOWN: speed = speed+0.1; break;
			 	case LEFT_UP: speed = speed-0.1; if(speed <= 1) {direction = Direction.LEFT_DOWN;} break;
			 	case LEFT_DOWN: speed = speed+0.1; break;
			 	case RIGHT_UP: speed = speed-0.1; if(speed <= 1) {direction = Direction.RIGHT_DOWN;} break;
			 	case RIGHT_DOWN: speed = speed+0.1; break;
			 	}
			};
		};
		speedTimer.start();
	}
	
	public void MoveObject() {
		switch(direction) {
			case UP: y = y - speed; break;
			case DOWN: y = y + speed; break;
			case LEFT_UP: x = x - speed/2; y = y - speed/2; break;
			case LEFT_DOWN: x = x - speed/2; y = y + speed/2; break;
			case RIGHT_UP: x = x + speed/2; y = y - speed/2; break;
			case RIGHT_DOWN: x = x + speed/2; y = y + speed/2; break;
		}
	}
	
	public AnimationTimerEXT getTimer() {
		return speedTimer;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRotation(){
		return rotation;
	}
	
	public double getHitBox() {
		return hitBox;
	}
	
	public void setHitBox(int size) {
		hitBox = size;
	}
	
	public void addRotation() {
		if(rotation <= 360 && rotation + speed != 360) {
			rotation = rotation + rotationSpeed;
		} else {
			rotation = 0;
		}
	}
	
	public boolean isHit(double x, double y) {
		// check of het object is geraakt door de speler.
		if((x >= this.x) && (x <= this.x + hitBox) &&  (y >= this.y) && (y <= this.y + hitBox)) {
			return true;
		} else {
			return false;
		}
	} 
	

}
