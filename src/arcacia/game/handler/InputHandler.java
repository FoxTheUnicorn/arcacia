package arcacia.game.handler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputHandler implements KeyListener {

    public static final int DIR_UP = 0;
    public static final int DIR_DOWN = 1;
    public static final int DIR_LEFT = 2;
    public static final int DIR_RIGHT = 3;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(GameHandler.isRunning())
        {
            /* Steuerung für in game*/
            switch (keyCode) {
                case KeyEvent.VK_UP, KeyEvent.VK_W -> PlayerHandler.getPlayer().playerMove(DIR_UP);
                case KeyEvent.VK_DOWN, KeyEvent.VK_S -> PlayerHandler.getPlayer().playerMove(DIR_DOWN);
                case KeyEvent.VK_LEFT, KeyEvent.VK_A -> PlayerHandler.getPlayer().playerMove(DIR_LEFT);
                case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> PlayerHandler.getPlayer().playerMove(DIR_RIGHT);
            }
        }else{ /* Steuerung für Menüs */ }




    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
