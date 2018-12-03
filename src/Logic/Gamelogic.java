package Logic;

import java.util.ArrayList;
import java.util.List;

import Logic.Entity;
import sharedObject.RenderableHolder;




public class Gamelogic {
	private List<Entity> gameObjectContainer;

	private Character character;
	
	public Gamelogic(){
		this.gameObjectContainer = new ArrayList<Entity>();
		
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		character = new Character();
		addNewObject(character);
	}
	
	protected void addNewObject(Entity entity){
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		character.update();
	}

}
