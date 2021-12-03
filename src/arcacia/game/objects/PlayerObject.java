package arcacia.game.objects;

import arcacia.game.util.Location;

import java.awt.*;


public class PlayerObject extends GameObject{

    protected static int speed = 4;
    private final Location startPlayer;


//    public void setLocation(int x,int y){
//        startPlayer.setY(y);
//        startPlayer.setX(x);
//    }
//
//    public Location getLocation(){
//        return startPlayer;
//    }




    public PlayerObject(Location currentLocation){
        super(currentLocation);
        startPlayer = new Location(currentLocation.getX(),currentLocation.getY());




        // update();
    }

    public void setPlayerspeed(int speed){ PlayerObject.speed = speed;}
    public int getPlayerspeed(){return speed;}


    //Standard Konstruktor mit Leeren eingabe werten
    public PlayerObject(){
        super(new Location(0,0));
        startPlayer = new Location(0,0);
    }

    public PlayerObject(int x, int y){

        super(new Location(x,y));
        startPlayer = new Location(x,y);

    }

    public void run(){

    }

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
