package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends Entity {

	private int time = 3;
	private double x, y;
	private Image bmbpic;
	private int power;
	private boolean isbombed;
	private Character ch1, ch2;

	public Bomb(double x, double y, int power, Character ch1, Character ch2) {
		this.power = power;
		this.bmbpic = new Image(ClassLoader.getSystemResource("bomb_1.png").toString());
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
		for(int i = 0 ; i < power ; i++) {
			ch1.isAtked(x, y, this);
			ch2.isAtked(x, y, this);
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
