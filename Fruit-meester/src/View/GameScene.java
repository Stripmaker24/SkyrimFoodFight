package View;

import Controller.FruitController;
import Model.PlayingField;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameScene extends Scene {
	private VBox game;
	private StatsPane stats;
	private FieldView field;
	private PausePane pausePane;
	private GameOverPane gameOverPane;
	public GameScene(FruitController fruitController, PlayingField playingfield) {
		super(new Pane());
		game = new VBox();
		stats = new StatsPane(playingfield);
		field = new FieldView(playingfield);
		gameOverPane = new GameOverPane(playingfield);
		pausePane = new PausePane();
		game.getChildren().addAll(stats, field);
		setRoot(game);
		setOnKeyPressed((e) ->{
			if(e.getCode() == KeyCode.SPACE) {
				if(fruitController.getIsPaused()) {
					fruitController.resume();
					setPane(game);
				} else {
					fruitController.pause();
					setPane(pausePane);
				}
			}
		});
		setOnMousePressed((e) ->{
			fruitController.startSlash();
		});
		setOnMouseDragged((e) ->{
			fruitController.Slash(e.getX(), e.getY());
		});
		setOnMouseReleased((e) ->{
			fruitController.endSlash();
		});
		}
	public FieldView getField() {
		return field;
	}
	
	public void setPane(Pane pane) {
		setRoot(pane);
	}
	
	public StatsPane getStats() {
		return stats;
	}
	
	public GameOverPane getGameOver() {
		return gameOverPane;
	}
	
	public void gameIsOver() {
		setRoot(gameOverPane);
	}
	
	public boolean CheckGameOverPane() {
		if(getRoot() == gameOverPane) {
			return true;
		}
		return false;
	}
	
}
