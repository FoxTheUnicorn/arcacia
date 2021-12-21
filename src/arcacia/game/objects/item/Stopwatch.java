package arcacia.game.objects.item;

import arcacia.game.handler.*;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Dieses Item sorgt dafür, dass alle Gegner für ein paar Runden stehen bleiben.
 */
public class Stopwatch extends Item{
    public static final String path = ConstantHandler.pathImages + "stopwatch.png";
    public Stopwatch(Location currentLocation) {
        super(currentLocation);
    }

    /**
     * Eine Methode um das Bild zur Klasse zu bekommen.
     * @return Das Bild aus dem Filepath.
     */
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Diese Methode implementiert, was passiert, wenn die Münze eingesammelt wird und entfernt das Item danach.
     */
    public void collect() {
        PlayerHandler.addToScore(ConstantHandler.scoreItemPickup);
        GameHandler.setEnemyTimeout(ConstantHandler.itemStopwatchDuration);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
