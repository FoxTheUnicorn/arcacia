package arcacia.game.objects.enemy;

import arcacia.game.objects.GameObject;
import arcacia.game.util.Location;

public class Enemy extends GameObject {
	private int = x;
	private int = y;
	private int = speed;
     Location start;
    
    Location spieler;
    
    int Countdown;
    

    /*
    * @l position an der der Gegner startet und an die der Gegner immer zurückgesetzt wird
     */
	public Enemy(Location currentLocation){
		super(currentLocation);
	}


	public Enemy(int x , int y){
		super(new Location(x,y));
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
        }
        else if (y ==-1){
            this.currentLocation.setY(currentY =- 1);
        }
        return LevelHandler.isWall(this.currentLocation);
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
    
    public boolean spieler_collision(spieler_location.getLocation());{
	if (isSame(enemy.getLocation(),spieler.getLocation()))
	{
		return 1
	}

	return 0;
    
    void bewege_auf_position(Location spieler_location){
    //bewegt sich in Richtung der zuletzt gesehen Position des Spieler
    //wenn der gegner auf der location ist und den spieler nicht mehr sieht soll er nicht hängen bleiben
    }
	
    //Gegner auf dem Bildschirm anzugeben
	//public void draw();
}
