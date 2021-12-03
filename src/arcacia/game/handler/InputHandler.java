package arcacia.game.handler;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import arcacia.game.objects.PlayerObject;
import arcacia.game.util.Location;

public class InputHandler implements KeyListener {
   PlayerObject player = new PlayerObject();



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        int xPos = player.getLocation().getX();
        int yPos = player.getLocation().getY();
        int playerspeed = PlayerHandler.getSpeed();
        Location NewLocation = new Location();

        //Hier ist die If abfrage noch fehlerhaft eigentlich soll ein allgemeineres objekt geprüft werden damit sauber unterschieden werden kann ob es sicher hier um eingaben für einen Spieler oder im Menü handelt
        if(player instanceof PlayerObject)
        {
            /* Steuerung für in game*/
            switch (keyCode){
                case KeyEvent.VK_UP:
                    NewLocation.setX(xPos);
                    NewLocation.setY(yPos + playerspeed);
                    player.setLocation(NewLocation); //change y pos +1
                    break;
                case KeyEvent.VK_DOWN:
                    NewLocation.setX(xPos);
                    NewLocation.setY(yPos - playerspeed);
                    player.setLocation(NewLocation); //decrease y pos -1
                    break;
                case KeyEvent.VK_LEFT:
                    NewLocation.setX(xPos - playerspeed);
                    NewLocation.setY(yPos);
                    player.setLocation(NewLocation); //decrease y pos -1
                case KeyEvent.VK_RIGHT:
                    NewLocation.setX(xPos + playerspeed);
                    NewLocation.setY(yPos);
                    player.setLocation(NewLocation); //decrease y pos -1    //increase x pos +1
            }

        }else{ /* Steuerung für Menüs */ }




    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
/*
        Buttons input
 */






}
