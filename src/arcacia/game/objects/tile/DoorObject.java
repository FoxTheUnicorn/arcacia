package arcacia.game.objects.tile;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

public class DoorObject extends GameObject {

    public DoorObject(Location currentLocation) {
        super(currentLocation);
    }

    public DoorObject(int x, int y) {
        super(new Location(x, y));
    }
}
