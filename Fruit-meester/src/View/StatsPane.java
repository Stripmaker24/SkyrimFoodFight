package View;

import Model.PlayingField;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class StatsPane extends HBox {
	private Label scoreLabel;
	private Label livesLabel;
	private Label score;
	private Label lives;
	private PlayingField playingField;
	public StatsPane(PlayingField playingField) {
		scoreLabel = new Label("Score:");
		livesLabel = new Label("Lives:");
		score = new Label();
		lives = new Label();
		this.playingField = playingField;
		getChildren().addAll(scoreLabel, score, livesLabel, lives);
		setSpacing(125);
		setPrefSize(500, 20);
		setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, null, null)));
	}
	
	public void setLives() {
		lives.setText(String.valueOf(playingField.getLives()));
	}
	
	public void setScore() {
		score.setText(String.valueOf(playingField.getScore()));
	}
}
