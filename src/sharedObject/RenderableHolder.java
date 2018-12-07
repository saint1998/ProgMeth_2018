package sharedObject;

import java.util.ArrayList;
import java.util.List;


import javafx.scene.canvas.GraphicsContext;
import logic.Character;
import logic.Fireball;
import logic.Monster;

public class RenderableHolder {
	private static final RenderableHolder r = new RenderableHolder();
	private List<IRenderable> object;
	
	
	public RenderableHolder() {
		object = new ArrayList<>();
	}
	
	
	
	public static RenderableHolder getinstance() {
		return r;
	}
	
	
	
	public void add(IRenderable i) {
		object.add(i);
	}
	
	
	
	public void draw(GraphicsContext gc) {
		for (int i =0; i<object.size(); i++) {
			object.get(i).draw(gc);
		}
	}
	
	
	public void remove() {
		int n = object.size();
		for (int i=n-1; i>=0; i--) {
			if (object.get(i).isVisible() == false) {
				object.remove(i);
			}
		}
	}
	
	public void updatePos(String control) {
		for (IRenderable i : object) {
			if ( i instanceof Character) {
				((Character)i).setControl(control);
				((Character)i).updatePos();
			}
			if (i instanceof Fireball) {
				((Fireball)i).updatePos();
			}
			if (i instanceof Monster) {
				((Monster)i).updatePos();
			}
		}
	}

}
