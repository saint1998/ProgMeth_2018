package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boot extends Item {
	private int n = 0;
	public List<Image> images = new ArrayList<>();

	public Boot() {
		for (int i = 1; i < 5; ++i) {
			images.add(new Image(ClassLoader.getSystemResource("item_boot" + i + ".png").toString()));
		}
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(images.get(n), x, y);
		n++;
		if (n >= 4)
			n = 0;

	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
