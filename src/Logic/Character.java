package Logic;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Character extends Entity {
	boolean isDeath = false;
	int speed = 5;
	int Bomb = 1;
	Image chpic;
	double x,y;

	public Character(double x,double y) {
		this.x = x;
		this.y = y;
		chpic = new Image(ClassLoader.getSystemResource("Novice.png").toString());
	}

	public void isAtked() {
		isDeath = true;
	}

	private void up() {
		this.y -= speed;
	}

	private void down() {
		this.y += speed;
	}

	private void right() {
		this.x += speed;
	}

	private void left() {
		this.x -= speed;
	}

	public void update() {
		if(InputUtility.getKeyPressed(KeyCode.W)) up();
		else if(InputUtility.getKeyPressed(KeyCode.S)) down();
		else if(InputUtility.getKeyPressed(KeyCode.D)) right();
		else if(InputUtility.getKeyPressed(KeyCode.A)) left();
		

	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(chpic, x, y);

	}

}
