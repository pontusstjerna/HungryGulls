package model.character;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public abstract class PickUpAble extends Character {
    public static List<PickUpAble> pickUpAbles = new ArrayList<>();

    public PickUpAble(String name, double x, double y){
        super(name, x, y);
        pickUpAbles.add(this);
    }

    public void lockToCharacter(Character character){
        x = character.getX();
        y = character.getY();
        System.out.println(name + " locked to " + character);
    }


}
