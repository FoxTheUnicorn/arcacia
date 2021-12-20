package arcacia.game.objects.item;

import arcacia.game.handler.*;
import arcacia.game.util.Location;

public class Stopwatch extends Item{
    public static final String path = ConstantHandler.pathImages + "stopwatch.png";
    public Stopwatch(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        PlayerHandler.addToScore(ConstantHandler.scoreItemPickup);
        GameHandler.setEnemyTimeout(ConstantHandler.itemStopwatchDuration);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
