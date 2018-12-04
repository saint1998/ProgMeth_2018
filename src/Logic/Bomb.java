package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends Entity{
	
	private int time = 3;
	private double x,y;
	private Image bmbpic;
	private int power;
	private boolean isbombed;
	
	public Bomb(double x,double y, int power) {
		this.power = power;
		this.x = x;
		this.y = y;
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
		
		});
		t.start();
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
