package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Key extends Item{
    public static final String path = ConstantHandler.pathImages + "key.png";
    public Key(Location currentLocation) {
        super(currentLocation);
    }

    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void collect() {
        PlayerHandler.addToScore(ConstantHandler.scoreKeyPickup);
        PlayerHandler.setHasKey(true);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
