package model;

import model.character.Character;

import java.awt.image.BufferedImage;

/**
 * Created by Pontus on 2016-03-04.
 */
public interface IDrawable {
    int getX();
    int getY();
    BufferedImage getImage();
    Character.State getState();
    String toString();
}
