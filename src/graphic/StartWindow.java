package graphic;

import com.sun.glass.events.KeyEvent;

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
	private int frameBg = 0;
	private int frameSpace = 0;
	private boolean isPressedSpace = false;
	private int numberselected = 0;
	public Image bgPic;

	public StartWindow(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.bg = new Canvas(800, 480);
		this.gc = bg.getGraphicsContext2D();
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
		bgPic = new Image(ClassLoader.getSystemResource("start_scene.png").toString());
		gc.drawImage(bgPic, 0, 0);
		drawSelectedColor();
	}

	public void addAction() {
		bg.setOnKeyPressed((KeyEvent) -> {
			if (!isPressedSpace) {
				if (KeyEvent.getCode() == KeyCode.UP) {
					if (numberselected != 0) {
						numberselected--;
						drawSelectedColor();
					}
				}
			}
		});
	}

	public void drawSelectedColor() {
		setMenu();
		if(numberselected == 0) {
			
		}
		if(numberselected == 1) {
			
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