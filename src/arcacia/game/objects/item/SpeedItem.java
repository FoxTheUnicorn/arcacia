package arcacia.game.objects.item;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class SpeedItem extends Item{
    public SpeedItem(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    public void collecting() {
        if(!isEingesammelt() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setDauer(10);
            setEingesammelt(true);
            PlayerHandler.setScore(PlayerHandler.getScore()+100);
            PlayerHandler.setSpeed(PlayerHandler.getSpeed() * 2); //Will be implemented
        }
        if(getDauer() > 0)
            setDauer(getDauer()-1);
        else if(getDauer() == 0)
        {
            PlayerHandler.setSpeed(PlayerHandler.getSpeed() / 2);
        }
    }
}
