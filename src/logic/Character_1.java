package logic;

import java.util.ArrayList;
import java.util.List;

import input.InputUtility;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Character_1 extends Character {
	private List<Image> left = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	private Image chpic;

	public Character_1(double x, double y) {
		super(x, y);
		setpic(new Image(ClassLoader.getSystemResource("c1_stand_Bot.png").toString()));
		for(int i = 1;i <5; ++i) {
			down.add(new Image(ClassLoader.getSystemResource("c1_move_Bot"+i+".png").toString()));
			right.add(new Image(ClassLoader.getSystemResource("c1_move_Right"+i+".png").toString()));
			left.add(new Image(ClassLoader.getSystemResource("c1_move_Left"+i+".png").toString()));
			up.add(new Image(ClassLoader.getSystemResource("c1_move_Top"+i+".png").toString()));
		}
	}

	@Override
	public void update() {
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			up();
			setpic(this.up.get(getTimeOfPic()/10));
		}
		else if (InputUtility.getKeyPressed(KeyCode.S)) {
			down();
			setpic(this.down.get(getTimeOfPic()/10));
		}
		else if (InputUtility.getKeyPressed(KeyCode.D)) {
			right();
			setpic(this.right.get(getTimeOfPic()/10));
		}
		else if (InputUtility.getKeyPressed(KeyCode.A)) {
			left();
			setpic(this.left.get(getTimeOfPic()/10));
		}
	}

}
