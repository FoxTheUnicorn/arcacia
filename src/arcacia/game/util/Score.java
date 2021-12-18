package arcacia.game.util;

import java.io.*;

/**
 * Public Class Score,
 * die die erreichte Punkte von Spieler darstellt.
 * implements Serializable, da die Attributen werden Serializiert und Deserializiert
 * mit den Klassenattributen,
 * String : name ist der Name des Spielers
 * int    : points ist die erreichte Punkte
 */
public class Score implements Serializable {
    private String name;
    private int points;

    /**
     *Constructor von Score
     * @param name ist der Name des Spielers
     * @param points ist die erreichte Punkte
     */
    public Score(String name, int points) {
        this.name = name;
        this.points = points;
    }

    /**
     * getter for Class Attribute name:String
     * @return name des Spielers
     */
    public String getName() {
        return name;
    }
    /**
     * getter for Class Attribute points:int
     * @return erreichte Punkte
     */
    public int getPoints() {
        return points;
    }

    /**
     *Methode toString, die die Methode toString von Klasse Objekt überschrieben
     * @return neu formatiert String darstellung von Objekte
     */
    @Override
    public String toString() {
        return name + " has " +  points + " points";
    }

    //public void sort(){}

}
