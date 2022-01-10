package arcacia.game.handler;

import arcacia.game.GameLoop;
import arcacia.game.scene.SceneHandler;
import arcacia.game.scene.panel.LevelPanel;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameHandler extends Thread {

    private static boolean running = false;
    private static int level = 1;
    private static int playerTimeout = 0;
    private static int playerTurn = 1;
    private static int enemyTimeout = 0;
    private static int enemyTurn = 1;
    private static boolean levelComplete = false;
    private static Thread thread = null;

    private static void reset() {
        playerTimeout = 0;
        enemyTimeout = 0;
    }

    public static void resetGame() {
        if(thread == null) return;
        //region resetEverything
        GameHandler.reset();
        ItemHandler.reset();
        LevelHandler.reset();
        PlayerHandler.reset();
        LevelPanel.reset();
        //endregion
        thread.stop();
        LevelHandler.enemies = new ArrayList<>();
    }

    public static void resumeGame() {
        resetGame();
        try {
            FileHandler.loadGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SceneHandler.showLevel();
        GameLoop gameLoop = new GameLoop();
        thread = new Thread(gameLoop);
        thread.start();
    }

    public static void startNewGame() {
        resetGame();
        setLevel(1);
        SceneHandler.showLevel();
        FileHandler.loadLevelX(level);
        GameLoop gameLoop = new GameLoop();
        thread = new Thread(gameLoop);
        thread.start();
    }

    public static void nextLevel()
    {
        FileHandler.loadLevelX(level);
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

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        GameHandler.level = level;
        if(level == 4)
        {
            SceneHandler.showScore();
        }
    }

    public static void setLevelComplete() { levelComplete = true;}
    public static boolean isLevelComplete() {return levelComplete; }

    //endregion

}


