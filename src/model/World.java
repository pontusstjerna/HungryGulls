package model;

import model.character.CharacterFactory;
import model.character.characters.IPlayable;
import model.character.characters.PlayerGull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class World {
    private IPlayable player;
    private List<IDrawable> characters = new ArrayList<>();

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
        createCharacters();

        System.out.println("World created with " + characters.size() + " characters.");
    }

    private void createCharacters(){
        player = CharacterFactory.createPlayer("Player", 100, 100);
        characters.add(player);
        characters.add(CharacterFactory.createMackerel("Mackerel 1", 100, 300));
        characters.add(CharacterFactory.createMackerel("Mackerel 2", 100, 50));
    }
}
