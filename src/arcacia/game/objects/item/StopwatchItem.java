package arcacia.game.objects.item;

import arcacia.game.util.Location;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.PlayerObject;

public class StopwatchItem extends Item{

    public StopwatchItem(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    public void collecting() {
        if(!isEingesammelt() && this.currentLocation.getX() == PlayerObject.super().getLocation().getX() && this.currentLocation.getY() == PlayerObject.super.getLocation().getY()) { //Changes noch nicht abgesprochen aber ein vorschlag für die Item Klasse
            setEingesammelt(true);
            GameHandler.setPauseEnemies(true); //will be implemented
        }
    }
}
