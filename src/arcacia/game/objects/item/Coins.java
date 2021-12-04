package arcacia.game.objects.item;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class Coins extends Item{
    private int value; //Wieviel die Münze wert ist

    public Coins(Location currentLocation, int value) {
        super(currentLocation);
        this.value = value;
    }

    public void collected() {
        if(!isCollected() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setCollected(true);
            PlayerHandler.addToScore(value);
        }
    }
}
