package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class ExtraLife extends Item{
    public static final String path = ConstantHandler.pathImages + "HPup.png";
    public ExtraLife(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        PlayerHandler.addToScore(ConstantHandler.scoreItemPickup);
        PlayerHandler.incrementLives();
        LevelHandler.removeObjectAt(currentLocation);
    }
}
