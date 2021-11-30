package arcacia.game.objects.item;

import arcacia.game.util.Location;

public class StopwatchItem extends Item{

    public StopwatchItem(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    public void collecting() {
        if(!isEingesammelt() && this.currentLocation.getX() == PlayerHandler.getX() && this.currentLocation.getY() == PlayerHandler.getY()) {
            setEingesammelt(true);
            GameHandler.setPauseEnemies(true); //will be implemented
        }
    }
}
