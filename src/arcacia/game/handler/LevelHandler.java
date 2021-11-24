package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.util.Location;

public class LevelHandler {
    private final static int levelwidth = 24; //X
    private final static int levelheight = 15; //Y
    private static GameObject[][] grid = new GameObject[levelwidth][levelheight];

    public static GameObject getObjectAt(Location loc) {
        return grid[loc.getX()][loc.getY()];
    }

    public static boolean isWall(Location loc) {
        return (getObjectAt(loc) instanceof WallTile);
    }

    public static void debugInitGrid() {
        for(int x = 0; x < levelwidth; x++) {
            for(int y = 0; y < levelheight; y++) {
                grid[x][y] = new WallTile(x, y);
            }
        }
    }
}
