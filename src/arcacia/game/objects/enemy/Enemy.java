package arcacia.game.objects.enemy;

import arcacia.game.handler.CollisionHandler;
import arcacia.game.handler.ConstantHandler;
import arcacia.game.handler.LevelHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.objects.tile.DoorObject;
import arcacia.game.objects.tile.EmptyTile;
import arcacia.game.util.Location;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends GameObject {

    public static final String path = ConstantHandler.pathImages + "scorpion.png";

    Location start;
    
    Location player;
    Location last_seen;
    GameObject objectOnPosition;

    int countdown;
    // maximale anzahl wie oft der zu letzt gesehene punkt des spielers verfolgt wird
    private static final int maxFollwo = 10;// static sagt aus das es nur einmal gemacht wird, wenn die maximale zahl der verfolgung für verschiedene erhöht werden soll muss static entfernt werden
    private static final int maxVisibility = 10;

    /**
     * Konstruktor mit Location Objekt
     * @param currentLocation übergibt location Object welches die start position des Gegners markiert
     */
	public Enemy(Location currentLocation){
		super(currentLocation);
        start = new Location(currentLocation.getX(),currentLocation.getY());
        countdown = -1;
        objectOnPosition = new EmptyTile(start);
	}

    @Override
    public BufferedImage getImage() {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Konstruktor mit Location Objekt und Objekt welchem an der selben position Liegt
     * @param currentLocation bergibt location Object welches die start position des Gegners markiert
     * @param object Übergebe das Object auf dem Der Gegner stehen soll und welches damit am selben ort liegt
     */
    public Enemy(Location currentLocation,GameObject object){
        super(currentLocation);
        start = new Location(currentLocation.getX(),currentLocation.getY());
        countdown = -1;
        objectOnPosition = object;
    }

    /**
     * Konstruktor mit Location Objekt
     * @param x Wert der den start X-wert des gegners markiert
     * @param y Wert der den start Y-wert des gegners markiert
     */
	public Enemy(int x , int y){
		super(new Location(x,y));
        start = new Location(x,y);
        countdown = -1;
        objectOnPosition = new EmptyTile(start);
	}

    /**
     *
     * @return GameObject welches in objectOnPosition gespeichert ist
     */
    public GameObject getObjectOnPosition(){
        return objectOnPosition;
    }

    /**
     * Lässt den Gegner einen Schritt in X-Richtung laufen,
     * sowohl in die positive als auch negative Richtung
     * @param x 1 lässt in Positiv gehen, -1 in Negativ
     * @return true wenn erfolgreich, false wenn eine wand im weg ist
     */
    public boolean moveX(int x){ //nimmt 1 oder -1 an, und bewegt in die richtung
        //fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
        if (x == 1 || x == -1){
            if (LevelHandler.isWall(new Location(this.currentLocation.getX() + x,this.currentLocation.getY())) || (LevelHandler.getObjectAt(new Location(this.currentLocation.getX() + x,this.currentLocation.getY())) instanceof DoorObject)){
                return false;
            }else {
                LevelHandler.setObjectAt(currentLocation, objectOnPosition);
                this.currentLocation.setX(currentLocation.getX() + x);
                objectOnPosition = LevelHandler.setObjectAt(currentLocation,this);
                CollisionHandler.collision(this, objectOnPosition);
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
    public boolean moveY(int y){ //nimmt 1 oder -1 an, und bewegt in diese richtung
        // fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
        //alternative schreibweise, falls eingabe parameter eingeschränkt (nur 1 und -1) muss

        if (y == 1 || y == -1){
            if (LevelHandler.isWall(new Location(this.currentLocation.getX(),this.currentLocation.getY() + y)) || (LevelHandler.getObjectAt(new Location(this.currentLocation.getX(),this.currentLocation.getY() + y)) instanceof DoorObject)){
                return false;
            }else {
                LevelHandler.setObjectAt(currentLocation,objectOnPosition);
                this.currentLocation.setY(currentLocation.getY()+y);
                objectOnPosition = LevelHandler.setObjectAt(currentLocation,this);
                CollisionHandler.collision(this, objectOnPosition);
                return true;
            }
        }
          return false;
    }

    /**
     * überprüft ob spieler in einer der Richtungen (oben, unten, links, rechts ) ist, wenn eine wand da zwischen ist wird der spieler nicht gesehen
     * @return true wenn spieler gesehen wurde, false wenn spieler nicht gesehen wurde
     */
    public boolean seePlayer(){
	    //playerpos-enemypos == abstand <= 10 blöcke ist soll er ihn verfolgen.
	    //unter der bedingung das zwischen den beiden positionen keine Wand ist

        if(this.player.getX() - this.currentLocation.getX() == 0 || this.player.getY() - this.currentLocation.getY() == 0){// prüft ob beide auf einer achse sind
            if (Math.abs(this.player.getX() - this.currentLocation.getX()) <= maxVisibility || Math.abs(this.player.getY() - this.currentLocation.getY()) <= maxVisibility){ // prüft ob beide weniger als maxVisibility vo einander entfernt sind
                int difX = this.player.getX() - this.currentLocation.getX();
                if (difX > 0){
                    //spieler ist richtung x Pos vom gegner

                    for (int i = 1; i <= maxVisibility; i++)
                    {
                        //x positiv richtung
                        Location cu = new Location(this.currentLocation.getX()+i,this.currentLocation.getY());
                        if (LevelHandler.isWall(cu)) {
                            return false;
                        }
                        if (Location.isSame(cu,this.player)) {
                            return true;
                        }
                    }

                }else if (difX < 0){
                    //spieler ist richtung X Neg vom gegner

                    for (int i = -1; i >= -maxVisibility; i--)
                    {
                        //x negativ richtung
                        Location cu = new Location(this.currentLocation.getX()+i,this.currentLocation.getY());
                        if (LevelHandler.isWall(cu)) {
                            return false;
                        }
                        if (Location.isSame(cu,this.player)) {
                            return true;
                        }
                    }

                }else {
                    //spieler ist auf der selben X höhe wie gegner -> prüfe Y richtung
                    int difY = this.player.getY() - this.currentLocation.getY();
                    if (difY > 0){
                        //spieler ist richtung Y Pos vom gegner

                        for (int i = 1; i <= maxVisibility; i++)
                        {
                            //y positiv richtung
                            Location cu = new Location(this.currentLocation.getX(),this.currentLocation.getY()+i);
                            if (LevelHandler.isWall(cu)) {
                                return false;
                            }
                            if (Location.isSame(cu,this.player)) {
                                return true;
                            }
                        }

                    }else if (difY < 0){
                        //spieler ist richtung Y neg vom gegner

                        for (int i = -1; i >= -maxVisibility; i--)
                        {
                            //y negativ richtung
                            Location cu = new Location(this.currentLocation.getX(),this.currentLocation.getY()+i);
                            if (LevelHandler.isWall(cu)) {
                                return false;
                            }
                            if (Location.isSame(cu,this.player)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * lässt den gegner in eine der vier richtungen (rechts, oben, links, unten) gehen
     * entscheidet random in welche
     */
    void moveRandom(){
        //aus allen validen Richtungen bestimmt der genera eine und geht einen schritt in diese Richtung
        int richtung = ThreadLocalRandom.current().nextInt(1,5);//generiert eine zahl aus {1,2,3,4}

        switch (richtung) {
            case 1:
                if (moveY(1)){ break;}
            case 2:
                if (moveX(1)){break;}
            case 3:
                if (moveY(-1)){break;}
            case 4:
                if (moveX(-1)){break;}
            default:
                //wenn in der ersten runde kein erfolgreicher gegangen werden konnte weil z.b. richtung  = 3 war und sowol 3 und 4 nicht ausgeführt werden konnte
                // dann ist hier die möglichkeit gegeben das 1 oder 2 erfolgreich werden kann
                //case 4: ist deshalb nicht ein zwietes mal angegeben da er im ersten fall immer ausgelöst werden würde
                switch (richtung){
                    case 1:
                        if (moveY(1)){ break;}
                    case 2:
                        if (moveX(1)){break;}
                    case 3:
                        if (moveY(-1)){break;}
                }
        }
    }

    /**
     * generelle bewegung von Gegner,
     * wenn spieler gesehen wurde geht in richtung der zu letzt gesehenen position
     * sonst gehe einen random schritt
     * @param s aktuelle Location des Spielers
     */
    public void movement(Location s){ //public? ist die funktion die aufgerufen werden soll um den gegner zu bewegen
        player = s;
        if (seePlayer()) {
            countdown = maxFollwo;
            last_seen = player;
        }
        if (countdown > 0) {
            move_to_Position(last_seen);
            countdown--;
        } else {
            moveRandom();
        }
    }

    /**
     * setzt die position auf die initalen werte zurück,
     * setzt Countdown auf -1, da der spieler nun nicht mehr gesehen wird
     */
    public void reset(){
        //setzt die Position des Gegners auf die StartPosition zurück
        LevelHandler.setObjectAt(currentLocation,objectOnPosition);
        this.currentLocation = start;
        countdown = -1;
        objectOnPosition = LevelHandler.setObjectAt(currentLocation,this);
    }


    public boolean spieler_collision() {return (Location.isSame(this.currentLocation, this.player)) ;}


    /**
     * bewegt sich in die richtung der Location die der funktion übergebenen wird
     * Location ist immer in eine der 4 geraden richtungen ( nie schräg)
     * @param location übergibt ein Location Object, gegner geht in diese richtung wenn möglich
     */
    void move_to_Position(Location location) {
        //bewegt sich in Richtung der zuletzt gesehen Position des Spieler
        //wenn der gegner auf der location ist und den spieler nicht mehr sieht soll er nicht hängen bleiben

        if (location.getX() - this.currentLocation.getX() == 0 || location.getY() - this.currentLocation.getY() == 0) {//prüft das die beiden locations auf einer achse liegen
            int difX = location.getX() - this.currentLocation.getX(); // prüft auf welcher achse
            if (difX > 0) {
                //spieler ist richtung x Pos vom gegner
                if (!moveX(1)) {
                    moveRandom();
                } // wenn der gewünschte schritt nicht gegangen werden kann führt moveRandom() aus damitt ein schritt gegangen wird

            } else if (difX < 0) {
                //spieler ist richtung X Neg vom gegner
                if (!moveX(-1)) {
                    moveRandom();
                }

            } else {
                //spieler ist auf der selben X höhe wie gegner -> prüfe Y richtung
                int difY = location.getY() - this.currentLocation.getY();
                if (difY > 0) {
                    //spieler ist richtung Y Pos vom gegner
                    if (!moveY(1)) {
                        moveRandom();
                    }

                } else if (difY < 0) {
                    //spieler ist richtung Y neg vom gegner
                    if (!moveY(-1)) {
                        moveRandom();
                    }

                } else {// rand fall wo die übergebene position die ist auf der der gegner bereits steht
                    // soll der gegner sich dann überhaupt bewegen oder sollte er dann still stehen?
                    moveRandom();
                }
            }

        } else { // in dem fall das die übergebenen Location nicht in eine der 4 geraden richtungen liegt, bewegt sich daher random
            //soll der gegner sich dann nicht gerade auf die psoition bewegen? haben keinen fall wo dies benötigt wir
            moveRandom();
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

