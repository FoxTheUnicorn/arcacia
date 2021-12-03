package arcacia.game.objects;

import arcacia.game.handler.InputHandler;
import arcacia.game.objects.item.Key;
import arcacia.game.scene.MainFrame;
import arcacia.game.util.Location;
import java.awt.event.KeyListener;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PlayerObject extends GameObject{

     private Location startPlayer;
    protected int speed = 4 ;

//    public void setLocation(int x,int y){
//        startPlayer.setY(y);
//        startPlayer.setX(x);
//    }
//
//    public Location getLocation(){
//        return startPlayer;
//    }




    public PlayerObject(Location currentLocation, int newSpeed){
        super(currentLocation);
        startPlayer = new Location(currentLocation.getX(),currentLocation.getY());


        // update();
    }


    //Standart Konstruktor mit Leeren eingabe werten
    public PlayerObject(){
        super(new Location(0,0));
        startPlayer = new Location(0,0);
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
