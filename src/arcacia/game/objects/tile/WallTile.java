package arcacia.game.objects.tile;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

public class WallTile extends GameObject {
    public WallTile(Location currentLocation) {
        super(currentLocation);
    }

    public WallTile(int x, int y) {
        super(new Location(x, y));
    }
}
