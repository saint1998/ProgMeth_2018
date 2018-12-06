package graphic;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
	public Image bgPic;
	
	public StartWindow(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.bg = new Canvas(800,450);
		this.gc = bg.getGraphicsContext2D();
	}
	
	public void draw(GraphicsContext gc) {
		StackPane root = new StackPane();
		root.setPrefSize(800, 450);
		root.getChildren().add(bg);
		Scene scene = new Scene(root);
		bg.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ragnarok");
		
		gameAnimationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (frameBg == 50) {

				}
			}
		};
	}
	
	public void setBackground() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, bg.getWidth(), bg.getHeight());
		bgPic = new Image(ClassLoader.getSystemResource(name))
	}
	

}
