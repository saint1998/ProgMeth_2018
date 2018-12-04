package Logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	
	protected double x,y;
	protected int z;
	protected boolean Death;
	
	protected Entity(){
		Death = false;

	}
	
	public boolean isDeath() {
		return Death;
	}
	
	public int getZ(){
		return z;
	}


}
