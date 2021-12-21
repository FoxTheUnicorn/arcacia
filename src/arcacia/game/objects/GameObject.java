package arcacia.game.objects;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import arcacia.game.handler.InputHandler;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;

public abstract class GameObject {
    protected Location currentLocation;

    public GameObject(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    protected GameObject() {
    }
    //region Getter and Setter

    public Location getLocation() {
        return new Location(currentLocation);
    }

    public void setLocation(Location location) {
        this.currentLocation = location;
    }

    public abstract BufferedImage getImage();

    public boolean isSolid() {
        return false;
    }

    //endregion
}
