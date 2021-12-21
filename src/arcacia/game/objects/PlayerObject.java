package arcacia.game.objects;

import arcacia.game.handler.*;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PlayerObject extends GameObject {
    public static final String path = ConstantHandler.pathImages + "James.png";

    public PlayerObject(Location currentLocation) {
        super(currentLocation);
        System.out.println(currentLocation);

    }

    /**
     * Bewegt den Spieler ein Feld weiter entsprechend der Eingabe. Wenn die neue Position in einer wand wäre passiert nichts
     * @param input die key eingabe in welche richtung sich der Spieler bewegen soll
     *
     */
    public boolean playerMove(int input) {

        if(input == -1) return false;

        int xPos = getLocation().getX();
        int yPos = getLocation().getY();

        Location newLocation = getLocation();

        System.out.println(input);
        switch (input) {
            case InputHandler.DIR_UP -> {
                if (LevelHandler.isWall(xPos, yPos - 1)) {
                    return false;
                }
                newLocation.setX(xPos);
                newLocation.setY((yPos - 1));
            }
            case InputHandler.DIR_DOWN -> {
                if (LevelHandler.isWall(xPos, yPos + 1)) {
                    System.out.println(xPos + " " + yPos + 1);
                    return false;
                }
                newLocation.setX(xPos);
                newLocation.setY((yPos + 1));
            }
            case InputHandler.DIR_LEFT -> {
                if (LevelHandler.isWall(xPos - 1, yPos)) {
                    return false;
                }
                newLocation.setX(xPos - 1);
                newLocation.setY((yPos));
            }
            case InputHandler.DIR_RIGHT -> {
                if (LevelHandler.isWall(xPos + 1, yPos)) {
                    return false;
                }
                newLocation.setX(xPos + 1);
                newLocation.setY((yPos));
            }
        }
        System.out.println("curr loc: " + getLocation());
        System.out.println("next loc: " + newLocation);
        GameObject tmp = LevelHandler.moveObjectTo(newLocation, this);

        CollisionHandler.collision(this, tmp);
        return true;
    }

    //Standard Konstruktor mit Leeren eingabe werten

    public PlayerObject(int x, int y) {
        super(new Location(x, y));
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
