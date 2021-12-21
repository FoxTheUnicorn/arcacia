package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.tile.EmptyTile;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.util.Location;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LevelHandler {
    public final static int level_width = 24; //X //KAFANIZA GÖRE MI YAZDINIZ
    public final static int level_height = 15; //Y //KAFANIZA GÖRE MI YAZDINIZ
    public static int level_number = 1;
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

    public static int getLevel_number() {
        return level_number;
    }

    public static void setLevel_number(int level_number) {
        LevelHandler.level_number = level_number;
    }
}
