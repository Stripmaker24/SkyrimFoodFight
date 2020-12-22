package View;

import Model.Fruit;
import Model.GameObject;
import Model.PlayingField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameObjectView extends Pane {
	private PlayingField playingField;
	private Image img1 = new Image("Media/Red_Apple_Skyrim.png");
	private Image img2 = new Image("Media/Jazbay_grapes_skyrim.png");
	private Image img3 = new Image("Media/MAGINVShockSpellArt.png");
	public GameObjectView(PlayingField playingField) {
		this.playingField = playingField;
		setMaxSize(500, 500);
	}
	
	public void drawObjects() {
		getChildren().clear();
		for(GameObject object: playingField.getObjects()) {
			ImageView img;
			switch(object.getClass().getSimpleName()) {
				case "Fruit": switch(((Fruit) object).getFruit()) {
					case BIG: 
						img = new ImageView(img1);
						img.setX(object.getX());
						img.setY(object.getY());
						img.setRotate(object.getRotation());
						object.addRotation();
						img.setFitHeight(45);
						img.setFitWidth(45);
						getChildren().add(img);
					break;
					case SMALL:
						img = new ImageView(img2);
						img.setX(object.getX());
						img.setY(object.getY());
						img.setRotate(object.getRotation());
						object.addRotation();
						img.setFitHeight(30);
						img.setFitWidth(30);
						getChildren().add(img);
					break;
				}; break;
				case "Bomb": 
					img = new ImageView(img3);
					img.setX(object.getX());
					img.setY(object.getY());
					img.setRotate(object.getRotation());
					object.addRotation();
					img.setFitHeight(80);
					img.setFitWidth(80);
					getChildren().add(img);
				break;

			}
		}
	}
}
