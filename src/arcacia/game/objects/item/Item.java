package arcacia.game.objects.item;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;
import java.awt.image.BufferedImage;

public abstract class Item extends GameObject {
    public Item(Location currentLocation) {
        super(currentLocation);
    }
    private BufferedImage image;

    private int x;//Location X of item
    private int y;//Location Y of item

    private long points; //what will be added to the score after the item is picked up
    private int dauer; //How long the item will last
    private boolean eingesammelt = false; //If the item was picked up

    //Getter and setter of every attribute
    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public long getPoints() {
        return points;
    }
    public void setPoints(long points) {
        this.points = points;
    }

    public double getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }

    public boolean isEingesammelt() {
        return pickedUp;
    }
    public void setEingesammelt(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

}
