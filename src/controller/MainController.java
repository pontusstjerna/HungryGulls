package controller;

import view.MainWindow;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainController {
    MainWindow frame;

    public MainController(){

    }

    public void startGame(){
        initView();
        System.out.println("Game started!");
    }

    private void initView(){
        frame = new MainWindow("Hungry Gulls");
        frame.init();

        System.out.println("View initialized!");
    }
}
