package Logic;

import java.util.ArrayList;
import java.util.List;

import Logic.Entity;
import sharedObject.RenderableHolder;

public class Gamelogic {
	private List<Entity> gameObjectContainer;

	private Character_1 character1;
	private Character_2 character2;

	public Gamelogic() {
		this.gameObjectContainer = new ArrayList<Entity>();

		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		character1 = new Character_1(200.0 , 200.0);
		character2 = new Character_2(300, 300);
		addNewObject(character1);
		addNewObject(character2);
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public void logicUpdate() {
		character1.update();
		character2.update();
	}

}
