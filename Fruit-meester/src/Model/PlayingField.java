package Model;

import java.util.ArrayList;
import java.util.Random;

public class PlayingField {
	private ArrayList<GameObject> objects;
	private Random rand;
	private SlashTrailSection slash;
	private int score;
	private int lives;
	private boolean gameOver = false;
	private boolean hit = false;

	public PlayingField() {
		objects = new ArrayList<GameObject>();
		rand = new Random();
		slash = new SlashTrailSection();
		lives = 3;
	}
	
	public void addObject() {
		switch(rand.nextInt(2)) {
			case 0: objects.add(new Fruit()); break;
			case 1: objects.add(new Bomb()); break;
		}
	}
	
	public void moveObjects() {
		// beweeeg objecten. als een object buiten het scherm is verwijder hem dan.
		for(int x = 0; x < objects.size(); x++) {
			switch(objects.get(x).getDirection()) {
				case UP: objects.get(x).MoveObject(); break;
				case DOWN: objects.get(x).MoveObject(); if(objects.get(x).getX() >= 520) {objects.remove(x);}; break;
				case LEFT_UP: objects.get(x).MoveObject(); if(objects.get(x).getX() <= -20 || objects.get(x).getY() <= -20) {objects.remove(x);}; break;
				case LEFT_DOWN: objects.get(x).MoveObject(); if(objects.get(x).getX() <= -20 || objects.get(x).getY() >= 520) {objects.remove(x);}; break;
				case RIGHT_UP:objects.get(x).MoveObject(); if(objects.get(x).getX() >= 520 || objects.get(x).getY() <= -20) {objects.remove(x);}; break;
				case RIGHT_DOWN:objects.get(x).MoveObject(); if(objects.get(x).getX() >= 520 || objects.get(x).getY() >= 520) {objects.remove(x);}; break;
			}
		}
	}
	
	public void removeHitObject(double xCoord, double yCoord) {
		//doe dit als een object is geraakt.
		for(int x = 0; x < objects.size(); x++) {
			if(objects.get(x).isHit(xCoord, yCoord)) {
				switch(objects.get(x).getClass().getSimpleName()) {
				case "Fruit": Fruit fruit = (Fruit) objects.get(x); score = score + fruit.givePoints(); objects.remove(x); hit = true; break;
				case "Bomb": lives--; objects.remove(x); hit = true; break;
				}
			}
		}
	}
	public ArrayList<GameObject> getObjects(){
		return objects;
	}
	
	public boolean objectsIsEmpty() {
		if(objects.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void PauseObjects() {
		for(GameObject object: objects) {
			object.getTimer().stop();
		}
	}
	
	public void resumeObjects() {
		for(GameObject object: objects) {
			object.getTimer().start();
		}
	}
	
	public SlashTrailSection getSlash() {
		return slash;
	}
	
	public int getLives() {
		return lives;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void clearAllObjects() {
		objects.clear();
	}
	
	public boolean getHit() {
		return hit;
	}
	
	public void changeHit() {
		hit = false;
	}
	
	public void EndGame() {
		if(lives == 0) {
			gameOver = true;
		}
	}
}
