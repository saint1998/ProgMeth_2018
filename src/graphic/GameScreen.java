package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.IRenderable;

public class GameScreen implements IRenderable{
	private int lv,exp,maxExp,life;
	public Image bggame,skillatk;
	
	public GameScreen() {
		bggame = new Image(ClassLoader.getSystemResource("map.png").toString());
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(bggame, 0, 0);
		
		
	}
	
	public boolean isVisible() {
		return true;
	}
	
	
	
}
