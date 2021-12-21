package arcacia.game.objects.item;

import arcacia.game.handler.*;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Stopwatch extends Item{
    public static final String path = ConstantHandler.pathImages + "stopwatch.png";
    public Stopwatch(Location currentLocation) {
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
        PlayerHandler.addToScore(ConstantHandler.scoreItemPickup);
        GameHandler.setEnemyTimeout(ConstantHandler.itemStopwatchDuration);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
