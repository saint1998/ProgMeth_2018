package logic;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Character extends Entity {
	private String control;
	private int life = 10;
	private int exp = 0;
	private int lv = 1;
	private int maxExp = 50;
	private int speed = 4;
	private int timeOfpic = 0;
	private List<Image> left = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	public Image charpic;
	public Image deadpic;

	public Character() {
		super(400, 240);
		for (int i = 1; i < 6; ++i) {
			left.add(new Image(ClassLoader.getSystemResource("move_left" + i + ".png").toString()));
			right.add(new Image(ClassLoader.getSystemResource("move_right" + i + ".png").toString()));
			up.add(new Image(ClassLoader.getSystemResource("move_top" + i + ".png").toString()));
			down.add(new Image(ClassLoader.getSystemResource("move_bot" + i + ".png").toString()));
		}
		deadpic = new Image(ClassLoader.getSystemResource("dead.png").toString());
		charpic = down.get(0);
	}

	public void gainHp() {
		life++;
	}

	public boolean damaged(double x, double y) {
		if(Math.abs(this.x-x)<= charpic.getWidth() && Math.abs(this.y-y)<=charpic.getHeight()) {
			life--;
			System.out.println("ch damaged");
			return true;
		}
		return false;
	}
	
	public void attack(char c) {
		Fireball fireball = new Fireball(x, y, c);
		RenderableHolder.getinstance().add(fireball);
	}

	public void draw(GraphicsContext gc) {
		timeOfpic++;
		if (timeOfpic >= 50)
			timeOfpic = 0;
		gc.drawImage(charpic, x, y);
	}

	public void updatePos() {
		if (control.contains("a") && x> 0) {
			x -= speed;
			charpic = left.get(timeOfpic / 10);
		}
		if (control.contains("d") && x < 800-charpic.getWidth()) {
			x += speed;
			charpic = right.get(timeOfpic / 10);
		}
		if (control.contains("w") && y > 0) {
			y -= speed;
			charpic = up.get(timeOfpic / 10);
		}
		if (control.contains("s") && y < 480 - charpic.getHeight() ) {
			y += speed;
			charpic = down.get(timeOfpic / 10);
		}
		if (life < 0) {
			charpic = deadpic;
			speed = 0;
		}
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}
	
	public void setControl(String control) {
		this.control =control;
	}

}
