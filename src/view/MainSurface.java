package view;

import model.IDrawable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainSurface extends JPanel {
    List<IDrawable> drawables;

    public void init(List<IDrawable> drawables){
        setFocusable(true);
        this.drawables = drawables;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        super.paintComponent(g);

        for(IDrawable drawable : drawables){
            g.drawString(drawable.toString(), drawable.getX(), drawable.getY());
        }
    }
}
