package arcacia.game.objects.item;

import arcacia.game.handler.*;
import arcacia.game.util.Location;
import arcacia.game.objects.enemy.Enemy;

public class StopwatchItem extends Item{

    public StopwatchItem(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        //setVisible(false)
        GameHandler.setEnemyTimeout(ConstantHandler.itemStopwatchDuration);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
