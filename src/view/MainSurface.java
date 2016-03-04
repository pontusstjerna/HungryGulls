package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainSurface extends JPanel {

    public void init(){
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        super.paintComponent(g);

        g.drawString("This is a text. ", 100,100);
    }
}
