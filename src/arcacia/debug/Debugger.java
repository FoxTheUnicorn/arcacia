package arcacia.debug;

import arcacia.game.handler.ConstantHandler;

import java.util.logging.Level;

public abstract class Debugger {

    protected static boolean isDebug() {
        return ConstantHandler.DEBUG_MODE;
    }

    protected static boolean active(boolean enabled) {
        return !(ConstantHandler.DEBUG_MODE || enabled);
    }
}
