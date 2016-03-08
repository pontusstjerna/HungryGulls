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
    Image background;

    private int scaleX = 1;
    private int scaleY = 1;

    public MainSurface(List<IDrawable> drawables, Image background){
        setFocusable(true);
        this.drawables = drawables;
        this.background = background;
        System.out.println("Surface initialized!");
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);

        paintBackground(g2d);
        paintDrawables(g2d);
        paintPlayer(g2d);
    }

    private void paintPlayer(Graphics2D g){
        g.drawImage(drawables.get(0).getImage(),
                (MainWindow.WINDOW_WIDTH/2), //Should be player.width/2
                (MainWindow.WINDOW_HEIGHT/2),
                this);
    }

    private void paintDrawables(Graphics2D g){ //From model to view coordinates
        for(int i = 1; i < drawables.size(); i++){ //Loop without first element
            g.drawImage(drawables.get(i).getImage(),
                    (drawables.get(i).getX() - drawables.get(0).getX() + (MainWindow.WINDOW_WIDTH/2))*scaleX,
                    (drawables.get(i).getY() - drawables.get(0).getY() + (MainWindow.WINDOW_HEIGHT/2))*scaleY,
                    this);
        }
    }

    private void paintBackground(Graphics2D g){
        g.drawImage(background,
                (-drawables.get(0).getX())/3,
                (-drawables.get(0).getY())/3,
                this);
    }
}
