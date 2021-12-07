package arcacia.game.objects.item;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Multiplier extends Item {

    public Multiplier(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        setCollected(true);
        PlayerHandler.setMultiplier(2);
    }
}