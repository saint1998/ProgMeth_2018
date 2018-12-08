package graphic;

import java.util.Random;

import com.sun.glass.events.KeyEvent;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import logic.Baphomet;
import logic.Character;
import logic.Drops;
import logic.Horong;
import logic.Hydra;
import logic.Monster;
import logic.Poring;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class GameWindow extends Canvas {
	private static AnimationTimer gameWindowAnimation;
	private Random rand = new Random();
	private GameScreen gameScreen;
	private String control = "";
	private GraphicsContext gc;
	private Scene scene;
	private Stage primaryStage;
	private Character character;
	private Monster monster;
	private int monsteramount;
	private char c = 's';
	private int frame = 0;
	private boolean isPaused = false;
	private AudioClip soundbg;
	private boolean isBoss;
	private boolean isBossAdded;

	public GameWindow(Stage primaryStage) {
		setWidth(800);
		setHeight(480);
		this.primaryStage = primaryStage;
		gc = getGraphicsContext2D();
		StackPane root = new StackPane();
		root.getChildren().add(gc.getCanvas());
		scene = new Scene(root);
		this.primaryStage.setScene(scene);
		addAll();
		soundbg = new AudioClip(ClassLoader.getSystemResource("ingame.mp3").toString());
		soundbg.play();
		requestFocus();
	}

	public void drawGameWindow() {
		frame = 0;
		addMoving(gc);
		gameWindowAnimation = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				updateDetail();
				updateSound();

			}
		};
		gameWindowAnimation.start();
	}

	public void addMoving(GraphicsContext gc) {

		this.setOnKeyPressed((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {
				control += "a";
				c = 'a';
				System.out.println(control);
			}
			if (KeyEvent.getCode() == KeyCode.RIGHT) {
				control += "d";
				c = 'd';
				System.out.println(control);
			}
			if (KeyEvent.getCode() == KeyCode.UP) {
				control += "w";
				c = 'w';
				System.out.println(control);
			}
			if (KeyEvent.getCode() == KeyCode.DOWN) {
				control += "s";
				c = 's';
				System.out.println(control);
			}
			if (KeyEvent.getCode() == KeyCode.SPACE) {
				character.attack(c);
			}
			if (KeyEvent.getCode() == KeyCode.P) {
				if (!isPaused) {
					gameWindowAnimation.stop();
					isPaused = true;
				} else {
					gameWindowAnimation.start();
					isPaused = false;
				}
			}
			if(KeyEvent.getCode() == KeyCode.B) {
				isBoss = true;

			}

		});

		this.setOnKeyReleased((KeyEvent) -> {
			if (KeyEvent.getCode() == KeyCode.LEFT) {
				control = control.replace("a", "");
				RenderableHolder.getinstance().updatePos(control);
			}

			if (KeyEvent.getCode() == KeyCode.RIGHT) {
				control = control.replace("d", "");
				RenderableHolder.getinstance().updatePos(control);
			}

			if (KeyEvent.getCode() == KeyCode.UP) {
				control = control.replace("w", "");
				RenderableHolder.getinstance().updatePos(control);
			}

			if (KeyEvent.getCode() == KeyCode.DOWN) {
				control = control.replace("s", "");
				RenderableHolder.getinstance().updatePos(control);
			}

			if (KeyEvent.getCode() == KeyCode.SPACE) {
				RenderableHolder.getinstance().updatePos(control);
			}

		});

	}

	public void updateDetail() {
		frame++;
		if (!isBoss) {
			if (frame % 600 < 500) {
				if (frame % 50 == 0) {
					addMonster();
				}
			}
			RenderableHolder.getinstance().remove();
			RenderableHolder.getinstance().draw(gc);
			RenderableHolder.getinstance().updatePos(control);
			int exp = RenderableHolder.getinstance().killmonster();
			RenderableHolder.getinstance().Collision(character);
			character.setExp(character.getExp() + exp);
			character.updateLv();
			gameScreen.setCharacterData(character.getLv(), character.getExp(), character.getMaxExp(),
					character.getLife());
			if(character.getLv() == 9) isBoss = true;
		}
		if(isBoss) {
			if(!isBossAdded) {
				addMonster();
				isBossAdded = true;
			}
			RenderableHolder.getinstance().remove();
			RenderableHolder.getinstance().draw(gc);
			RenderableHolder.getinstance().updatePos(control);
			int exp = RenderableHolder.getinstance().killmonster();
			RenderableHolder.getinstance().Collision(character);
			
		}
	}

	public void updateSound() {
		if (!soundbg.isPlaying()) {
			soundbg.play();
		}
	}

	public void updateState() {

	}

	public void addAll() {
		addGameScreen();
		addCharacter();
		addMonster();
	}

	public void addGameScreen() {
		gameScreen = new GameScreen();
		RenderableHolder.getinstance().add(gameScreen);
	}

	public void addCharacter() {
		character = new Character();
		RenderableHolder.getinstance().add(character);
	}

	public void addMonster() {
		int i = character.getLv();
		if (i >= 1 && i < 3)
			monster = new Drops(character);
		if (i >= 3 && i < 5)
			monster = new Poring(character);
		if (i >= 5 && i < 7)
			monster = new Horong(character);
		if (i >= 7 && i < 9)
			monster = new Hydra(character);
		if( isBoss) monster = new Baphomet(character);
		RenderableHolder.getinstance().add(monster);
	}

	public static AnimationTimer geAnimationTimer() {
		return gameWindowAnimation;
	}

}
