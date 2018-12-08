package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Monster extends Entity {
	private Random rand = new Random();
	protected int hp;
	protected double speed;
	protected Character character;
	protected boolean isVisible = true;
	protected Image monsterpic;

	public Monster(int hp, double speed) {
		this.character = character;
		this.hp = hp;
		this.speed = speed;
		this.x = (double) rand.nextInt(760);
		this.y = (double) rand.nextInt(440);
	}

	public double calx(double x, double y) {
		double a = y - this.y;
		double b = x - this.x;
		double c = Math.sqrt((a * a) + (b * b));
		double cos = b / c;
		return cos;
	}

	public double caly(double x, double y) {
		double a = y - this.y;
		double b = x - this.x;
		double c = Math.sqrt((a * a) + (b * b));
		double sin = a / c;
		return sin;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public boolean damaged(double x, double y) {
		if (x - this.x <= monsterpic.getWidth() && x - this.x >= 0 && y - this.y <= monsterpic.getHeight()
				&& y - this.y >= 0) {
			hp--;
			System.out.println(hp);
			return true;
		}
		return false;
	}

	public abstract void updatePos();

	public int getHp() {
		return hp;
	}
	
	public Image getMonsterpic() {
		return monsterpic;
	}

	public void setVisible(boolean isVisible) {
		System.out.println("set invis monster");
		this.isVisible = isVisible;
	}

}
