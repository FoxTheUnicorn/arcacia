package arcacia.game.objects.item;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Multiplikator_Klasse extends Item_Klasse{
    int scale;

    public int getScale() {
        return scale;
    }
    public void setScale(int scale) {
        this.scale = scale;
    }

    public Multiplikator_Klasse(String name, Location multiplikator, double dauer, int scale) {
        setName(name);
        setPosition(multiplikator);
        setDauer(dauer);
        setScale(scale);
    }

    public void multiplicate(){
        setPoints((getPoints()+100)*scale);
    }

    public void einsammeln(Object object){
        setEingesammelt(true);
        ((Multiplikator_Klasse) object).multiplicate();
        setDauer(0);
    }
}
