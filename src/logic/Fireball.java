package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fireball extends Entity {
	private char dr;
	private boolean isVisible = true;
	public Image fireballpic;

	public Fireball(double x, double y, char dr) {
		super(x, y);
		this.dr = dr;
		if (dr == 'a') {
			fireballpic = new Image(ClassLoader.getSystemResource("fire_left.png").toString());
			this.y += 15;
		}
		if (dr == 'd') {
			fireballpic = new Image(ClassLoader.getSystemResource("fire_right.png").toString());
			this.y += 15;
		}
		if (dr == 'w')
			fireballpic = new Image(ClassLoader.getSystemResource("fire_top.png").toString());
		if (dr == 's')
			fireballpic = new Image(ClassLoader.getSystemResource("fire_bot.png").toString());
	}

	public void draw(GraphicsContext gc) {
		gc.fillRect(x, y, fireballpic.getWidth(), fireballpic.getHeight());
		gc.drawImage(fireballpic, x, y);
	}

	public void updatePos() {
		if (dr == 'a')
			x -= 10;
		if (dr == 'd')
			x += 10;
		if (dr == 'w')
			y -= 10;
		if (dr == 's')
			y += 10;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Image getFireballpic() {
		return fireballpic;
	}
	

}
