package model.character;

import model.IDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public abstract class Character implements IDrawable {
    public enum Direction {RIGHT, LEFT, UP, DOWN}
    public List<Character> characters = new ArrayList<>();

    protected double x,y;
    protected double speedX = 1;
    protected double speedY = 1;
    protected String name = "Unnamed.";

    public Character(String name, double x, double y){
        characters.add(this);
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double getDistance(double x, double y){
        double dx = this.x - x;
        double dy = this.y - y;

        //Pythagoras
        return Math.sqrt((dx*dx) + (dy*dy));
    }

    @Override
    public int getX(){
        return (int)x;
    }

    @Override
    public int getY(){
        return (int)y;
    }

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

    @Override
    public String toString(){
        return name + " X: " + x + " Y: " + y + " SpeedX: " + speedX + " SpeedY: " + speedY;
    }

    private void moveRight(){
        x += speedX;
    }

    private void moveLeft(){
        x -= speedX;
    }

    private void moveUp(){
        y -= speedY;
    }

    private void moveDown(){
        y += speedY;
    }
}
