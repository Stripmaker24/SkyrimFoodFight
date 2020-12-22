package Controller;

import Model.PlayingField;
import Timer.AnimationTimerEXT;
import View.GameScene;
import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class FruitController extends Application {
	private GameScene gameScene;
	private PlayingField playingField;
	private AnimationTimerEXT moveTimer;
	private AnimationTimerEXT objectTimer;
	private MediaPlayer gameMediaPlayer;
	private Media backgroundGame;
	private MediaPlayer endMediaPlayer;
	private Media backgroundEnd;
	private AudioClip soundEffect;
	private boolean isPaused = false;
	public void startUp(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		backgroundGame = new Media(this.getClass().getResource("/Media/BackgroundMusic.mp3").toExternalForm());
		backgroundEnd = new Media(this.getClass().getResource("/Media/EndMusic.mp3").toExternalForm());
		soundEffect = new AudioClip(this.getClass().getResource("/Media/slash.wav").toExternalForm());
		// de muziek tijdens het spel
		gameMediaPlayer = new MediaPlayer(backgroundGame);
		gameMediaPlayer.setAutoPlay(true);
		gameMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		gameMediaPlayer.setVolume(0.5);
		// de muziek in het gameover scherm
		endMediaPlayer = new MediaPlayer(backgroundEnd);
		endMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		endMediaPlayer.setVolume(0.2);
		
		playingField = new PlayingField();
		
		gameScene = new GameScene(this, playingField);
		gameScene.getStats().setLives();
		gameScene.getStats().setScore();
		// beweeg de objecten
		moveTimer = new AnimationTimerEXT(10) {
			public void doAction() {
				playingField.moveObjects();
				playingField.EndGame();
				gameScene.getField().Draw();
				if(playingField.getGameOver()) {
					stopTimers();
					gameMediaPlayer.stop();
					playingField.clearAllObjects();
					gameScene.gameIsOver();
					gameScene.getGameOver().setFinalScore();
					endMediaPlayer.play();
				}
			}
		};
		// voeg een object toe
		objectTimer = new AnimationTimerEXT(1000) {
			public void doAction() {
				playingField.addObject();
			}
		};
		stage.setTitle("PROG4 ASS FruitNinja - <Michelle van Setten>");
		stage.setScene(gameScene);
		stage.setResizable(false);
		stage.show();
		startTimers();
	}
	
	public void startTimers() {
		moveTimer.start();
		objectTimer.start();
	}
	
	public void stopTimers() {
		moveTimer.stop();
		objectTimer.stop();
	}
	
	public void pause() {
		stopTimers();
		playingField.PauseObjects();
		gameMediaPlayer.pause();
		isPaused = true;
	}
	
	public void resume() {
		startTimers();
		playingField.resumeObjects();
		gameMediaPlayer.play();
		isPaused = false;
	}
	
	public boolean getIsPaused() {
		return isPaused;
	}
	// begin van een slag
	public void startSlash() {
		playingField.getSlash().setSlashed(true);
	}
	
	public void Slash(double x, double y) {
		// check of iets wordt geraakt
		playingField.removeHitObject(x,y);
		//als een slag een object raak
		if(playingField.getHit()) {
			soundEffect.setVolume(0.2);
			soundEffect.play();
			playingField.changeHit();
		}
	}
	
	public void endSlash() {
		// aan het einde van een slag worden de levens en score geupdate.
		playingField.getSlash().setSlashed(false);
		gameScene.getStats().setLives();
		gameScene.getStats().setScore();
	}

}
