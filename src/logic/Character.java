package logic;

import com.sun.xml.internal.bind.v2.TODO;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;

public abstract class Character extends Entity {
	private boolean isDeath = false;
	private int speed = 5;
	private int bomb;
	private int power;
	private Image chpic;
	private double x, y;

	public Character(double x, double y) {
		this.x = x;
		this.y = y;
		this.bomb = 1;
		this.power = 10;
		chpic = new Image(ClassLoader.getSystemResource("stand.png").toString());
	}

	protected void bomb(Character ch1, Character ch2) {
		Bomb bomb = new Bomb(x, y, power, ch1, ch2);
		RenderableHolder.getInstance().add(bomb);
	}

	public void isAtked(double x, double y, Bomb bmb) {
		if (this.x == x && this.y + getHeight() >= y && this.y + getHeight() <= y + bmb.getHeight())
			isDeath = true;
	}

	public void setDeath(boolean isDeath) {
		this.isDeath = isDeath;
	}

	public boolean isDeath() {
		return isDeath;
	}

	protected void up() {
		if (this.y - speed < 0)
			this.y = 0;
		else
			this.y -= speed;
	}

	protected void down() {
		if (this.y + speed > 600 - chpic.getHeight())
			this.y = 600 - chpic.getHeight();
		else
			this.y += speed;
	}

	protected void right() {
		if (this.x + speed > 600 - chpic.getWidth())
			this.x = 600 - chpic.getWidth();
		else
			this.x += speed;
	}

	protected void left() {
		if (this.x - speed < 0)
			this.x = 0;
		else
			this.x -= speed;
	}

	public abstract void update();

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(chpic, x, y);

	}

	public double getHeight() {
		return chpic.getHeight();
	}

}
