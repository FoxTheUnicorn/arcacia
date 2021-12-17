package arcacia.game.objects.item;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;
import java.awt.image.BufferedImage;

public abstract class Item extends GameObject {
    public Item(Location currentLocation) {
        super(currentLocation);
    }

    public abstract void collect();
}
