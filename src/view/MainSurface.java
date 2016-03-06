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

        int playerX = drawables.get(0).getX();
        int playerY = drawables.get(0).getY();

        for(int i = 1; i < drawables.size(); i++){
            g2d.drawString(drawables.get(i).toString(), drawables.get(i).getX() - playerX + (MainWindow.WINDOW_WIDTH/2),
                    drawables.get(i).getY() - playerY + (MainWindow.WINDOW_HEIGHT/2));

            g.drawImage(drawables.get(i).getImage(), drawables.get(i).getX() - playerX + (MainWindow.WINDOW_WIDTH/2),
                    drawables.get(i).getY() - playerY + (MainWindow.WINDOW_HEIGHT/2), this);
        }

        paintPlayer(g2d);
    }

    private void paintPlayer(Graphics2D g){
        g.drawString(drawables.get(0).toString(), MainWindow.WINDOW_WIDTH/2, MainWindow.WINDOW_HEIGHT/2);
        g.drawImage(drawables.get(0).getImage(),MainWindow.WINDOW_WIDTH/2, MainWindow.WINDOW_HEIGHT/2, this);
    }
}
