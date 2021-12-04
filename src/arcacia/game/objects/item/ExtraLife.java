package arcacia.game.objects.item;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class ExtraLife extends Item{
    public ExtraLife(Location currentLocation) {
        super(currentLocation);
    }

    public void collecting() {
        if(!isCollected() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setCollected(true);
            PlayerHandler.addToScore(getPoints());
            PlayerHandler.setLives(PlayerHandler.getLives()+1);
        }
    }
}
