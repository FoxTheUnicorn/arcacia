package arcacia.game.objects.item;

import arcacia.game.util.Location;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.enemy.Enemy;

public class StopwatchItem extends Item{

    public StopwatchItem(Location currentLocation) {
        super(currentLocation);
        setPoints(100);
    }

    public void collecting(Enemy[] enemies) {
        if(!isEingesammelt() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setDauer(10);
            setEingesammelt(true);
            PlayerHandler.setScore(PlayerHandler.getScore()+100);
            for(int i = 0; i < enemies.length; i++)
            {
                enemies[i].setStopWatchOn(true);
            }
        }
        if(getDauer() > 0)
            setDauer(getDauer()-1);
        else if(getDauer() == 0)
        {
            for(int i = 0; i < enemies.length; i++)
            {
                enemies[i].setStopWatchOn(false);
            }
        }
    }
}
