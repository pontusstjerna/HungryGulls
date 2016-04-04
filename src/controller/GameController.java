package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by pontu on 2016-04-04.
 */
public class GameController implements KeyListener {

    private boolean showFps = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_P:
                showFps = true;
                break;
        }
    }

    public boolean getShowFps(){
        return showFps;
    }
}
