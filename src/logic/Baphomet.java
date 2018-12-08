package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Baphomet extends Monster{
	private List<Image> monsterpics = new ArrayList<>();
	private List<Image> monsterpicsrv = new ArrayList<>();
	private int timeOfPic;


	public Baphomet(Character character) {
		super(100,0.5);
		this.x =0;
		this.y = 0;
		for(int i = 1 ; i<5 ; ++i) {
			monsterpics.add(new Image(ClassLoader.getSystemResource("bapho" + i + ".png").toString()));
			monsterpicsrv.add(new Image(ClassLoader.getSystemResource("ohpab" + i + ".png").toString()));
		}
		this.character =character;
		monsterpic = monsterpics.get(0);
	}
	@Override
	public void draw(GraphicsContext gc) {
		gc.fillRect(x, y, monsterpic.getWidth(), monsterpic.getHeight());
		timeOfPic++;
		if(timeOfPic >=40) timeOfPic = 0;
		gc.drawImage(monsterpic, x, y);
		System.out.println("draw Baphomet");
	}
	
	public  void updatePos() {
		x += speed*calx(character.getX(),character.getY());
		y += speed*caly(character.getX(),character.getY());
		if( speed*calx(character.getX(),character.getY())<= 0) monsterpic = monsterpics.get(timeOfPic/10);
		else  	monsterpic = monsterpicsrv.get(timeOfPic/10);

	}

}
