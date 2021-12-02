package arcacia.game.objects.enemy;

import arcacia.game.handler.LevelHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends GameObject {

    Location start;
    
    Location spieler;
    Location last_seen;
    
    int Countdown;
    // maximale anzahl wie oft der zu letzt gesehene punkt des spielers verfolgt wird
    private static final int maxVerfolgen = 10;// static sagt aus das es nur einmal gemacht wird, wenn die maximale zahl der verfolgung für verschiedene erhöht werden soll muss static entfernt werden
    private static final int sichtWeite = 10;

    /**
     * Konstruktor mit Location Objekt
     * @param currentLocation übergibt location Object welches die start position des Gegners markiert
     */
	public Enemy(Location currentLocation){
		super(currentLocation);
        start = new Location(currentLocation.getX(),currentLocation.getY());
        Countdown = -1;
	}

    /**
     * Konstruktor mit Location Objekt
     * @param x Wert der den start X-wert des gegners markiert
     * @param y Wert der den start Y-wert des gegners markiert
     */
	public Enemy(int x , int y){
		super(new Location(x,y));
        start = new Location(x,y);
        Countdown = -1;
	}

    /**
     * Lässt den Gegner einen Schritt in X-Richtung laufen,
     * sowohl in die positive als auch negative Richtung
     * @param x 1 lässt in Positiv gehen, -1 in Negativ
     * @return true wenn erfolgreich, false wenn eine wand im weg ist
     */
    public boolean bewegeX(int x){ //nimmt 1 oder -1 an, und bewegt in die richtung
        //fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
        if (x == 1 || x == -1){
            if (LevelHandler.isWall(new Location(this.currentLocation.getX() + x,this.currentLocation.getY()))){
                return false;
            }else {
                this.currentLocation.setX(currentLocation.getX() + x);
                return true;
            }
        }
        return false;
    }

    /**
     *  Lässt den Gegner einen Schritt in X-Richtung laufen,
     *      * sowohl in die positive als auch negative Richtung
     * @param y 1 lässt in Positiv gehen, -1 in Negativ
     * @return true wenn erfolgreich, false wenn eine wand im weg ist
     */
    public boolean bewegeY(int y){ //nimmt 1 oder -1 an, und bewegt in diese richtung
        // fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
        //alternative schreibweise, falls eingabe parameter eingeschränkt (nur 1 und -1) muss

        if (y == 1 || y == -1){
            if (LevelHandler.isWall(new Location(this.currentLocation.getX(),this.currentLocation.getY() + y))){
                return false;
            }else {
                this.currentLocation.setY(currentLocation.getY()+y);
                return true;
            }
        }
          return false;
    }

    /**
     * überprüft ob spieler in einer der Richtungen (oben, unten, links, rechts ) ist, wenn eine wand da zwischen ist wird der spieler nicht gesehen
     * @return true wenn spieler gesehen wurde, false wenn spieler nicht gesehen wurde
     */
    public boolean siehtSpieler(){
	    //playerpos-enemypos == abstand <= 10 blöcke ist soll er ihn verfolgen.
	    //unter der bedingung das zwischen den beiden positionen keine Wand ist
        for (int i = 1;i <= sichtWeite; i++)
        {
            //x positiv richtung
            Location cu = new Location(this.currentLocation.getX()+i,this.currentLocation.getY());
            if (LevelHandler.isWall(cu)) {
               break;
            }
            if (Location.isSame(cu,this.spieler)) {
            return true;
            }
        }
        for (int i = -1;i >= -sichtWeite; i--)
        {
            //x negativ richtung
            Location cu = new Location(this.currentLocation.getX()+i,this.currentLocation.getY());
            if (LevelHandler.isWall(cu)) {
                break;
            }
            if (Location.isSame(cu,this.spieler)) {
                return true;
            }
        }
        for (int i = 1;i <= sichtWeite; i++)
        {
            //y positiv richtung
            Location cu = new Location(this.currentLocation.getX(),this.currentLocation.getY()+i);
            if (LevelHandler.isWall(cu)) {
                break;
            }
            if (Location.isSame(cu,this.spieler)) {
                return true;
            }
        }
        for (int i = -1;i >= -sichtWeite; i--)
        {
            //y negativ richtung
            Location cu = new Location(this.currentLocation.getX(),this.currentLocation.getY()+i);
            if (LevelHandler.isWall(cu)) {
                break;
            }
            if (Location.isSame(cu,this.spieler)) {
                return true;
            }
        }


        return false;
    }

    /**
     * lässt den gegner in eine der vier richtungen (rechts, oben, links, unten) gehen
     * entscheidet random in welche
     */
    void geheRandom(){
        //aus allen validen Richtungen bestimmt der genera eine und geht einen schritt in diese Richtung
        int richtung = ThreadLocalRandom.current().nextInt(1,5);//generiert eine zahl aus {1,2,3,4}

        switch (richtung) {
            case 1:
                if (bewegeY(1)){ break;}
            case 2:
                if (bewegeX(1)){break;}
            case 3:
                if (bewegeY(-1)){break;}
            case 4:
                if (bewegeX(-1)){break;}
            //default:
                //wenn hier hin gelangt ist ein fehler passiert denn dann kann der gegner sich nicht bewegen. eventuell sollte hier ein interrupt geworfen werden
        }
    }

    /**
     * generelle bewegung von Gegner,
     * wenn spieler gesehen wurde geht in richtung der zu letzt gesehenen position
     * sonst gehe einen random schritt
     * @param s aktuelle Location des Spielers
     */
    public void geheSchritt(Location s){ //public? ist die funktion die aufgerufen werden soll um den gegner zu bewegen
        //gegner geht einen schritt
        //bestimmt ob er geziehlt oder randomgeht
        //führt diesen schritt aus
        spieler = s;
        if (siehtSpieler()){
            Countdown = maxVerfolgen;
            last_seen = spieler;
        }
        if (Countdown > 0){
            bewege_in_richtung(last_seen);
            Countdown--;
        }else {
            geheRandom();
        }
    }

    /**
     * setzt die position auf die initalen werte zurück,
     * setzt Countdown auf -1, da der spieler nun nicht mehr gesehen wird
     */
    void setzeAufStart(){
        //setzt die Position des Gegners auf die StartPosition zurück
        this.currentLocation = start;
        Countdown = -1;
    }


    public boolean spieler_collision() {
        return (Location.isSame(this.currentLocation, this.spieler)) ;
    }


    /**
     * bewegt sich in die richtung der Location die der funktion übergebenen wird
     * @param location übergibt ein Location Object, gegner geht in diese richtung wenn möglich
     */
    void bewege_in_richtung(Location location) {
        //bewegt sich in Richtung der zuletzt gesehen Position des Spieler
        //wenn der gegner auf der location ist und den spieler nicht mehr sieht soll er nicht hängen bleiben
        if (!Location.isSame(this.currentLocation, location)) {

            int hit_wall = 0;
            int hit_wall_limit =25;

            move : while (hit_wall <= hit_wall_limit){
                int randomizer = ThreadLocalRandom.current().nextInt(1, 5);//generiert eine zahl aus {1,2,3,4}
                switch (randomizer) {
                    case 1:
                        if (this.currentLocation.getX() < location.getX()) {
                            if (bewegeX(1)) {bewegeX(1);break move;}
                            else hit_wall++;
                        }
                    case 2:
                        if (this.currentLocation.getX() > location.getX()) {
                            if (bewegeX(-1)) {bewegeX(-1);break move;}
                            else hit_wall++;
                        }
                    case 3:
                        if (this.currentLocation.getY() < location.getY()) {
                            if (bewegeY(1)) {bewegeY(1);break move;}
                            else hit_wall++;
                        }
                    case 4:
                        if (this.currentLocation.getY() > location.getY()) {
                            if (bewegeY(-1)) {bewegeY(-1);break move;}
                            else hit_wall++;
                        }
                }
                if (hit_wall == hit_wall_limit) {
                    geheRandom();
                }
            }

        }
        else if (Location.isSame(this.currentLocation, location) ) {
            geheRandom();
        }
    }

}



      /*  if (!Location.isSame(this.currentLocation, location))
        {
            if (this.currentLocation.getX() <= location.getX() && this.currentLocation.getY() <= location.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 3);//generiert eine zahl aus {1,2}
                switch (richtung) {
                    case 1:
                        if (bewegeY(1)) {
                            bewegeY(1);
                            break;
                        }
                    case 2:
                        if (bewegeX(1)) {
                            bewegeX(1);
                            break;
                        }
                }
            }
            if (this.currentLocation.getX() >= location.getX() && this.currentLocation.getY() <= location.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 3);//generiert eine zahl aus {1,2}

                switch (richtung) {
                    case 1:
                        if (bewegeY(1)) {
                            bewegeY(1);
                            break;
                        }
                    case 2:
                        if (bewegeX(-1)) {
                            bewegeX(-1);
                            break;
                        }
                }
            }
            if (this.currentLocation.getX() <= location.getX() && this.currentLocation.getY() >= location.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 3);//generiert eine zahl aus {1,2}

                switch (richtung) {
                    case 1:
                        if (bewegeY(-1)) {
                            bewegeY(-1);
                            break;
                        }
                    case 2:
                        if (bewegeX(1)) {
                            bewegeX(1);
                            break;
                        }
                }
            }
            if (this.currentLocation.getX() >= location.getX() && this.currentLocation.getY() >= location.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 3);//generiert eine zahl aus {1,2}

                switch (richtung) {
                    case 1:
                        if (bewegeY(-1)) {
                            bewegeY(-1);
                            break;
                        }
                    case 2:
                        if (bewegeX(-1)) {
                            bewegeX(-1);
                            break;
                        }
                }
            }
        }

       */

