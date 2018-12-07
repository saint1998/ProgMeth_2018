package graphic;

import com.sun.glass.events.KeyEvent;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameWindow extends Canvas {
	private static AnimationTimer gameWindowAnimation;
	private String control = "";
	private GraphicsContext gc;
	private Scene scene;
	private Stage primaryStage;
	private char c = 's';
	private int frame = 0;

	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(480);
		this.primaryStage = primaryStage;
		gc = getGraphicsContext2D();
		StackPane root = new StackPane();
		root.getChildren().add(gc.getCanvas());
		scene = new Scene(root);
		this.primaryStage.setScene(scene);
		requestFocus();
	}

	public void drawGameWindow() {
		frame = 0;
		gameWindowAnimation = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub

			}
		};
	}

	public void addMoving(GraphicsContext gc) {
		this.setOnKeyPressed((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {

			}

			if (KeyEvent.getCode() == KeyCode.RIGHT) {

			}

			if (KeyEvent.getCode() == KeyCode.UP) {

			}

			if (KeyEvent.getCode() == KeyCode.DOWN) {

			}

			if (KeyEvent.getCode() == KeyCode.SPACE) {

			}
		});
		this.setOnKeyReleased((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {

			}
			if (KeyEvent.getCode() == KeyCode.RIGHT) {

			}
			if (KeyEvent.getCode() == KeyCode.UP) {

			}
			if (KeyEvent.getCode() == KeyCode.DOWN) {

			}
		});
		
	}
	
	public static AnimationTimer geAnimationTimer() {
		return gameWindowAnimation;
	}

}
