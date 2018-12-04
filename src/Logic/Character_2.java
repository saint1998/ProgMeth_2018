package Logic;

import input.InputUtility;
import javafx.scene.input.KeyCode;

public class Character_2 extends Character{
	

	public Character_2(double x, double y) {
		super(x, y);
	}

	@Override
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.UP))
			up();
		else if (InputUtility.getKeyPressed(KeyCode.DOWN))
			down();
		else if (InputUtility.getKeyPressed(KeyCode.RIGHT))
			right();
		else if (InputUtility.getKeyPressed(KeyCode.LEFT))
			left();
		else if(InputUtility.getKeyPressed(KeyCode.ENTER))
			bomb();

		
		
	}
	

}
