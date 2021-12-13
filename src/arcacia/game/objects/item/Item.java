package arcacia.game.objects.item;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;
import java.awt.image.BufferedImage;

public abstract class Item extends GameObject {
    public Item(Location currentLocation) {
        super(currentLocation);
    }

    int timer = 0;//How long the item will last
    int points = 100;//what will be added to the score after the item is picked up
    boolean collected = false;//If the item was picked up

    public abstract void collect();
    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isCollected() {
        return collected;
    }
    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
