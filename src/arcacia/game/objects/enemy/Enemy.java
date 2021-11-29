package arcacia.game.objects.enemy;

import arcacia.game.handler.LevelHandler;
import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends GameObject {

	private int  speed;
    Location start;
    
    Location spieler;
    
    int Countdown;
    // maximale anzahl wie oft der zu letzt gesehene punkt des spielers verfolgt wird
    private static final int maxVerfolgen = 10;// static sagt aus das es nur einmal gemacht wird, wenn die maximale zahl der verfolgung für verschiedene erhöht werden soll muss static entfernt werden
    

    /*
    * @l position an der der Gegner startet und an die der Gegner immer zurückgesetzt wird
     */
	public Enemy(Location currentLocation){
		super(currentLocation);
        start = new Location(currentLocation.getX(),currentLocation.getY());
        Countdown = -1;
	}


	public Enemy(int x , int y){
		super(new Location(x,y));
        start = new Location(x,y);
        Countdown = -1;
	}

    public boolean bewegeX(int x){ //nimmt 1 oder -1 an, und bewegt in die richtung
        //fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
       int currentX = currentLocation.getX();
       this.currentLocation.setX(currentX + x);
       return LevelHandler.isWall(this.currentLocation); //(Location.isSame(this.currentLocation, WallLocation)
    }
      public boolean bewegeY(int y){ //nimmt 1 oder -1 an, und bewegt in diese richtung
        //fragt ob in die gewünschte richtung genug platz zum bewegen ist, wenn ja führe diesen schritt aus, wenn nein geben False zurück
          //alternative schreibweise, falls eingabe parameter eingeschränkt (nur 1 und -1) muss
        int currentY = currentLocation.getY();
        if (y == 1){
            this.currentLocation.setY(currentY =+ 1);
            if (!LevelHandler.isWall(this.currentLocation)){return true;}
            if (LevelHandler.isWall(this.currentLocation)) {
                this.currentLocation.setY(currentY = -1);
                return false;
            }
        }
        else if (y ==-1){
            this.currentLocation.setY(currentY =- 1);
            if (!LevelHandler.isWall(this.currentLocation)){return true;}
            if (LevelHandler.isWall(this.currentLocation)) {
                this.currentLocation.setY(currentY = +1);
                return false;
            }
        }
        return !LevelHandler.isWall(this.currentLocation); //weiss noch nicht genau was bedingung für true ist
    }

    public boolean siehtSpieler(){
	    //playerpos-enemypos == abstand <= 10 blöcke ist soll er ihn verfolgen.
	    //unter der bedingung das zwischen den beiden positionen keine Wand ist
	    if((spieler.getlocationX()-enemy.getlocationX())<=10||spieler.getlocationY()-enemy.getlocationY())<=10){
		    if(!isWall()){
			target = bewege_auf_position();    
			return true;
		    }
	    }
        return false;
    }

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

    public void geheSchritt(){ //public? ist die funktion die aufgerufen werden soll um den gegner zu bewegen
        //gegner geht einen schritt
        //bestimmt ob er geziehlt oder randomgeht
        //führt diesen schritt aus
        if (siehtSpieler()){
            Countdown = maxVerfolgen;
        }
        if (Countdown > 0){
            bewege_auf_position(spieler);
        }else {
            geheRandom();
        }
    }

    void setzeAufStart(){
        //setzt die Position des Gegners auf die StartPosition zurück

        currentLocation.setX(start.getX());
        currentLocation.setY(start.getY());
        Countdown = -1;
    }


    public boolean spieler_collision(spieler_location.getLocation());
    {
        if (isSame(enemy.getLocation(), spieler.getLocation())) {
            return 1;
        }

        return 0;
    }

    void bewege_auf_position(Location spieler_location){
    //bewegt sich in Richtung der zuletzt gesehen Position des Spieler
    //wenn der gegner auf der location ist und den spieler nicht mehr sieht soll er nicht hängen bleiben
        if (!Location.isSame(this.currentLocation, spieler));
        {
            if (this.currentLocation.getX() <= spieler.getX() && this.currentLocation.getY() <= spieler.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 2);//generiert eine zahl aus {1,2}
                switch (richtung) {
                    case 1:
                        if (bewegeY(1)) {
                            //falls es ne wand gibt, dann konnte hier vllt else geheRandom hinzugefügt
                            break;
                        }
                    case 2:
                        if (bewegeX(1)) {
                            break;
                        }
                }
            }
            if (this.currentLocation.getX() >= spieler.getX() && this.currentLocation.getY() <= spieler.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 2);//generiert eine zahl aus {1,2}

                switch (richtung) {
                    case 1:
                        if (bewegeY(1)) {
                            break;
                        }
                    case 2:
                        if (bewegeX(-1)) {
                            break;
                        }
                }
            }
            if (this.currentLocation.getX() <= spieler.getX() && this.currentLocation.getY() >= spieler.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 2);//generiert eine zahl aus {1,2}

                switch (richtung) {
                    case 1:
                        if (bewegeY(-1)) {
                            break;
                        }
                    case 2:
                        if (bewegeX(1)) {
                            break;
                        }
                }
            }
            if (this.currentLocation.getX() >= spieler.getX() && this.currentLocation.getY() >= spieler.getY()) {
                int richtung = ThreadLocalRandom.current().nextInt(1, 2);//generiert eine zahl aus {1,2}

                switch (richtung) {
                    case 1:
                        if (bewegeY(-1)) {
                            break;
                        }
                    case 2:
                        if (bewegeX(-1)) {
                            break;
                        }
                }
            }
        }
	
    //Gegner auf dem Bildschirm anzugeben
	//public void draw();
}
