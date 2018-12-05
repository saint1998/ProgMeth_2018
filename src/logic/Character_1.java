package logic;

import input.InputUtility;
import javafx.scene.input.KeyCode;

public class Character_1 extends Character {

	public Character_1(double x, double y) {
		super(x, y);
	}

	@Override
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.W))
			up();
		else if (InputUtility.getKeyPressed(KeyCode.S))
			down();
		else if (InputUtility.getKeyPressed(KeyCode.D))
			right();
		else if (InputUtility.getKeyPressed(KeyCode.A))
			left();	
	}

}
