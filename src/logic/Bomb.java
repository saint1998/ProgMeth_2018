package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Bomb extends Entity {

	private int time = 3;
	private double x, y;
	private List<Image> bmbpics = new ArrayList<>();
	private Image bmbpic;
	private int power;
	private boolean isVisible = true;
	private Character ch1, ch2;
	private int timeOfPic = 0;

	public Bomb(double x, double y, int power, Character ch1, Character ch2) {
		this.power = power;
		this.bmbpic = new Image(ClassLoader.getSystemResource("bomb1.png").toString());
		for(int i = 1 ;i < 5 ; ++i ) {
			bmbpics.add(new Image(ClassLoader.getSystemResource("bomb"+i+".png").toString()));
		}
		for(int i = 1 ;i < 5 ; ++i ) {
			bmbpics.add(new Image(ClassLoader.getSystemResource("red_bomb"+i+".png").toString()));
		}
		this.x = x;
		this.y = y + ch1.getHeight() - bmbpic.getHeight();
		this.ch1 = ch1;
		this.ch2 = ch2;
		
	}

	public void explode() {
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



	@Override
	public void draw(GraphicsContext gc) {
		timeOfPic ++;
		gc.drawImage(bmbpic, x, y);

	}

	@Override
	public void update() {
		if(timeOfPic< 80)
			bmbpic = bmbpics.get(timeOfPic/10);
		if(timeOfPic >= 80) {
			explode();
			isVisible = false;
		}

	}

	public double getHeight() {
		return bmbpic.getHeight();
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}

}
