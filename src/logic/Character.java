package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import sharedObject.RenderableHolder;

public class Character extends Entity {
	private String control;
	private int life, exp, lv, maxExp, speed, timeOfpic;
	private List<Image> left, right, up, down;

	private Image charpic, deadpic;

	private AudioClip levelup, firesound, damage;

	public Character() {
		super(400, 240);
		this.life = 10;
		this.lv = 1;
		this.maxExp = 50;
		this.speed = 2;
		left = new ArrayList<>();
		right = new ArrayList<>();
		up = new ArrayList<>();
		down = new ArrayList<>();
		for (int i = 1; i < 6; ++i) {
			left.add(new Image(ClassLoader.getSystemResource("move_left" + i + ".png").toString()));
			right.add(new Image(ClassLoader.getSystemResource("move_right" + i + ".png").toString()));
			up.add(new Image(ClassLoader.getSystemResource("move_top" + i + ".png").toString()));
			down.add(new Image(ClassLoader.getSystemResource("move_bot" + i + ".png").toString()));
		}
		deadpic = new Image(ClassLoader.getSystemResource("dead.png").toString());
		charpic = down.get(0);
		levelup = new AudioClip(ClassLoader.getSystemResource("level.mp3").toString());
		firesound = new AudioClip(ClassLoader.getSystemResource("fire.mp3").toString());
		damage = new AudioClip(ClassLoader.getSystemResource("damage.mp3").toString());
	}

	public void gainHp() {
		life++;
	}

	public boolean damaged(double x, double y, Monster monster) {
		if (life > 0) {
			if (checkIntersect(x, y, monster.getMonsterpic())) {
				life--;
				if (monster instanceof Baphomet)
					life = 0;
				damage.play();
				return true;
			}
		}
		return false;
	}

	public void attack(char c) {
		if (life > 0) {
			Fireball fireball = new Fireball(x, y, c);
			RenderableHolder.getinstance().add(fireball);
			firesound.play();
		}
	}

	public void draw(GraphicsContext gc) {
		timeOfpic++;
		if (timeOfpic >= 50)
			timeOfpic = 0;
		gc.drawImage(charpic, x, y);
	}

	public void updatePos() {

		if (control.contains("a") && x > 0) {
			x -= speed;
			charpic = left.get(timeOfpic / 10);
		}
		if (control.contains("d") && x < 800 - charpic.getWidth()) {
			x += speed;
			charpic = right.get(timeOfpic / 10);
		}
		if (control.contains("w") && y > 0) {
			y -= speed;
			charpic = up.get(timeOfpic / 10);
		}
		if (control.contains("s") && y < 480 - charpic.getHeight()) {
			y += speed;
			charpic = down.get(timeOfpic / 10);
		}

		if (life == 0) {
			charpic = deadpic;
			speed = 0;
		}
	}

	public void updateLv() {
		if (exp >= maxExp) {
			Levelup lvup = new Levelup(x, y);
			RenderableHolder.getinstance().add(lvup);
			lv++;
			exp = 0;
			maxExp += 10;
			levelup.play();
		}
	}

	private boolean checkIntersect(double x, double y, Image pic) {
		Rectangle r = new Rectangle(x, y, pic.getWidth(), pic.getHeight());
		if (r.intersects(this.x, this.y, charpic.getWidth(), charpic.getHeight())) {
			return true;
		}
		return false;
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
		this.control = control;
	}

}
