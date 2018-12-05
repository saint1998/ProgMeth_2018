package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Bomb extends Entity {

	private int time = 3;
	private double x, y;
	private Image bmbpic;
	private int power;
	private boolean isbombed;
	private Character ch1, ch2;

	public Bomb(double x, double y, int power, Character ch1, Character ch2) {
		this.power = power;
		this.bmbpic = new Image(ClassLoader.getSystemResource("red_bomb1.png").toString());
		this.x = x;
		this.y = y + ch1.getHeight() - bmbpic.getHeight();
		this.ch1 = ch1;
		this.ch2 = ch2;
		Thread t = new Thread(() -> {
			isbombed = false;
			try {
				Thread.sleep(1500);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			explode();
			isbombed = true;
		});
		t.start();
	}

	private void explode() {
		for (int i = 1; i < power+1; ++i) {
			ch1.isAtked(x-(bmbpic.getHeight()*i), y, this);
			ch2.isAtked(x-(bmbpic.getHeight()*i), y, this);
			Explosion expl = new Explosion(x-(bmbpic.getHeight()*i), y);
			RenderableHolder.getInstance().add(expl);
		}
		for (int i = 1; i < power+1; ++i) {
			ch1.isAtked(x+(bmbpic.getHeight()*i), y, this);
			ch2.isAtked(x+(bmbpic.getHeight()*i), y, this);
			Explosion expl = new Explosion(x+(bmbpic.getHeight()*i), y);
			RenderableHolder.getInstance().add(expl);
		}
		for (int i = 1; i < power+1; ++i) {
			ch1.isAtked(x, y-(bmbpic.getWidth()*i), this);
			ch2.isAtked(x, y-(bmbpic.getWidth()*i), this);
			Explosion expl = new Explosion(x, y-(bmbpic.getWidth()*i));
			RenderableHolder.getInstance().add(expl);
		}
		for (int i = 1; i < power+1; ++i) {
			ch1.isAtked(x, y+(bmbpic.getWidth()*i), this);
			ch2.isAtked(x, y+(bmbpic.getWidth()*i), this);
			Explosion expl = new Explosion(x, y+(bmbpic.getWidth()*i));
			RenderableHolder.getInstance().add(expl);
		}
	}

	public boolean isIsbombed() {
		return isbombed;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(bmbpic, x, y);

	}

	@Override
	public void update() {

	}

	public double getHeight() {
		return bmbpic.getHeight();
	}

}
