package arcacia.game.objects;

import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

import java.awt.*;


public class PlayerObject extends GameObject {

    //protected static int speed = 4;
    private final Location startPlayer;


//    public void setLocation(int x,int y){
//        startPlayer.setY(y);
//        startPlayer.setX(x);
//    }
//
//    public Location getLocation(){
//        return startPlayer;
//    }


    public PlayerObject(Location currentLocation) {
        super(currentLocation);
        startPlayer = new Location(currentLocation.getX(), currentLocation.getY());


        // update();
    }

    /**
     * Bewegt den Spieler ein Feld weiter entsprechend der Eingabe. Wenn die neue Position in einer wand wäre passiert nichts
     * @param input die key eingabe in welche richtung sich der Spieler bewegen soll
     */
    public void PlayerMove(int input) {

        int xPos = PlayerHandler.getPlayer().getLocation().getX();
        int yPos = PlayerHandler.getPlayer().getLocation().getY();
        Location newLocation = PlayerHandler.getPlayer().getLocation();
        switch (input) {
            case 0: //UP
                if (!LevelHandler.isWall(xPos, yPos + 1)) {
                    newLocation.setX(xPos);
                    newLocation.setY((yPos++));
                    PlayerHandler.getPlayer().setLocation(newLocation);
                }
                break;
            case 1: //down
                if (!LevelHandler.isWall(xPos, yPos - 1)) {
                    newLocation.setX(xPos);
                    newLocation.setY((yPos--));
                    PlayerHandler.getPlayer().setLocation(newLocation);
                }
                break;
            case 2: //left
                if (!LevelHandler.isWall(xPos - 1, yPos)) {
                    newLocation.setX(xPos--);
                    newLocation.setY((yPos));
                    PlayerHandler.getPlayer().setLocation(newLocation);
                }
                break;
            case 3: //right
                if (!LevelHandler.isWall(xPos+1, yPos)) {
                newLocation.setX(xPos++);
                newLocation.setY((yPos));
                PlayerHandler.getPlayer().setLocation(newLocation);}
                break;
        }


    }

    //Standard Konstruktor mit Leeren eingabe werten
    public PlayerObject() {
        super(new Location(0, 0));
        startPlayer = new Location(0, 0);
    }

    public PlayerObject(int x, int y) {

        super(new Location(x, y));
        startPlayer = new Location(x, y);

    }


    public void draw(Graphics2D g2) {
        int tileX = 24;
        int tileY = 24;
        g2.setColor(Color.white);
        g2.fillRect(getLocation().getX(), getLocation().getY(), tileX, tileY);
    }


}
