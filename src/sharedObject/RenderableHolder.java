package sharedObject;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Logic.Bomb;
import Logic.Character;
import javafx.scene.image.Image;
import Logic.Field;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Image mapSprite;
	public Bomb bomb;
	
	static {
		loadResource();
	}
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}
	
	public static void loadResource() {
		mapSprite = new Image(ClassLoader.getSystemResource("map_background.png").toString());
		
	}
	
	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
		for(IRenderable x: entities){
			if(x instanceof Character) System.out.println("Character");
			if(x instanceof Field) System.out.println("field");
			if(x instanceof Bomb) System.out.println("Bomb");
		}

	}
	
	public void update() {
		for (IRenderable i : entities) {
			if(i instanceof Bomb) {
				((Bomb)i).update();
			}	
		}
	}
	
	public List<IRenderable> getEntities() {
		return entities;
	}

}
