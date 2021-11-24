package arcacia.game.objects;

import java.io.File;
import arcacia.game.util.Location;

public abstract class GameObject {
    protected Location currentLocation;
    protected int speed;
    File texture;

    public GameObject(Location currentLocation) {
        this.currentLocation = currentLocation;
    }



    //region Getter and Setter


    public Location getLocation() {
        return currentLocation;
    }

    public void setLocation(Location location) {
        this.currentLocation = location;
    }

    public File getTexture() {
        return texture;
    }

    public void setTexture(File texture) {
        this.texture = texture;
    }

    //endregion
}
