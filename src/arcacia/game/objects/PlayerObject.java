package arcacia.game.objects;

import arcacia.game.handler.KeyHandler;
import arcacia.game.objects.tile.WallTile;
import arcacia.game.util.Location;
import arcacia.game.handler.LevelHandler;
import java.awt.*;


public class PlayerObject extends GameObject{

    Location startPlayer;
    int speed;

    public PlayerObject(Location currentLocation, int speed) {
        super(currentLocation);
        this.speed = speed;



       // update();
    }

    public PlayerObject(int x, int y){

        super(new Location(x,y));

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
