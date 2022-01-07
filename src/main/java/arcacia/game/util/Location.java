package arcacia.game.util;

public class Location {
    //Tile Location and not Pixel Location
    private int x = 0;
    private int y = 0;

    public Location() {

    }

    public Location(Location loc) {
        x = loc.getX();
        y = loc.getY();
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean isSame(Location locA, Location locB) {
        if(locB.x == locA.x) {
            return locB.y == locA.y;
        }
        return false;
    }

    public String toString() {
        return "x: " + x + " y: "+ y;
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

    public Location add(int x , int y) {
        return new Location(this.x + x, this.y + y);
    }

    public Location subtract(int x, int y) {
        return new Location(this.x - x, this.y - y);
    }

    public double length() {
        double lenX = (double) x;
        double lenY = (double) y;
        return Math.sqrt((lenX * lenX) + (lenY * lenY));
    }
}
