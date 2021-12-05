package arcacia.game.objects.item;

import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.PlayerObject;
import arcacia.game.util.Location;
import arcacia.game.objects.enemy.Enemy;
import java.util.*;

public class KillEnemies extends Item{
    public KillEnemies(Location currentLocation) {
        super(currentLocation);
    }
    public void collected(PlayerObject playerObject, Vector <Enemy> enemies){
        Vector<Enemy> enemiesCopy = new Vector <Enemy>();
        if(!isCollected() && this.currentLocation == PlayerHandler.getPlayer().getLocation()) {
            setTimer(10);
            setCollected(true);
        }
        if(getTimer() > 0 && isCollected()){
            setTimer(getTimer() - 1);
            for(int i = 0; i < enemies.size(); i++) {
                if (Location.isSame(enemies.get(i).getLocation(), PlayerHandler.getPlayer().getLocation())) {
                    //KOPIE DES ZU LÖSCHENDES GEGNER-OBJEKT
                    Enemy enemyCopy = new Enemy(enemies.get(i).getLocation());
                    enemiesCopy.add(i, enemyCopy);
                    //LÖSCHEN DES OBJEKTS
                    enemies.set(i,null);
                    //LÖSCHEN VOM VEKTOR
                    enemies.remove(i);
                    PlayerHandler.addToScore(getPoints());
                }
            }
        }else if(getTimer() == 0 && isCollected()){
            for(Enemy enemy : enemiesCopy){
                //ANHÄNGEN AM VEKTOR
                enemies.add(enemy);
                //SETZT DIE POSITION AUF DIE INITIALEN WERTE ZURÜCK
                enemy.reset();
            }
        }
    }
}

