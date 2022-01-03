package arcacia.debug;

import arcacia.debug.objects.PlayerDebug;
import arcacia.game.handler.ConstantHandler;

public class DebugHandler {

    public final static PlayerDebug player = new PlayerDebug();

    private static boolean debugOn() {
        return ConstantHandler.DEBUG_MODE;
    }
}
