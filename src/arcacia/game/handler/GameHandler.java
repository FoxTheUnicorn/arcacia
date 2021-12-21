package arcacia.game.handler;

import arcacia.game.objects.enemy.Enemy;
import arcacia.game.scene.SceneHandler;

public class GameHandler {

    private static boolean running = false;
    private static int playerTimeout = 0;
    private static int playerTurn = 1;
    private static int enemyTimeout = 0;
    private static int enemyTurn = 1;

    public void loop() throws InterruptedException {
        this.running = true;
        SceneHandler.drawGrid();
        Thread.sleep(1000);

        for (int i = 0; i < playerTurn; i++) {
            if(playerTimeout > 0) {
                playerTimeout--;
            } else {
                int temp = -1;
                while(temp == -1) {
                    temp = InputHandler.getPressedButton();
                    PlayerHandler.getPlayer().playerMove(temp);
                }
                SceneHandler.drawGrid();
            }
        }

        for (int i = 0; i < enemyTurn; i++) {
            if(enemyTimeout > 0) {
                enemyTimeout--;
            } else {
                Thread.sleep(100);
                for (Enemy e: LevelHandler.enemies) {
                    e.movement(PlayerHandler.getPlayer().getLocation());
                    SceneHandler.drawGrid();
                }
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

    public static void setRunning(boolean running) {
        GameHandler.running = running;
    }
    public static boolean isRunning() { return running; }
    //endregion
}


