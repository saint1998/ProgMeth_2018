package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Hydra extends Monster{
	private List<Image> monsterpics = new ArrayList<>();
	private int timeOfPic;
	
	public Hydra(Character character) {
		super(2,0.3);
		for(int i = 1;i < 7; ++i ) {
			monsterpics.add(new Image(ClassLoader.getSystemResource("hydra"+i+".png").toString()));
		}
		this.character =character;
		monsterpic = monsterpics.get(0);
		
	}
	@Override
	public void draw(GraphicsContext gc) {
		timeOfPic++;
		if(timeOfPic >=60) timeOfPic = 0;
		monsterpic = monsterpics.get(timeOfPic/10);
		gc.drawImage(monsterpic, x, y);
		System.out.println("draw hydra");
	}
	
	public  void updatePos() {
		if(character.damaged(x,y)) isVisible = false;
		x += speed*calx(character.getX(),character.getY());
		y += speed*caly(character.getX(),character.getY());
	}
	

}