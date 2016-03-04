package model.character;

import model.character.characters.Mackerel;
import model.character.characters.PlayerGull;

/**
 * Created by Pontus on 2016-03-04.
 */
public class CharacterFactory {

    public static PlayerGull createPlayer(String name, double x, double y){
        return new PlayerGull(name, x, y);
    }

    public static Character createMackerel(String name, double x, double y){
        return new Mackerel(name, x, y);
    }

}
