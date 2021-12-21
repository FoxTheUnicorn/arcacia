package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.objects.tile.DoorObject;
import arcacia.game.objects.tile.EmptyTile;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.util.Location;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class LevelHandler {
    public final static int level_width = 25; //X
    public final static int level_height = 15; //Y
    public static List<Enemy> enemies = new ArrayList<>();

    private static GameObject[][] grid = new GameObject[level_width][level_height];

    public static GameObject getObjectAt(Location loc) {
        return grid[loc.getX()][loc.getY()];
    }

    //region Build that Wall

    public static boolean isWall(Location loc) {
        return isWall(loc, null);
    }

    public static boolean isWall(Location loc, GameObject obj) {
        if(PlayerHandler.hasKey()) {
            if(obj instanceof PlayerObject) {
                if(getObjectAt(loc) instanceof DoorObject) {
                    return false;
                }
            }
        }
        return (getObjectAt(loc).isSolid());
    }

    public static boolean isWall(int x, int y) {
        return isWall(x,y,null);
    }

    public static boolean isWall(int x, int y, GameObject obj) {
        return isWall(new Location(x, y), obj);
    }

    //endregion

    public static void setLevelGrid(GameObject[][] grid) {
        LevelHandler.grid = grid;
    }

    public static GameObject moveObjectTo(Location loc, GameObject obj) {
        removeObjectAt(obj.getLocation());

        GameObject out = grid[loc.getX()][loc.getY()];
        grid[loc.getX()][loc.getY()] = obj;

        obj.setLocation(loc);
        return out;
    }

    public static GameObject setObjectAt(Location loc, GameObject obj) {
        GameObject out = grid[loc.getX()][loc.getY()];
        grid[loc.getX()][loc.getY()] = obj;
        obj.setLocation(loc);
        return out;
    }

    public static GameObject moveObjectTo(Location newLocation, GameObject mover, GameObject overlap) {
        setObjectAt(overlap.getLocation(), overlap);

        GameObject out = grid[newLocation.getX()][newLocation.getY()];
        grid[newLocation.getX()][newLocation.getY()] = mover;
        mover.setLocation(newLocation);

        return out;
    }

    public static void debugInitGrid(Class<? extends GameObject> clazz) {
        Constructor<? extends GameObject> constr = null;
        try {
             constr = clazz.getConstructor(Location.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if(constr == null) return;

        for(int x = 0; x < level_width; x++) {
            for(int y = 0; y < level_height; y++) {
                try {
                    grid[x][y] = constr.newInstance(new Location(x,y));
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void removeObjectAt(Location loc) {
        grid[loc.getX()][loc.getY()] = new EmptyTile(loc);
    }
}
