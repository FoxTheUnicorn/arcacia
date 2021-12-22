package arcacia;

import arcacia.game.handler.ConstantHandler;
import arcacia.game.scene.SceneHandler;

import java.util.*;

public class Arcacia {
    public static void main(String[] args) {
        List<String> args2 = Arrays.asList(args);
        if(args.length != 0) {
            if(args2.contains("-debug")) {
                ConstantHandler.DEBUG_MODE = true;
            }
        }
        SceneHandler.showMainMenu();
    }
}
