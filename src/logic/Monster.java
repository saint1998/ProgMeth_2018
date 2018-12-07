package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphic.GameScreen;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Monster extends Entity{
	private Random rand= new Random();
	protected int hp;
	protected double speed;
	protected Character character;
	protected boolean isVisible = true;
	protected Image monsterpic;

	
	public Monster(int hp, double speed) {
		this.character = character;
		this.hp = hp;
		this.speed =speed;
		this.x = (double)rand.nextInt(800);
		this.y = (double)rand.nextInt(480);
	}
		
	public double calx(double x, double y) {
		return  (y-this.y)/(Math.sqrt(((y-this.y)*(y-this.y))+((x-this.x)*(x-this.x))));
	}
	
	public double caly(double x, double y) {
		return (x-this.x)/(Math.sqrt(((y-this.y)*(y-this.y))+((x-this.x)*(x-this.x))));
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public void damaged(double x, double y) {
		if(this.x-x <= monsterpic.getWidth() && this.y - y <= monsterpic.getHeight()) {
			hp--;
			if(hp == 0) isVisible = false;
		}
	}
	
	public abstract void updatePos();

	public int getHp() {
		return hp;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	

	
	
	


}
