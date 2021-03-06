package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

public class GameOver {
	public static Image gameOver;
	public static AudioClip gameOversound = new AudioClip(ClassLoader.getSystemResource("die.mp3").toString());;
	public GameOver() {

	}

	public static void draw(GraphicsContext gc) {
		setImage();
		playSong();
		setBackground(gc);

	}

	public static void setBackground(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 800, 450);
		gc.drawImage(gameOver, 0, 0);
	}

	public static void setImage() {
		gameOver = new Image("scene_died.png");

	}

	public static void playSong() {
		gameOversound.play();
	}

	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}

	public static void stopsound() {
		gameOversound.stop();
	}

}