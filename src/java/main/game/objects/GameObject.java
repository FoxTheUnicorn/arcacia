package java.main.game.objects;

import java.io.File;
import java.main.game.util.Location;

public abstract class GameObject {
    Location location;
    File texture;

    public GameObject() {
    }

    //region Getter and Setter

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public File getTexture() {
        return texture;
    }

    public void setTexture(File texture) {
        this.texture = texture;
    }

    //endregion
}
