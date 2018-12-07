package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Drops extends Monster{
	private List<Image> dropspic = new ArrayList<>();
	private int timeOfPic;


	public Drops(Character character) {
		super(1,0.7);
		for(int i = 1 ; i<5 ; ++i) {
			dropspic.add(new Image(ClassLoader.getSystemResource("drop" + i + ".png").toString()));
		}
		this.character =character;
		monsterpic = dropspic.get(0);
	}
	@Override
	public void draw(GraphicsContext gc) {
		timeOfPic++;
		if(timeOfPic >=40) timeOfPic = 0;
		monsterpic = dropspic.get(timeOfPic/10);
		gc.drawImage(monsterpic, x, y);
	}
	
	public  void updatePos() {
		x += speed*calx(character.getX(),character.getY());
		y += speed*caly(character.getX(),character.getY());
		if(character.damaged(x,y)) isVisible = false;
	}
	




	

}
