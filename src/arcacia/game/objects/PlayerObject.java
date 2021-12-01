package arcacia.game.objects;

import arcacia.game.util.Location;

import java.awt.*;


public class PlayerObject extends GameObject{

    Location startPlayer;
    protected int speed = 4 ;

    public PlayerObject(Location currentLocation, int newSpeed){
        super(currentLocation);
        startPlayer = new Location(currentLocation.getX(),currentLocation.getY());
        this.speed = newSpeed;

        // update();
    }

    public PlayerObject(int x, int y){

        super(new Location(x,y));
        startPlayer = new Location(x,y);

    }

    //Default COnst, wenn es nötig ist
    /*public PlayerObject(int Spielerspeed){

        this.Spielerspeed = Spielerspeed;


    }*/


    public void update(){
        /*
                Input
         */
    }
    
    

    public void draw(Graphics2D g2) {
        int tileX = 24;
        int tileY = 24;
        g2.setColor(Color.white);
        g2.fillRect(getLocation().getX(), getLocation().getY(),tileX,tileY);
    }



}
