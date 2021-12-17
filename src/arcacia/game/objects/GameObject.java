package arcacia.game.objects;


import java.io.File;

import arcacia.game.handler.InputHandler;
import arcacia.game.util.Location;

public abstract class GameObject {
    protected Location currentLocation;

    public GameObject(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    protected GameObject() {
    }


    //region Getter and Setter

    public Location getLocation() {
        return currentLocation;
    }

    public void setLocation(Location location) {
        this.currentLocation = location;
    }

    //endregion
}
