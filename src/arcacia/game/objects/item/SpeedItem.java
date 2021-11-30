package arcacia.game.objects.item;

import arcacia.game.objects.PlayerObject;
import arcacia.game.util.Location;

public class SpeedItem extends Item{
    public SpeedItem(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    public void collecting() {
        if(!isEingesammelt() && this.currentLocation.getX() == PlayerHandler.getX() && this.currentLocation.getY() == PlayerHandler.getY()) {
            setEingesammelt(true);
            PlayerHandler.setSpeed(PlayerHandler.getSpeed() * 2); //Will be implemented
        }
    }
}
