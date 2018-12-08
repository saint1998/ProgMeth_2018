package graphic;

import com.sun.glass.events.KeyEvent;
import javafx.scene.media.AudioClip;
import com.sun.xml.internal.bind.v2.TODO;
import javafx.application.Platform;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartWindow {
	private Stage primaryStage;
	private Canvas bg;
	private GraphicsContext gc;
	private AnimationTimer gameAnimationTimer;
	private AnimationTimer soundAnimationtimer;
	private int frameBg = 0;
	private int frameSpace = 0;
	private boolean isPressedSpace = false;
	private int numberselected = 0;
	private boolean isHowto;
	private Image bgPic;
	private Image cursur;
	private Image howTo;
	private AudioClip sound;

	public StartWindow(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.bg = new Canvas(800, 480);
		this.gc = bg.getGraphicsContext2D();
		sound = new AudioClip(ClassLoader.getSystemResource("start.mp3").toString());
		sound.play();
		// TODO Auto-generated method stub ใส่เสียงด้วย

	}

	public void draw(GraphicsContext gc) {
		StackPane root = new StackPane();
		root.setPrefSize(800, 480);
		setBackground();
		addAction();
		root.getChildren().add(bg);
		Scene scene = new Scene(root);
		bg.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ragnarok");

		gameAnimationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				setBackground();
			}
		};
		gameAnimationTimer.start();
	}

	public void setBackground() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, bg.getWidth(), bg.getHeight());
		if (!isHowto) {
			bgPic = new Image(ClassLoader.getSystemResource("scene_start.png").toString());
			gc.drawImage(bgPic, 0, 0);
			cursur = new Image(ClassLoader.getSystemResource("cursor.png").toString());
			drawSelected();
		} else if (isHowto) {
			howTo = new Image(ClassLoader.getSystemResource("map.png").toString());
			gc.drawImage(howTo, 0, 0);
		}
	}

	public void addAction() {
		System.out.println("add action");
		if (!isHowto) {
			bg.setOnKeyPressed((KeyEvent) -> {
				if (KeyEvent.getCode() == KeyCode.UP) {
					if (numberselected != 0) {
						numberselected--;
						drawSelected();
					}
				}
				if (KeyEvent.getCode() == KeyCode.DOWN)
					if (numberselected != 1) {
						numberselected++;
						drawSelected();
					}
				if (KeyEvent.getCode() == KeyCode.SPACE) {
					if (numberselected == 0) {
						GameWindow game = new GameWindow(primaryStage);
						game.drawGameWindow();
						sound.stop();
					}
					if (numberselected == 1) {
						isHowto = true;
						addAction();
					}
				}
				if (KeyEvent.getCode() == KeyCode.ESCAPE) {
					Platform.exit();
				}

			});
		}
		if (isHowto) {
			bg.setOnKeyPressed((KeyEvent) -> {
				if (KeyEvent.getCode() == KeyCode.SPACE) {
					GameWindow game = new GameWindow(primaryStage);
					game.drawGameWindow();
					sound.stop();
				}
				if (KeyEvent.getCode() == KeyCode.ESCAPE) {
					Platform.exit();
				}
			});
		}
	}

	public void drawSelected() {
		setMenu();
		if (numberselected == 0) {
			gc.drawImage(cursur, 430, 400);
		}
		if (numberselected == 1) {
			gc.drawImage(cursur, 430, 440);
		}

	}

	public void setMenu() {
		setStart();
		setHowto();
	}

	public void setStart() {
		Image start = new Image(ClassLoader.getSystemResource("button_start.png").toString());
		gc.drawImage(start, 310, 380);
	}

	public void setHowto() {
		Image howTo = new Image(ClassLoader.getSystemResource("button_howto.png").toString());
		gc.drawImage(howTo, 310, 419);
	}

	public void startAnimation() {
		draw(gc);
	}

}
