package arcacia.game.objects.item;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class SpeedItem extends Item{
    public SpeedItem(Location currentLocation) {
        super(currentLocation);
    }

    public void collecting() {
        if(!isCollected() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setTimer(10);
            setCollected(true);
            PlayerHandler.addToScore(getPoints());
            PlayerHandler.setSpeed(PlayerHandler.getSpeed() * 2);
        }
        if(getTimer() > 0)
            setTimer(getTimer()-1);
        else if(getTimer() == 0)
            PlayerHandler.setSpeed(PlayerHandler.getSpeed() / 2);
    }
}
