package graphic;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
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
import sharedObject.RenderableHolder;

public class GameWindow extends Canvas {
	private static AnimationTimer gameWindowAnimation;
	private GameScreen gameScreen;
	private String control = "";
	private GraphicsContext gc;
	private Scene scene;
	private Stage primaryStage;
	private Character character;
	private Monster monster;
	private int gameEndingtime, frame;
	private char c = 's';
	private AudioClip soundbg, soundboss;
	private boolean isBoss, isBossAdded, isGameEnd, isWin, isPaused, isFire;

	public GameWindow(Stage primaryStage) {
		this.gameEndingtime = 50;
		this.frame = 0;
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
		soundboss = new AudioClip(ClassLoader.getSystemResource("boss.mp3").toString());
		soundbg.play();
		requestFocus();
	}

	public void drawGameWindow() {
		frame = 0;
		addMoving(gc);
		gameWindowAnimation = new AnimationTimer() {

			@Override
			public void handle(long now) {
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
				if (!isGameEnd && !isFire) {
					isFire = true;
					character.attack(c);
				}
			}
			if (KeyEvent.getCode() == KeyCode.ENTER) {
				if (isGameEnd) {
					isGameEnd = false;
					isBoss = false;
					StartWindow start = new StartWindow(primaryStage);
					start.startAnimation();
					RenderableHolder.getinstance().clearList();
					GameWin.stopsound();
					GameOver.stopsound();
				}
			}
			if (KeyEvent.getCode() == KeyCode.ESCAPE) {
				Platform.exit();
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
			if (KeyEvent.getCode() == KeyCode.B) {
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
				isFire = false;
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
			if (character.getLv() == 9)
				isBoss = true;
			if (character.getLife() == 0) {
				if (gameEndingtime != 0)
					gameEndingtime--;
				isGameEnd = true;
			}

		}
		if (isBoss) {
			if (!isBossAdded) {
				addMonster();
				isBossAdded = true;
			}
			RenderableHolder.getinstance().remove();
			RenderableHolder.getinstance().draw(gc);
			RenderableHolder.getinstance().updatePos(control);
			int exp = RenderableHolder.getinstance().killmonster();
			RenderableHolder.getinstance().Collision(character);
			if (RenderableHolder.getinstance().isBossKilled()) {
				if (gameEndingtime != 0)
					gameEndingtime--;
				isGameEnd = true;
				isWin = true;
			}
			if (character.getLife() == 0) {
				if (gameEndingtime != 0)
					gameEndingtime--;
				isGameEnd = true;
				isWin = false;
			}
		}
		if (gameEndingtime == 0) {
			gameEndingtime = 50;
			gameWindowAnimation.stop();
			if (isWin)
				GameWin.startAnimation(gc);
			else
				GameOver.startAnimation(gc);
			soundbg.stop();
			soundboss.stop();
		}

	}

	public void updateSound() {
		if (!isBoss && !isGameEnd) {
			if (!soundbg.isPlaying()) {
				soundbg.play();
			}
		}
		if (isBoss && !isGameEnd) {
			soundbg.stop();
			if (!soundboss.isPlaying()) {
				soundboss.play();
			}
		}
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
		if (isBoss)
			monster = new Baphomet(character);
		RenderableHolder.getinstance().add(monster);
	}

	public static AnimationTimer geAnimationTimer() {
		return gameWindowAnimation;
	}

}
