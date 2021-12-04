package arcacia.game.handler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputHandler implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        int keyCode = e.getKeyCode();

       if(GameHandler.isRunning)
        {
            int up = 0;
            int down =1;
            int left = 2;
            int right = 3;
            /* Steuerung für in game*/
            switch (keyCode){
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    PlayerHandler.getPlayer().PlayerMove(up);
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    PlayerHandler.getPlayer().PlayerMove(down);
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    PlayerHandler.getPlayer().PlayerMove(left);
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    PlayerHandler.getPlayer().PlayerMove(right);
            }

        }else{ /* Steuerung für Menüs */ }




    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
