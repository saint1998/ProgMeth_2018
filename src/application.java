
import graphic.StartWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class application extends Application {

	@Override
	public void start(Stage primaryStage) {
		StartWindow startwindow = new StartWindow(primaryStage);
		primaryStage.show();
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
