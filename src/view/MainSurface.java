package view;

import controller.UIController;
import controller.MainController;
import model.IDrawable;
import model.World;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainSurface extends JPanel {
    List<IDrawable> drawables;
    IDrawable player;
    BufferedImage background;
    BufferedImage world;

    private int scaleX = 1;
    private int scaleY = 1;
    private int centerX = MainWindow.WINDOW_WIDTH/2;
    private int centerY = MainWindow.WINDOW_HEIGHT/2;

    public MainSurface(List<IDrawable> drawables, BufferedImage world, BufferedImage background){
        setFocusable(true);
        this.drawables = drawables;
        player = drawables.get(0);
        this.background = background;
        this.world = world;
        System.out.println("Surface initialized!");
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);

        paintBackground(g2d);
        paintForeground(g2d);
        paintDrawables(g2d);
        paintPlayer(g2d);
        paintFps(g2d);
    }

    private void paintPlayer(Graphics2D g){
        g.drawImage(player.getImage(),
                centerX,
                centerY,
                this);
    }

    private void paintDrawables(Graphics2D g){ //From model to view coordinates
        for(int i = 1; i < drawables.size(); i++){ //Loop without first element
            g.drawImage(drawables.get(i).getImage(),
                    (drawables.get(i).getX() - player.getX() + centerX)*scaleX,
                    (drawables.get(i).getY() - player.getY() + centerY)*scaleY,
                    this);
        }
    }

    private void paintForeground(Graphics2D g){
        int x = player.getX();
        int y = player.getY();

        if(x - centerX < 0 && y - centerY < 0){ //Upper left corner
            g.drawImage(clipImage(centerX, centerY, world), centerX - x, centerY - y, this);
        }
        else if(x - centerX < 0){ //Left wall
            g.drawImage(clipImage(centerX, y, world), centerX - x, 0, this);
        }else if(x + centerX > World.WORLD_WIDTH){ //Right wall
            g.drawImage(clipImage(World.WORLD_WIDTH - centerX, y, world), World.WORLD_WIDTH - x - centerX, 0, this);
        }else if(y - centerY < 0){ //Roof
            g.drawImage(clipImage(x, centerY, world), 0, centerY - y, this);
        }else{ //Middle
            g.drawImage(clipImage(x, y, world), (0), (0), this);
        }
    }

    private void paintBackground(Graphics2D g){
        g.drawImage(clipImage(player.getX(), player.getY(), background),
                player.getX()/3,
                player.getY()/3,
                this);
    }

    private void paintFps(Graphics2D g){
        try{
            if(((UIController)getKeyListeners()[1]).getShowFps()){ //Check if player has enabled fps
                g.drawString("FPS: " + MainController.getFPS(), MainWindow.WINDOW_WIDTH*9/20,
                        MainWindow.WINDOW_HEIGHT*3/4);
            }
        }catch (ClassCastException e){
            System.out.println("Unable to get the game controller!");
        }
    }

    private BufferedImage clipImage(int x, int y, BufferedImage uncut){

        //Clips the image so only what fits in window is visible
        return uncut.getSubimage(
                x - centerX,
                y - centerY,
                MainWindow.WINDOW_WIDTH,
                MainWindow.WINDOW_HEIGHT);
    }
}
