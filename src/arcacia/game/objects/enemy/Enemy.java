package arcacia.game.objects.enemy;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

public class Enemy extends GameObject {

    Location start;
    
    Location spieler;
    
    int Countdown;
    

    /*
    * @l position an der der Gegner startet und an die der Gegner immer zurückgesetzt wird
     */
    public Enemy(Location l){
        super(l);
        start = l;
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
        //merkt sich der gegner wo der spieler zuletzt gesehen wurde
        //resetttet Countdown
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
    
    public boolean spieler_collision(const Position& spieler_location);{
	//if location.issame(){
	//    return 1
	 //   }
	//else 
	  //  return 0;
	}
    
    void bewege_auf_position(Location spieler_location){
    //bewegt sich in Richtung der zuletzt gesehen Position des Spieler
    //wenn der gegner auf der location ist und den spieler nicht mehr sieht soll er nicht hängen bleiben
    }
	
    //Gegner auf dem Bildschirm anzugeben
	//public void draw();
}
