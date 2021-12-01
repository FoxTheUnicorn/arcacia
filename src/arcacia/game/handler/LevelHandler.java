package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.util.Location;

public class LevelHandler {
    private final static int level_width = 24; //X
    private final static int level_height = 15; //Y
    private static GameObject[][] grid = new GameObject[level_width][level_height];

    public static GameObject getObjectAt(Location loc) {
        return grid[loc.getX()][loc.getY()];
    }

    public static boolean isWall(Location loc) {
        return (getObjectAt(loc) instanceof WallTile);
    }
    public static boolean isWall(int x, int y) {
        return (getObjectAt(new Location(x,y)) instanceof WallTile);
    }

    public static void setLevelGrid(GameObject[][] grid) {
        LevelHandler.grid = grid;
    }

    public static GameObject setObjectAt(Location loc, GameObject obj) {
        GameObject out = grid[loc.getX()][loc.getY()];
        grid[loc.getX()][loc.getY()] = obj;
        return out;
    }

    public static void debugInitGrid() {
        for(int x = 0; x < level_width; x++) {
            for(int y = 0; y < level_height; y++) {
                grid[x][y] = new WallTile(x, y);
            }
        }
    }
}
