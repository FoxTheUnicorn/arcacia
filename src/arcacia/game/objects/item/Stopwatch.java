package arcacia.game.objects.item;

import arcacia.game.handler.*;
import arcacia.game.util.Location;
import arcacia.game.objects.enemy.Enemy;

public class Stopwatch extends Item{
    public static final String path = ConstantHandler.pathImages + "stopwatch.png";
    public Stopwatch(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        //setVisible(false)
        GameHandler.setEnemyTimeout(ConstantHandler.itemStopwatchDuration);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
