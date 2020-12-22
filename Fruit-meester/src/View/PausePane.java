package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PausePane extends VBox {
	private Label pause = new Label("Pause");
	public PausePane() {
		setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, null, null)));
		pause.setTextFill(Color.WHITE);
		pause.setFont(Font.font("Arial", 50));
		getChildren().add(pause);
		setAlignment(Pos.CENTER);
		setPrefSize(500, 500);
	}
}
