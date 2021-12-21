package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Die Klasse zum Münzitem, welches den Score um 1 erhöht.
 */
public class CoinItem extends Item {
    public static final String path = ConstantHandler.pathImages + "mediumcoin.png";

    /**
     * Der Konstruktor zur Klasse Münze.
     * @param currentLocation
     */
    public CoinItem(Location currentLocation) {
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
        PlayerHandler.addToScore(ConstantHandler.scoreCoinCollect);
    }
}
