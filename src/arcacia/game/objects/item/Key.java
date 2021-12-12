package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class Key extends Item{

    public Key(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        //setVisible(false);
        PlayerHandler.addToScore(ConstantHandler.scoreKeyPickup);
        PlayerHandler.setHasKey(true);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
