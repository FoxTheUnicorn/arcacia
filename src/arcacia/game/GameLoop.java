package arcacia.game;

import arcacia.game.handler.*;
import arcacia.game.objects.enemy.Enemy;
import arcacia.game.scene.SceneHandler;

public class GameLoop implements Runnable {

    public static void loop() throws InterruptedException {
        GameHandler.setRunning(true);
        Thread.sleep(100);

        for (int i = 0; i < GameHandler.getPlayerTurn(); i++) {
            if(GameHandler.getPlayerTimeout() > 0) {
                GameHandler.setPlayerTimeout(GameHandler.getPlayerTimeout() - 1);
            } else {
                int temp = -1;
                boolean moved = false;
                while(temp == -1 && !moved) {
                    SceneHandler.updateFocus();
                    temp = InputHandler.getPressedButton();
                    moved = PlayerHandler.getPlayer().playerMove(temp);
                    InputHandler.setBack();
                }
                if(GameHandler.isLevelComplete()) return;
            }
            Thread.sleep(100);
            SceneHandler.drawGrid();
        }

        for (int i = 0; i < GameHandler.getEnemyTurn(); i++) {
            if(GameHandler.getEnemyTimeout() > 0) {
                GameHandler.setEnemyTimeout(GameHandler.getEnemyTimeout() - 1);
            } else {
                for (Enemy e: LevelHandler.enemies) {
                    e.movement(PlayerHandler.getPlayer().getLocation());
                }
            }
        }
        ItemHandler.tick();
        SceneHandler.drawGrid();
    }

    @Override
    public void run() {
        while(!GameHandler.isLevelComplete()) {
            try {
                loop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
