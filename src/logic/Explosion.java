package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Explosion extends Entity {

	private List<Image> explospics = new ArrayList();
	private Image explospic;
	private double x, y;
	private int timeOfPic = 0;
	private boolean isVisible = true ;
	private int power;



	public Explosion(double x, double y,int power) {
		this.x = x;
		this.y = y;
		this.power = power; 
		for (int i = 1; i < 9; i++) {
			explospics.add(new Image(ClassLoader.getSystemResource("ef_bomb" + i + ".png").toString()));
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		timeOfPic++;
		for(int i = 1 ; i < power + 1; ++i ) {
			gc.drawImage(explospic, x-(explospic.getHeight()*i), y);
		}
		for(int i = 1 ; i < power + 1; ++i ) {
			gc.drawImage(explospic, x+(explospic.getHeight()*i), y);
		}
		for(int i = 1 ; i < power + 1; ++i ) {
			gc.drawImage(explospic, x, y-(explospic.getHeight()*i));
		}
		for(int i = 1 ; i < power + 1; ++i ) {
			gc.drawImage(explospic, x, y+(explospic.getHeight()*i));
		}
		if (isVisible) {
			timeOfPic++;
			if (timeOfPic >= 50)
				isVisible = false;
			gc.drawImage(explospic, x, y);
		}

	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	@Override
	public void update() {
		if (isVisible) {
			explospic = explospics.get(getTimeOfPic() / 10);
		}
	}

	public int getTimeOfPic() {
		return timeOfPic;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}

}
