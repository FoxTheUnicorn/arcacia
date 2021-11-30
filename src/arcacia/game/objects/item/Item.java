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
    int dauer = 10;//How long the item will last
    long points = 0;//what will be added to the score after the item is picked up
    boolean eingesammelt = false;//If the item was picked up

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

    public int getDauer() {
        return dauer;
    }
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public long getPoints() {
        return points;
    }
    public void setPoints(long points) {
        this.points = points;
    }

    public boolean isEingesammelt() {
        return eingesammelt;
    }
    public void setEingesammelt(boolean eingesammelt) {
        this.eingesammelt = eingesammelt;
    }



}
