package arcacia.game.util;

import java.io.*;
import java.util.Arrays;

public class Score implements Serializable {
    private String name;
    private int points;
    // Score[] highscores= new Score[10];

    public Score(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
    @Override
    public String toString() {
        return name + " has " +  points + " points";
    }

    public void sort(){

    }

}
