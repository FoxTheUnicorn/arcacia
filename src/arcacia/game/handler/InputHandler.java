package arcacia.game.handler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputHandler implements KeyListener {

    public static boolean BUTTON_UP = false;
    public static boolean BUTTON_DOWN = false;
    public static boolean BUTTON_LEFT = false;
    public static boolean BUTTON_RIGHT = false;

    public static final int DIR_UP = 0;
    public static final int DIR_DOWN = 1;
    public static final int DIR_LEFT = 2;
    public static final int DIR_RIGHT = 3;

    public static int getPressedButton() {
        if(BUTTON_UP) {
            return DIR_UP;
        }else if(BUTTON_DOWN) {
            return DIR_DOWN;
        }else if(BUTTON_LEFT) {
            return DIR_LEFT;
        }else if(BUTTON_RIGHT) {
            return DIR_RIGHT;
        }
        return -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP, KeyEvent.VK_W -> BUTTON_UP = true;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> BUTTON_DOWN = true;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> BUTTON_LEFT = true;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> BUTTON_RIGHT = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP, KeyEvent.VK_W -> BUTTON_UP = false;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> BUTTON_DOWN = false;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> BUTTON_LEFT = false;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> BUTTON_RIGHT = false;
        }
    }


}
