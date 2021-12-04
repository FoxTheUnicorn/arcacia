package arcacia.game.objects.item;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Multiplikator_Klasse extends Item{

    public Multiplikator_Klasse(Location currentLocation) {
        super(currentLocation);
    }

    public void collecting() {
        if(!isCollected() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setCollected(true);
            setTimer(20);
            PlayerHandler.setMultiplier(2);
        }
        if(getTimer() > 0)
            setTimer(getTimer()-1);
        else if(getTimer() == 0)
            PlayerHandler.setMultiplier(1);
    }
}
