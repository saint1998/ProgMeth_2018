package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Horong extends Monster {
	private List<Image> monsterpics = new ArrayList<>();
	private int timeOfPic;

	public Horong(Character character) {
		super(1, 2);
		for (int i = 1; i < 5; ++i) {
			monsterpics.add(new Image(ClassLoader.getSystemResource("horong" + i + ".png").toString()));
		}
		this.character = character;
		monsterpic = monsterpics.get(0);
	}

	@Override
	public void draw(GraphicsContext gc) {
		timeOfPic++;
		if (timeOfPic >= 40)
			timeOfPic = 0;
		monsterpic = monsterpics.get(timeOfPic / 10);
		gc.drawImage(monsterpic, x, y);
	}

	public void updatePos() {
		x += speed * calx(character.getX(), character.getY());
		y += speed * caly(character.getX(), character.getY());
	}

}
