package arcacia.game.objects.tile;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DoorObject extends GameObject {
    public static final String pathClosed = ConstantHandler.pathImages + "DoorTile.png";
    public static final String pathOpen = ConstantHandler.pathImages + "DoorTileOPEN.png";
    public DoorObject(Location currentLocation) {
        super(currentLocation);
    }

    public BufferedImage getImage() {
        try {
            if(PlayerHandler.hasKey()){
                return ImageIO.read(new File(pathOpen));
            }
            else {
                return ImageIO.read(new File(pathClosed));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DoorObject(int x, int y) {
        super(new Location(x, y));
    }
}
