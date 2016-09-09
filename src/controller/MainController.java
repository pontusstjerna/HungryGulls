package controller;

import model.World;
import view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pontus on 2016-03-04.
 */
public final class MainController implements ActionListener {
    private MainWindow frame;
    private World world;
    private PlayerController playerController;

    private double tempTime;
    private static double deltaTime;
    private static int FPS = 0;

    private final int DELAY = 5;

    public MainController(){

    }

    public void startGame(){
        world = new World();

        //Initialize the player controls
        playerController = new PlayerController(world.getPlayer());

        initView();
        new Timer(DELAY, this).start();

        System.out.println("Game started!");
        System.out.println("------------------------------");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        playerController.update();
        world.update();
        frame.repaint();
        setDeltaTime();
        setFPS();
    }

    public static double getDeltaTime(){return deltaTime;}
    public static double getFPS(){
        return FPS;
    }

    private void initView(){
        frame = new MainWindow("Hungry Gulls");
        frame.init(world.getDrawables());

        //Controller for player/gull
        frame.registerKeyListener(playerController);

        //Controller for UI-features
        frame.registerKeyListener(new UIController());
    }

    private void setDeltaTime(){
        long currentTime = System.currentTimeMillis();
        deltaTime = (currentTime - tempTime)/1000;
        tempTime = currentTime;
    }

    private double timePassed = 0;
    private void setFPS(){
        final int fpsUpdateInterval = 1;
        timePassed += deltaTime;
        if(timePassed > fpsUpdateInterval){
            FPS = (int)(1/deltaTime);
            timePassed = 0;
        }
    }
}
