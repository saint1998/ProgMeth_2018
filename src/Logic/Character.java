package Logic;

import com.sun.xml.internal.bind.v2.TODO;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Character extends Entity {
	boolean isDeath = false;
	int speed = 5;
	int bomb;
	int power;
	Image chpic;
	double x, y;

	public Character(double x, double y) {
		this.x = x;
		this.y = y;
		this.bomb = 1;
		this.power = 1;
		chpic = new Image(ClassLoader.getSystemResource("Novice.png").toString());
	}

	public void isAtked() {
		isDeath = true;
	}

	private void up() {
		if(this.y - speed < 0) this.y = 0;
		else this.y -= speed;
	}

	private void down() {
		if(this.y + speed > 600 - chpic.getHeight()) this.y = 600 - chpic.getHeight();
		else this.y += speed;
	}

	private void right() {
		if(this.x + speed > 600 - chpic.getWidth()) this.x = 600 - chpic.getWidth();
		else this.x += speed;
	}

	private void left() {
		if(this.x - speed < 0) this.x = 0;
		else this.x -= speed;
	}

	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.W))
			up();
		else if (InputUtility.getKeyPressed(KeyCode.S))
			down();
		else if (InputUtility.getKeyPressed(KeyCode.D))
			right();
		else if (InputUtility.getKeyPressed(KeyCode.A))
			left();

	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(chpic, x, y);

	}

}
