package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Character extends Entity {
	boolean isDeath = false;
	int speed;
	int Bomb = 1;
	Image chpic;
	
	public Character() {
		super(300.0, 200.0);
		chpic = new Image(ClassLoader.getSystemResource("Novice.png").toString());
	}
	
	public void isAtked() {
		isDeath = true;
	}
	
	public void update() {
		
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(chpic, 200, 200);
		
	}

}
