package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Explosion extends Entity {
	
	private List<Image> explospics = new ArrayList();
	private Image explospic;
	private double x,y;
	private int timeOfPic = 0;
	
	public Explosion(double x, double y) {
		this.x = x;
		this.y = y;
		for(int i = 1; i < 9 ;i++) {
			explospics.add(new Image(ClassLoader.getSystemResource("ef_bomb"+i+".png").toString()));
		}
	}
		

	@Override
	public void draw(GraphicsContext gc) {
		timeOfPic++;
		if(timeOfPic >= 50) timeOfPic = 0;
		gc.drawImage(explospic, x, y);
		
	}

	@Override
	public void update() {
		explospic = explospics.get(getTimeOfPic()/10);
	}

	public int getTimeOfPic() {
		return timeOfPic;
	}

}
