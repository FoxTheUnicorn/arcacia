package arcacia.game.objects;

import arcacia.game.handler.*;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;


public class PlayerObject extends GameObject {
    public static final String path = ConstantHandler.pathImages + ""; //TODO Graphics
    private final Location startPlayer;

    public PlayerObject(Location currentLocation) {
        super(currentLocation);
        startPlayer = new Location(currentLocation.getX(), currentLocation.getY());
    }

    /**
     * Bewegt den Spieler ein Feld weiter entsprechend der Eingabe. Wenn die neue Position in einer wand wäre passiert nichts
     * @param input die key eingabe in welche richtung sich der Spieler bewegen soll
     *
     */
    public boolean playerMove(int input) {

        int xPos = PlayerHandler.getPlayer().getLocation().getX();
        int yPos = PlayerHandler.getPlayer().getLocation().getY();
        Location newLocation = PlayerHandler.getPlayer().getLocation();
        switch (input) {
            case InputHandler.DIR_UP -> {
                if (!LevelHandler.isWall(xPos, yPos + 1)) return false;
                newLocation.setX(xPos);
                newLocation.setY((yPos + 1));
            }
            case InputHandler.DIR_DOWN -> {
                if (!LevelHandler.isWall(xPos, yPos - 1)) return false;
                newLocation.setX(xPos);
                newLocation.setY((yPos - 1));
            }
            case InputHandler.DIR_LEFT -> {
                if (!LevelHandler.isWall(xPos - 1, yPos)) return false;
                newLocation.setX(xPos - 1);
                newLocation.setY((yPos));
            }
            case InputHandler.DIR_RIGHT -> {
                if (LevelHandler.isWall(xPos + 1, yPos)) return false;
                newLocation.setX(xPos + 1);
                newLocation.setY((yPos));
            }
        }
        GameObject tmp = LevelHandler.setObjectAt(newLocation, this);
        CollisionHandler.collision(this, tmp);
        return true;
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

    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
