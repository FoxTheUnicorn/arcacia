package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.ItemHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class SpeedBoots extends Item{
    public static final String path = ConstantHandler.pathImages + "speedboots.png";
    public SpeedBoots(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        PlayerHandler.addToScore(ConstantHandler.scoreItemPickup);
        ItemHandler.activateSpeedBoots();
        LevelHandler.removeObjectAt(currentLocation);
    }
}
