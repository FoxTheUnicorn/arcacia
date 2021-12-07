package arcacia.game.objects.item;

import arcacia.game.handler.ItemHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class SpeedBoots extends Item{
    public SpeedBoots(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        //setVisible(false);
        setCollected(true);
        PlayerHandler.addToScore(getPoints());
        ItemHandler.activateSpeedBoots();
    }
}
