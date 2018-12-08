package sharedObject;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import logic.Baphomet;
import logic.Character;
import logic.Fireball;
import logic.Monster;

public class RenderableHolder {
	private static final RenderableHolder r = new RenderableHolder();
	private List<IRenderable> object;

	public RenderableHolder() {
		object = new ArrayList<>();
	}

	public static RenderableHolder getinstance() {
		return r;
	}

	public void add(IRenderable i) {
		object.add(i);
	}

	public void draw(GraphicsContext gc) {
		for (int i = 0; i < object.size(); i++) {
			object.get(i).draw(gc);
		}
	}

	public void remove() {
		int n = object.size();
		for (int i = n - 1; i >= 0; i--) {
			if (object.get(i).isVisible() == false) {
				System.out.println("remove");
				object.remove(i);
			}
		}
	}

	public void updatePos(String control) {
		for (IRenderable i : object) {
			if (i instanceof Character) {
				((Character) i).setControl(control);
				((Character) i).updatePos();
			}
			if (i instanceof Fireball) {
				((Fireball) i).updatePos();
			}
			if (i instanceof Monster) {
				((Monster) i).updatePos();
			}
		}
	}

	public void Collision(Character character) {

		for (IRenderable i : object) {
			if (i instanceof Monster) {
				if (character.damaged(((Monster) i).getX(), ((Monster) i).getY(), ((Monster) i))) {
					System.out.println("monster attack");
					if (!(i instanceof Baphomet))
						((Monster) i).setVisible(false);
				}
			}
		}

	}

	public int killmonster() {
		int exp = 0;
		for (IRenderable i : object) {
			if (i instanceof Monster) {
				for (IRenderable j : object) {
					if (j instanceof Fireball) {
						if (((Monster) i).damaged(((Fireball) j).getX(), ((Fireball) j).getY(), (Fireball) j)) {
							((Fireball) j).setVisible(false);
							if (((Monster) i).getHp() == 0) {
								System.out.println("monster is damaged");
								((Monster) i).setVisible(false);
								((Fireball) j).setVisible(false);
								exp += 10;
							}
						}
					}
				}

			}

		}
		return exp;
	}

	public boolean isBossKilled() {
		for (IRenderable i : object) {
			if (i instanceof Baphomet)
				return false;
		}
		return true;
	}

	public void clearList() {
		this.object = null;
		this.object = new ArrayList<>();
	}
}
