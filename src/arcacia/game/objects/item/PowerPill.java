package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.ItemHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.PlayerObject;
import arcacia.game.util.Location;
import arcacia.game.objects.enemy.Enemy;
import java.util.*;

public class PowerPill extends Item{
    public PowerPill(Location currentLocation) {
        super(currentLocation);
    }

    public void collect(){
        //setVisible(false);
        setCollected(true);
        PlayerHandler.addToScore(ConstantHandler.scoreItemPickup);
        ItemHandler.activatePowerPill();
    }
}

