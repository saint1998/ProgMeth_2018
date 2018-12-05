package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	
	protected double x,y;
	protected int z;
	
	protected Entity(){
	}
	
	public int getZ(){
		return z;
	}
	
	public abstract void update();


}
