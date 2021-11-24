package arcacia.game.util;

public class Location {
    //Tile Location and not Pixel Location
    private int x = 0;
    private int y = 0;

    public Location() {

    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isSame(Location locA, Location locB) {
        if(locB.x == locA.x) {
            if(locB.y == locA.y) {
                return true;
            }
        }
        return false;
    }

    //region Getter and Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    //endregion
}
