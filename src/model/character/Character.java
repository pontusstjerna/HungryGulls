package model.character;

import model.IDrawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public abstract class Character implements IDrawable {
    public enum Direction {RIGHT, LEFT, UP, DOWN}
    public List<Character> characters = new ArrayList<>();

    protected Point.Double position;
    protected double speedX = 1;
    protected double speedY = 1;
    protected String name = "Unnamed.";

    public Character(String name, double x, double y){
        characters.add(this);
        this.name = name;
        position = new Point.Double(x,y);
    }

    public double getDistance(double x, double y){
        double dx = position.x - x;
        double dy = position.y - y;

        //Pythagoras
        return Math.sqrt((dx*dx) + (dy*dy));
    }

    public double getDistance(Point.Double position){
        return position.distance(this.position);
    }

    @Override
    public int getX(){
        return (int)position.x;
    }

    @Override
    public int getY(){
        return (int)position.y;
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
        return name + " X: " + position.x + " Y: " + position.y + " SpeedX: " + speedX + " SpeedY: " + speedY;
    }

    private void moveRight(){
        position.x += speedX;
    }

    private void moveLeft(){
        position.x -= speedX;
    }

    private void moveUp(){
        position.y -= speedY;
    }

    private void moveDown(){
        position.y += speedY;
    }
}
