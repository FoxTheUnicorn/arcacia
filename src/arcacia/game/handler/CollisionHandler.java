package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.objects.item.Coin;
import arcacia.game.objects.item.Item;
import arcacia.game.objects.tile.DoorObject;
import arcacia.game.objects.tile.WallTile;

public class CollisionHandler {

    public static GameObject collision(GameObject initiator, GameObject collider) {
        if (collider == null) return null;

        if(initiator instanceof PlayerObject) {
            return playerCollision((PlayerObject) initiator, collider);
        }
        else if (initiator instanceof Enemy) {
            return enemyCollision((Enemy) initiator, collider);
        }

        return null;
    }

    private static GameObject playerCollision(PlayerObject player, GameObject collider) {
        if (collider instanceof Coin coin){
            coin.collect();
            return null;
        }
        else if (collider instanceof Item item) {
            item.collect();
            return null;
        }
        else if (collider instanceof Enemy enemy) {
            if(ItemHandler.isPowerPillActive()) {
                enemy.reset();
                PlayerHandler.addToScore(ConstantHandler.scoreEnemyKill);
            } else {
                PlayerHandler.decrementLives();
                //Restart Game
            }
            return null;
        }
        else if (collider instanceof DoorObject) {
            if(PlayerHandler.hasKey()) {
                //Lade nächstes Level
            }
            return null;
        }
        else if (collider instanceof WallTile) {
            System.out.println("Kritischer Fehler");
        }

        return null;
    }

    private static GameObject enemyCollision(Enemy enemy, GameObject collider) {
        if (collider instanceof PlayerObject) {
            if(ItemHandler.isPowerPillActive()) {
                enemy.reset();
                PlayerHandler.addToScore(ConstantHandler.scoreEnemyKill);
            } else {
                PlayerHandler.decrementLives();
                //Restart Game
            }
            return null;

        }
        else if (collider instanceof WallTile) {
            System.out.println("Kritischer Fehler");
        }
        return collider;
    }
}
