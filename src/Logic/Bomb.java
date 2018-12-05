package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends Entity{
	
	private int time = 3;
	private double x,y;
	private Image bmbpic;
	private int power;
	private boolean isbombed;
	private Character ch1, ch2;
	
	public Bomb(double x,double y, int power,Character ch1,Character ch2) {
		this.power = power;
		this.x = x;
		this.y = y;
		this.ch1 = ch1;
		this.ch2 = ch2;
		this.bmbpic = new Image(ClassLoader.getSystemResource("bomb_1.png").toString());
		Thread t = new Thread(()-> {
			isbombed = false;
				try {
					Thread.sleep(1500);
					
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			isbombed = true;
			explode();
		});
		t.start();
	}
	
	private void explode() {
		ch1.isAtked(x, y, power);
		ch2.isAtked(x, y, power);
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
	



	

}
