package Logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	
	protected double x,y;
	protected int z;
	protected boolean Death;
	
	protected Entity(double x, double y){
		Death = false;
		this.x = x;
		this.y = y;
	}
	
	public boolean isDeath() {
		return Death;
	}
	
	public int getZ(){
		return z;
	}


}
