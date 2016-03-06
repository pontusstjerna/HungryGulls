package model;

import model.character.CharacterFactory;
import model.character.characters.IPlayable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class World implements IDrawable {
    public static final int WORLD_WIDTH = 2000;
    public static final int WORLD_HEIGHT = 1000;

    private IPlayable player;
    private List<IDrawable> characters = new ArrayList<>();
    private BufferedImage worldImage;

    public World(){
        createWorld();
    }

    public void update(){

    }

    public IPlayable getPlayer(){
        return player;
    }

    public List<IDrawable> getDrawables(){
        return characters;
    }

    private void createWorld(){
        worldImage = ImageHandler.loadImage(getClass().getSimpleName());
        createCharacters();

        System.out.println("World created with " + (characters.size() - 1) + " characters.");
    }

    private void createCharacters(){
        player = CharacterFactory.createPlayer("PlayerGull", 500, 500);
        characters.add(player);
        characters.add(this);
        characters.add(CharacterFactory.createMackerel("Mackerel 1", 100, 300));
        characters.add(CharacterFactory.createMackerel("Mackerel 2", 100, 50));
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public BufferedImage getImage() {
        return worldImage;
    }

    @Override
    public String toString(){
        return "World with " + (characters.size() - 1) + " characters.";
    }
}
