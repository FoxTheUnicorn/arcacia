package arcacia.game.objects.item;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.util.Location;

public class CoinItem extends Item{
    public static final String path = ConstantHandler.pathImages + "coin.png";
    public CoinItem(Location currentLocation) {
        super(currentLocation);
    }

    public void collect() {
        PlayerHandler.addToScore(ConstantHandler.scoreCoinCollect);
        LevelHandler.removeObjectAt(currentLocation);
    }
}
