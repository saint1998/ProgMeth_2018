package logic;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Explosion extends Entity {
	
	private List<Image> explospic;
	private double x,y;
	
	public Explosion(double x, double y) {
		this.x = x;
		this.y = y;
		for(int i = 1 ; i < 9 ; ++i) {
			explospic.add(new Image(ClassLoader.getSystemResource("ef_bomb"+i+".png").toString()));
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
