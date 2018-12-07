package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.IRenderable;

public class GameScreen implements IRenderable{
	private int lv,exp,maxExp,life;
	public Image bggame,skillatk;
	
	public GameScreen() {
		bggame = new Image(ClassLoader.getSystemResource("map.png").toString());
	}
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(bggame, 0, 0);
		gc.setFont(new Font("Arial",14));
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.CORNFLOWERBLUE);
		gc.fillText("Life : " + life, 10, 15);
		gc.fillText("Lv. "+lv, 10, 35);
		gc.fillText("Exp : " + exp + " / " + maxExp, 10, 55);
		
	}
	
	public boolean isVisible() {
		return true;
	}
	
	public void setCharacterData(int lv,int exp,int maxexp,int life) {
		this.lv = lv;
		this.exp = exp;
		this.maxExp = maxexp;
		this.life = life;
	}
	
	
	
}
