package application;

import Drawing.GameScreen;
import Logic.Gamelogic;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Logic.Gamelogic;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bomb It");
		
		Gamelogic logic = new Gamelogic();
		GameScreen gameScreen = new GameScreen(640, 840);
		root.getChildren().add(gameScreen);
		gameScreen.requestFocus();
		
		primaryStage.show();
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.paintComponent();
			}
			
		};
		
		animation.start();

		

	}

	public static void main(String[] args) {
		launch(args);
	}
}
