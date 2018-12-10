package graphic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

public class GameWin {
	public static Image gameWin;
	public static AudioClip gameWinSound = new AudioClip(ClassLoader.getSystemResource("win.mp3").toString());

	public GameWin() {
		
	}

	public static void draw(GraphicsContext gc) {
		setImage();
		playSong();
		setBackground(gc);

	}

	public static void setBackground(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, 800, 450);
		gc.drawImage(gameWin, 0, 0);
	}

	public static void setImage() {
		gameWin = new Image("scene_win.png");

	}

	public static void playSong() {
		gameWinSound.play();
	}

	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}

	public static void stopsound() {
		gameWinSound.stop();
	}

}