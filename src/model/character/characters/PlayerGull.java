package model.character.characters;

import model.character.Character;
import model.character.PickUpAble;

/**
 * Created by Pontus on 2016-03-04.
 */
public class PlayerGull extends Character {
    private int health = 100;
    private PickUpAble pickedUp;

    public PlayerGull(String name, double x, double y){
        super(name, x, y);
    }

    public void pickUp(){
        PickUpAble closest = closestPickup();
        if(pickUpWithinReach(closest, 2)){
            pickedUp = closest;
            System.out.println("Picked up " + closest);
        }
    }

    private PickUpAble closestPickup(){
        PickUpAble closest = PickUpAble.pickUpAbles.get(0);
        for(PickUpAble pickUp : PickUpAble.pickUpAbles){
            if(pickUp.getDistance(x,y) > closest.getDistance(x,y)){
                closest = pickUp;
            }
        }
        return closest;
    }

    private boolean pickUpWithinReach(PickUpAble pickUp, double minDistance){
        return (pickUp.getDistance(x,y) <= minDistance);
    }
}
