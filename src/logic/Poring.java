package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Poring extends Monster {
	private List<Image> monsterpics = new ArrayList<>();
	private List<Image> monsterpicsrv = new ArrayList<>();
	private int timeOfPic;

	public Poring(Character character) {
		super(1, 0.8);
		for (int i = 1; i < 5; ++i) {
			monsterpics.add(new Image(ClassLoader.getSystemResource("poring" + i + ".png").toString()));
			monsterpicsrv.add(new Image(ClassLoader.getSystemResource("gnirop" + i + ".png").toString()));
		}
		this.character = character;
		monsterpic = monsterpics.get(0);
	}

	@Override
	public void draw(GraphicsContext gc) {
		timeOfPic++;
		if (timeOfPic >= 40)
			timeOfPic = 0;
		gc.drawImage(monsterpic, x, y);
		System.out.println("draw drop");
	}

	public void updatePos() {
		x += speed * calx(character.getX(), character.getY());
		y += speed * caly(character.getX(), character.getY());
		if (speed * calx(character.getX(), character.getY()) <= 0)
			monsterpic = monsterpics.get(timeOfPic / 10);
		else
			monsterpic = monsterpicsrv.get(timeOfPic / 10);

	}

}
