package arcacia.game.objects.item;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;
import java.awt.image.BufferedImage;

public abstract class Item extends GameObject {
    public Item(Location currentLocation) {
        super(currentLocation);
    }
    BufferedImage bufferedImage;
    /*
    Java BufferedImage class is a subclass of Image class. It is used to handle and manipulate the image data. A BufferedImage is made of ColorModel of
    image data. All BufferedImage objects have an upper left corner coordinate of (0, 0).
    This class supports three types of constructors.
    The second constructor constructs a BufferedImage of one of the predefined image types.
    BufferedImage(int width, int height, int imageType)
    The third constructor constructs a BufferedImage of one of the predefined image types: TYPE_BYTE_BINARY or TYPE_BYTE_INDEXED.
    BufferedImage(int width, int height, int imageType, IndexColorModel cm)
    */
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
