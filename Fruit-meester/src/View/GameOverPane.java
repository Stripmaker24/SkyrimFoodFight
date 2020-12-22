package View;

import Model.PlayingField;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverPane extends VBox{
	private Label finalScore;
	private Label gameOver = new Label("GAME OVER");
	private PlayingField playingField;
	public GameOverPane(PlayingField playingField) {
		this.playingField = playingField;
		finalScore = new Label();
		finalScore.setTextFill(Color.WHITE);
		finalScore.setFont(Font.font("Arial", 30));
		gameOver.setTextFill(Color.WHITE);
		gameOver.setFont(Font.font("Arial", 50));
		getChildren().addAll(gameOver, finalScore);
		setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		setAlignment(Pos.CENTER);
	}
	
	public void setFinalScore() {
		// ik zet de text van de label doormiddel van een int in de model.
		finalScore.setText("Final score: "+ String.valueOf(playingField.getScore()));
	}
}
