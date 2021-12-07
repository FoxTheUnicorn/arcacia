package arcacia.game.handler;

import arcacia.game.objects.GameObject;
import arcacia.game.objects.PlayerObject;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.util.Location;

public class GameHandler {

    private static boolean isRunning;
    private static int playerTimeout = 0;
    private static int playerTurn = 1;
    private static int enemyTimeout = 0;
    private static int enemyTurn = 1;

    public void loop() throws InterruptedException {
        Thread.sleep(1000);

        for (int i = 0; i < playerTurn; i++) {
            if(playerTimeout > 0) {
                playerTimeout--;
            } else {
                //Player Moves
            }
        }

        Thread.sleep(100);
        for (int i = 0; i < enemyTurn; i++) {
            if(enemyTimeout > 0) {
                enemyTimeout--;
            } else {
                //Enemy Moves
            }
        }
        ItemHandler.tick();
    }

    //region Getter/Setter
    public static void setEnemyTimeout(int enemyTimeout){
        GameHandler.enemyTimeout = enemyTimeout;
    }
    public static int getEnemyTimeout(){
        return enemyTimeout;
    }

    public static void setPlayerTimeout(int playerTimeout){
        GameHandler.playerTimeout = playerTimeout;
    }
    public static int getPlayerTimeout(){
        return playerTimeout;
    }

    public static void setPlayerTurn(int playerTurn){
        GameHandler.playerTurn = playerTurn;
    }
    public static int getPlayerTurn(){
        return playerTurn;
    }

    public static int getEnemyTurn() {
        return enemyTurn;
    }
    public static void setEnemyTurn(int enemyTurn) {
        GameHandler.enemyTurn = enemyTurn;
    }
    //endregion
}


