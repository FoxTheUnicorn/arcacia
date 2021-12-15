package arcacia;

import arcacia.game.handler.*;
import arcacia.game.scene.TutorialFrame;
import arcacia.game.util.Location;

public class Arcacia {
    public static void main(String[] args) {
        //TutorialFrame tutorialFrame = new TutorialFrame();
        CanvasDemo display = new CanvasDemo();
        CollisionHandler collisionHandler;
        /*
        public static GameObject collision(GameObject initiator, GameObject collider);
        private static GameObject playerCollision(PlayerObject player, GameObject collider);
        private static GameObject enemyCollision(Enemy enemy, GameObject collider);
        */
        ConstantHandler constantHandler;
        /*
        public static final int scoreEnemyKill = 10;
        public static final int scoreCoinCollect = 1;
        public static final int scoreItemPickup = 5;
        public static final int scoreKeyPickup = 2;

        public static final int scoreDefaultMultiplier = 1;

        public static final int itemPowerPillDuration = 10;
        public static final int itemMultiplierDuration = 10;
        public static final int itemMultiplierBuff = 2;
        public static final int itemSpeedBootsDuration = 10;
        public static final int itemSpeedBootsBuff = 2;
        public static final int itemStopwatchDuration = 1;

        public static final int gamePlayerStepsPerTurn = 1;
        public static final int gameEnemyStepsPerTurn = 1;
        */
        GameHandler gameHandler;
        /*
        public void loop() throws InterruptedException;
        public static void setEnemyTimeout(int enemyTimeout);
        public static int getEnemyTimeout();
        public static void setPlayerTimeout(int playerTimeout);
        public static int getPlayerTimeout();
        public static void setPlayerTurn(int playerTurn);
        public static int getPlayerTurn();
        public static int getEnemyTurn();
        public static void setEnemyTurn(int enemyTurn);
        public static void setRunning(boolean running);
        public static boolean isRunning();
        */
        ItemHandler itemHandler;
        /*
        public static void tick();
        public static boolean isMultiplierActive();
        public static void activateMultiplier();
        public static boolean isPowerPillActive();
        public static void activatePowerPill();
        public static boolean isSpeedBootsActive();
        public static void activateSpeedBoots();
        */
        LevelHandler levelHandler;
        /*
        public static GameObject getObjectAt(Location loc);
        public static boolean isWall(Location loc);
        public static boolean isWall(int x, int y);
        public static void setLevelGrid(GameObject[][] grid);
        public static GameObject setObjectAt(Location loc, GameObject obj);
        public static void debugInitGrid();
        public static void removeObjectAt(Location loc),
        */
        PlayerHandler playerHandler;
        /*
        public static void incrementLives();
        public static void decrementLives();
        public static void addToScore(int x);
        public static boolean hasKey();
        public static void setHasKey(boolean hasKey);
        public static int getLives();
        public static void setLives(int lives);
        public static int getScore();
        public static void setScore(int score);
        public static PlayerObject getPlayer();
        public static void setPlayer(PlayerObject player);
        public static int getMultiplier();
        public static void setMultiplier(int multiplier);
         */
        SceneHandler sceneHandler;
        /*
        SceneHandler yerine getiriyor bu nedenle InputHandler olusturmaya gerek yok.
        public static void initialise() {
            initialised = true;
            frame.add(mainMenu);
            frame.addKeyListener(new InputHandler());
        }
        */
    }
}
