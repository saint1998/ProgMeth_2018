package Drawing;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;

public class GameScreen extends Canvas {
	
	public GameScreen(double width, double height) {
		super(width, height);
		this.setVisible(true);
		addListerner();
	}
	
	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}

}
