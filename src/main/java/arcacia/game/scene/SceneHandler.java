package arcacia.game.scene;

import arcacia.game.handler.GameHandler;
import arcacia.game.handler.InputHandler;
import arcacia.game.scene.panel.*;

import java.util.Locale;

public class SceneHandler {
    public static String lastMenu = "null";
    public static final MainFrame frame = new MainFrame();
    public static final MainMenuPanel mainMenuPanel = new MainMenuPanel();
    public static final TutorialPanel tutorialPanel = new TutorialPanel();
    public static final PauseMenuPanel pauseMenuPanel = new PauseMenuPanel();
    public static final GameOverPanel gameOverPanel = new GameOverPanel();
    public static HighscorePanel highScorePanel = new HighscorePanel();
    public static final AddScorePanel addScorePanel = new AddScorePanel();
    public static final LevelPanel levelPanel = new LevelPanel();

    public static void goBack() {
        switch(lastMenu.toLowerCase(Locale.ROOT)) {
            case "main" -> showMainMenu();
            case "pause" -> showPauseMenu();
        }
    }

    public static void drawGrid() {
        levelPanel.drawGrid();
    }

    public static void updateFocus() {
        levelPanel.updateFocus();
    }

    public static void dispose() {
        frame.dispose();
    }

    //region showScene Functions
    public static void showMainMenu() {
        GameHandler.resetGame();
        frame.setContentPane(mainMenuPanel);
        lastMenu = "main";
        frame.update();
    }

    public static void showPauseMenu() {
        frame.setContentPane(pauseMenuPanel);
        lastMenu = "pause";
        frame.update();
    }

    public static void showHighscore() {
        highScorePanel = new HighscorePanel();
        frame.setContentPane(highScorePanel);
        frame.update();
    }

    public static void showScore() {
        frame.setContentPane(addScorePanel);
        frame.update();
    }

    public static void showGameOver() {
        frame.setContentPane(gameOverPanel);
        frame.update();
    }

    public static void showLevel() {
        frame.setContentPane(levelPanel);
        frame.update();
    }

    public static void showTutorial() {
        frame.setContentPane(tutorialPanel);
        frame.update();
    }
    //endregion



}
