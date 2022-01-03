package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.objects.item.CoinItem;
import arcacia.game.objects.item.Item;
import arcacia.game.objects.tile.DoorObject;
import arcacia.game.objects.tile.WallTile;

public class CollisionHandler {

    public static void collision(GameObject initiator, GameObject collider) {
        if (collider == null) return;

        if(initiator instanceof PlayerObject) {
            playerCollision((PlayerObject) initiator, collider);
        }
        else if (initiator instanceof Enemy) {
            enemyCollision((Enemy) initiator, collider);
        }
    }

    private static void playerCollision(PlayerObject player, GameObject collider) {
        if (collider instanceof CoinItem coin){
            coin.collect();
        }
        else if (collider instanceof Item item) {
            item.collect();
        }
        else if (collider instanceof Enemy enemy) {
            if(ItemHandler.isPowerPillActive()) {
                enemy.reset();
                PlayerHandler.addToScore(ConstantHandler.scoreEnemyKill);
            } else {
                PlayerHandler.decrementLives();
                //Restart Game
                player.resetPlayer();
                //System.out.println("resete Player");
                //reset alle gegner
                for (Enemy enemys : LevelHandler.enemies) {enemys.reset();}
                //System.out.println("resete gegner");
            }
        }
        else if (collider instanceof DoorObject) {
            if(PlayerHandler.hasKey()) {
                //GameHandler.setLevelComplete();
                GameHandler.setLevel_number(GameHandler.getLevel_number() + 1);
                LevelHandler.enemies.clear();
                GameHandler.nextLevel();
            }
        }
        else if (collider instanceof WallTile) {
            System.out.println("Kritischer Fehler");
        }
    }

    private static void enemyCollision(Enemy enemy, GameObject collider) {
        if (collider instanceof PlayerObject) {
            if(ItemHandler.isPowerPillActive()) {
                enemy.reset();
                PlayerHandler.addToScore(ConstantHandler.scoreEnemyKill);
            } else {
                PlayerHandler.decrementLives();
                //Restart Game
                ((PlayerObject) collider).resetPlayer();
                //System.out.println("resete Player");
                //resete alle gegner
                for (Enemy enemys : LevelHandler.enemies) {enemys.reset();}
                //System.out.println("resete gegner");
            }
        }
        else if (collider instanceof WallTile) {
            System.out.println("Kritischer Fehler");
        }
    }
}
