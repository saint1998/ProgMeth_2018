package logic;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public abstract class Item extends Entity{
	
	protected boolean isVisible = true;
	private int tick=200;
	private static Random rand = new Random();
	protected double x,y;
	
	public Item() {
		x = rand.nextInt(500)+35;
		y = rand.nextInt(500)+60;
	}

}
