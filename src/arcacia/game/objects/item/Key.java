package arcacia.game.objects.item;

import arcacia.game.util.Location;

public class Key extends Item{

    public Key(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    public void collecting() {
        if(!isEingesammelt() && this.currentLocation.getX() == PlayerHandler.getX() && this.currentLocation.getY() == PlayerHandler.getY()) {
            setEingesammelt(true);
            PlayerHandler.setKey(true); //will be implemented
        }
    }
}
