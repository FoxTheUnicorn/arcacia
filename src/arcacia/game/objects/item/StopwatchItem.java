package arcacia.game.objects.item;

import arcacia.game.util.Location;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.enemy.Enemy;

public class StopwatchItem extends Item{

    public StopwatchItem(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        //setVisible(false)
        setCollected(true);

    }
}
