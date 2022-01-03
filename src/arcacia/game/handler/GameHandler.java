package arcacia.game.handler;

import arcacia.game.GameLoop;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.scene.SceneHandler;

public class GameHandler extends Thread {

    //TODO Fully integrate

    private static boolean running = false;
    private static int level_number = 1;
    private static int playerTimeout = 0;
    private static int playerTurn = 1;
    private static int enemyTimeout = 0;
    private static int enemyTurn = 1;
    private static boolean levelComplete = false;
    private static Thread thread = null;

    public static void startNewGame() {
        setLevel_number(1);
        SceneHandler.showLevel();
        FileHandler.loadLevelX(level_number);
        GameLoop gameLoop = new GameLoop();
        thread = new Thread(gameLoop);
        thread.start();
    }

    public static void nextLevel()
    {
        FileHandler.loadLevelX(level_number);
        PlayerHandler.setHasKey(false);
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

    public static int getLevel_number() {
        return level_number;
    }

    public static void setLevel_number(int level_number) {
        GameHandler.level_number = level_number;
        if(level_number == 4)
        {
            SceneHandler.showHighscore();
        }
    }

    public static void setLevelComplete() { levelComplete = true;}
    public static boolean isLevelComplete() {return levelComplete; }

    //endregion

}


