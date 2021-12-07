package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class Coin extends Item{
    public Coin(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        //setVisible(false)
        setCollected(true);
        PlayerHandler.addToScore(ConstantHandler.scoreCoinCollect);
    }
}
