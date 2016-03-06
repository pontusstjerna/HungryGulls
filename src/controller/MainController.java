package controller;

import model.World;
import view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainController implements ActionListener {
    private MainWindow frame;
    private Timer timer;
    private World world;
    private PlayerController playerController;

    private double tempTime;
    private double deltaTime;

    private final int DELAY = 5;

    public MainController(){

    }

    public void startGame(){
        initWorld();
        initPlayerControls();
        initView();
        initTimer();
        timer.start();
        System.out.println("Game started!");
        System.out.println("------------------------------");

    }

    @Override
    public void actionPerformed(ActionEvent e){
        playerController.update();
        world.update();
        frame.repaint();
        setDeltaTime();
    }

    public double getDeltaTime(){
        return deltaTime;
    }

    private void initPlayerControls(){
        playerController = new PlayerController(world.getPlayer());
    }

    private void initView(){
        frame = new MainWindow("Hungry Gulls");
        frame.init(world.getDrawables());
        frame.registerKeyListener(playerController);

        System.out.println("View initialized!");
    }

    private void initTimer(){
        timer = new Timer(DELAY, this);
    }

    private void initWorld(){
        world = new World();
        System.out.println("World initialized!");
    }

    private void setDeltaTime(){
        long currentTime = System.currentTimeMillis();
        deltaTime = (currentTime - tempTime)/1000;
        tempTime = currentTime;
    }
}
