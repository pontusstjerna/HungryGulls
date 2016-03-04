package view;

import javax.swing.*;

/**
 * Created by Pontus on 2016-03-04.
 */
public class MainWindow extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    private final String title;
    private MainSurface surface;

    public MainWindow(String title){
        this.title = title;
    }

    public void init(){
        initWindow();
        initSurface();
    }

    private void initWindow(){
        setTitle(title);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initSurface(){
        surface = new MainSurface();
        surface.init();
        add(surface);
    }
}
