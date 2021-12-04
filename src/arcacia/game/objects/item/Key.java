package arcacia.game.objects.item;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class Key extends Item{

    public Key(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    public void collecting() {
        if(!isEingesammelt() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setEingesammelt(true);
            PlayerHandler.setScore(PlayerHandler.getScore()+100);
            PlayerHandler.setHasKey(true);
        }
    }
}
