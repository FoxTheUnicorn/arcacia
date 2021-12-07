package arcacia.game.objects.item;

import arcacia.game.util.Location;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.enemy.Enemy;

public class StopwatchItem extends Item{

    public StopwatchItem(Location currentLocation) {
        super(currentLocation);
    }

    public void collecting(Enemy[] enemies) {
        if(!isCollected() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setTimer(10);
            setCollected(true);
            PlayerHandler.addToScore(getPoints());
            for(int i = 0; i < enemies.length; i++)
            {
                enemies[i].setStopwatchOn(true);
            }
        }
        if(getTimer() > 0)
            setTimer(getTimer()-1);
        else if(getTimer() == 0)
        {
            for(int i = 0; i < enemies.length; i++)
            {
                enemies[i].setStopwatchOn(false);
            }
        }
    }
}
