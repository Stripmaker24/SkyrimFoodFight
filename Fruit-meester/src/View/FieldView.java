package View;

import Model.PlayingField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class FieldView extends Pane {
	private GameObjectView objects;
	private PlayingField playingfield;
	private BackgroundImage background = new BackgroundImage(new Image("Media/72850_screenshots_2015-03-14_00017.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
	public FieldView(PlayingField playingfield) {
		this.playingfield = playingfield;
		objects = new GameObjectView(playingfield);
		setBackground(new Background(background));
		setPrefSize(500, 500);
		getChildren().add(objects);
	}
	
	public void Draw() {
		// hier worden alle objecten getekend.
		if(!playingfield.objectsIsEmpty()) {
			objects.drawObjects();
		}
	}
	
}
