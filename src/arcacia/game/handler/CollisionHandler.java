package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.objects.item.Item;
import arcacia.game.objects.tile.DoorObject;

public class CollisionHandler {

    public static GameObject collision(GameObject initiator, GameObject collider) {
        if (collider == null) return null;

        if(initiator instanceof PlayerObject) {
            return playerCollision((PlayerObject) initiator, collider);
        }
        else if (initiator instanceof Enemy) {
            return enemyCollision((Enemy) initiator, collider);
        }else if(initiator instanceof DoorObject){
            return doorCollision((DoorObject) initiator,collider);
        }

        return null;
    }

    private static GameObject playerCollision(PlayerObject player, GameObject collider) {
        //if (collider instanceof Coin){}
        /*else*/ if (collider instanceof Enemy enemy) {
            //if(ItemHandler.hasPowerPill()) { enemy.kill(); PlayerHandler.addScore(ConstantHandler.scoreEnemyKill); return null;
            PlayerHandler.decrementLives();
            //reset Level etc.
        }

        return collider;
    }

    private static GameObject enemyCollision(Enemy enemy, GameObject collider) {
        if (collider instanceof PlayerObject) {
            PlayerHandler.decrementLives();
        } return collider;
    }

    private static GameObject doorCollision(DoorObject door, GameObject collider){
        //Wenn Kollision mit Player und Player hat Key eingesammelt. sonst passiert nichts
        if(collider instanceof PlayerObject /* Prüfen ob Key eingesammelt ist */ ){
            /*Load next Level */
        }
        return collider;
    }
}
