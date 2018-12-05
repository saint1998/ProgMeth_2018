package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelReader;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Field implements IRenderable {

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.mapSprite, 0, 0);		
	}



}
