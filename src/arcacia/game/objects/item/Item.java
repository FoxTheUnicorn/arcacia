package arcacia.game.objects.item;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;
import java.awt.image.BufferedImage;

public abstract class Item extends GameObject {
    public Item(Location currentLocation) {
        super(currentLocation);
    }

    String name;
    BufferedImage image;
    Location position;
    int timer = 0;//How long the item will last
    int points = 100;//what will be added to the score after the item is picked up
    boolean collected = false;//If the item was picked up

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Location getPosition() {
        return position;
    }
    public void setPosition(Location position) {
        this.position = position;
    }

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
