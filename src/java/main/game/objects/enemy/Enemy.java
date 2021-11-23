package java.main.game.objects.enemy;

import java.main.game.objects.GameObject;
import java.main.game.util.Location;

public class Enemy extends GameObject {

    Location start;

    /*
    * @l position an der der Gegner startet und an die der Gegner immer zurückgesetzt wird
     */
    public Enemy(Location l){
      start = location = l;
    }

    public boolean bewegeX(int x){ //nimmt 1 oder -1 an, und bewegt in die richtung
        //fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
        return true;
    }
    public boolean bewegeY(int y){ //nimmt 1 oder -1 an, und bewegt in diese richtung
        //fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
        return true;
    }

    boolean siehtSpieler(){
        //checkt ob der spieler sichtbar ist, wenn ja gibt true zurück
        //spieler sollte nur in einer bestimmten entfernung sichtbar werden
        //merkt sich der gegner wo der spieler zuletzt gesehen wurde?
        return false;
    }
    void geheRandom(){
        //aus allen validen richtungen bestimt der gegner eine und geht einen schriutt in diese richtung
    }

    void geheSchritt(){ //public? ist die funktion die aufgerufen werden soll um den gegner zu bewegen
        //gegner geht einen schritt
        //bestimmt ob er geziehlt oder randomgeht
        //führt diesen schritt aus
    }

    void setzeAufStart(){
        //setzt die Position des Gegners auf die StartPosition zurück
    }
}
