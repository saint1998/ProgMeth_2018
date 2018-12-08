package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Levelup extends Entity{
	private boolean isVisible = true;
	private Image pic ;
	private int time = 100;

	public Levelup(double x,double y) {
		this.x = x;
		this.y = y;
		pic = new Image(ClassLoader.getSystemResource("level.png").toString());
				
	}
	@Override
	public void draw(GraphicsContext gc) {
		time--;
		if(time == 0) isVisible = false;
		gc.drawImage(pic, x, y);
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return this.isVisible;
	}

	@Override
	public void updatePos() {
		
	}
	
	


}
