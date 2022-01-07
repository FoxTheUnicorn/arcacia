package arcacia.debug.objects;

import arcacia.debug.Debugger;
import arcacia.game.handler.InputHandler;
import arcacia.game.util.Location;

public class ObjectDebugger {
    public final PlayerDebug player = new PlayerDebug();

    public static class PlayerDebug extends Debugger {
        private void print(String msg) {
            final String prefix = "Debugger.PlayerObject";
            System.out.println(prefix + msg);
        }

        public void showInitPosition(Location loc) {
            if(active(true)) return;
            print(".initializedAt: " + loc.toString());
        }
        public void showMoveDirection(int dir) {
            if(active(true)) return;
            print(".moved in " + InputHandler.getPressedButton(dir));
        }
        public void showPlayerPosition(Location loc) {
            if(active(true)) return;
            print(".positionIs: " + loc.toString());
        }
        public void showPlayerNewPosition(Location loc) {
            if(active(true)) return;
            print(".newPositionIs: " + loc.toString());
        }
    }

}
