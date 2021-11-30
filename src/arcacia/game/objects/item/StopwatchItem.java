package arcacia.game.objects.item;

import arcacia.game.util.Location;

public class StopwatchItem extends Item{

    public StopwatchItem(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    @Override
    public void collecting() {
        if(!isPickedUp() && this.currentLocation.getX()== PlayerHandler.getX() && this.currentLocation.getY() == PlayerHandler.getY()) {
            setPickedUp(true);
            GameHandler.setPauseEnemies(true); //will be implemented
        }
    }
}
