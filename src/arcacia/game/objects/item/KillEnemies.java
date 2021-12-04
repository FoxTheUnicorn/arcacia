package arcacia.game.objects.item;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class KillEnemies extends Item{

    public KillEnemies(Location currentLocation) {
        super(currentLocation);
    }

    public void collected()
    {
        if(!isCollected() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setCollected(true);
            PlayerHandler.addToScore(getPoints());

            //Code für die neue GegnerTöten Klasse
        }
    }
}
