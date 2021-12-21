package arcacia;

import arcacia.game.handler.FileHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.item.CoinItem;
import arcacia.game.objects.item.ExtraLife;
import arcacia.game.objects.tile.DoorObject;
import arcacia.game.scene.SceneHandler;

public class Arcacia {
    public static void main(String[] args) {

      //  LevelHandler.debugInitGrid(ExtraLife.class);
        SceneHandler.initialise();
        SceneHandler.showMainMenu();
        FileHandler.loadLevelX(1);
    }
}
