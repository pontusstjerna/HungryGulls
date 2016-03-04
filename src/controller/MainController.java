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

    private double tempTime;
    private double deltaTime;

    private final int DELAY = 5;

    public MainController(){

    }

    public void startGame(){
        initView();
        initTimer();
        initWorld();
        timer.start();
        System.out.println("Game started!");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        world.update();
        frame.repaint();
        setDeltaTime();
        System.out.println("DeltaTime: " + deltaTime);
    }

    public double getDeltaTime(){
        return deltaTime;
    }

    private void initView(){
        frame = new MainWindow("Hungry Gulls");
        frame.init();

        System.out.println("View initialized!");
    }

    private void initTimer(){
        timer = new Timer(DELAY, this);
    }

    private void initWorld(){
        world = new World();
    }

    private void setDeltaTime(){
        long currentTime = System.currentTimeMillis();
        deltaTime = (currentTime - tempTime)/1000;
        tempTime = currentTime;
    }
}
