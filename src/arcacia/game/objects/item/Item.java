package arcacia.game.objects.item;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Die abstrakte Oberklasse für alle Items.
 */
public abstract class Item extends GameObject {
    public Item(Location currentLocation) {
        super(currentLocation);
    }

    public abstract void collect();
}
