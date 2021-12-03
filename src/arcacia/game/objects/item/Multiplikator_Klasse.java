package arcacia.game.objects.item;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Multiplikator_Klasse extends Item{
    int scale;

    public int getScale() {
        return scale;
    }
    public void setScale(int scale) {
        this.scale = scale;
    }

    public Multiplikator_Klasse(String name, Location multiplikator, int dauer, int scale) {
        setName(name);
        setPosition(multiplikator);
        setDauer(dauer);
        setScale(scale);
    }

    public void multiplicate(){
        setPoints((getPoints()+100)*scale);
    }

    public void einsammeln(){
        if(!isEingesammelt() && this.currentLocation.getX() == PlayerHandler.getX() && this.currentLocation.getY() == PlayerHandler.getY()) {
            setEingesammelt(true);
            this.multiplicate();
            setDauer(0);
        }
    }
}
