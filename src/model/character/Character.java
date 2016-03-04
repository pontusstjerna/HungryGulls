package model.character;

/**
 * Created by Pontus on 2016-03-04.
 */
public abstract class Character {
    public enum Direction {RIGHT, LEFT, UP, DOWN}

    private double x,y;

    public void move(Direction dir){
        switch(dir){
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }
    }

    private void moveRight(){

    }

    private void moveLeft(){

    }

    private void moveUp(){

    }

    private void moveDown(){

    }
}
