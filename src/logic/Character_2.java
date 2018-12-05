package logic;

import java.util.ArrayList;
import java.util.List;

import input.InputUtility;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Character_2 extends Character{
	private List<Image> left = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	private Image chpic;

	
	public Character_2(double x, double y) {
		super(x, y);
		setpic(new Image(ClassLoader.getSystemResource("c2_stand_Bot.png").toString()));
		for(int i = 1;i <5; ++i) {
			down.add(new Image(ClassLoader.getSystemResource("c2_move_Bot"+i+".png").toString()));
			right.add(new Image(ClassLoader.getSystemResource("c2_move_Right"+i+".png").toString()));
			left.add(new Image(ClassLoader.getSystemResource("c2_move_Left"+i+".png").toString()));
			up.add(new Image(ClassLoader.getSystemResource("c2_move_Top"+i+".png").toString()));
		}
	}

	@Override
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.UP)) {
			up();
			setpic(this.up.get(getTimeOfPic()/10));
		}
		else if (InputUtility.getKeyPressed(KeyCode.DOWN)) {
			down();
			setpic(this.down.get(getTimeOfPic()/10));
		}
		else if (InputUtility.getKeyPressed(KeyCode.RIGHT)) {
			right();
			setpic(this.right.get(getTimeOfPic()/10));
		}
		else if (InputUtility.getKeyPressed(KeyCode.LEFT)) {
			left();
			setpic(this.left.get(getTimeOfPic()/10));
		}

	}
	

}
