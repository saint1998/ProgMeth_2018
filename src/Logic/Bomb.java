package Logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends Entity{
	
	private int time = 3;
	private Image bmbpic;
	private int power;
	
	public Bomb(int power) {
		this.power = power;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	
	

}
