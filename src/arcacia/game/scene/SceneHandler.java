package arcacia.game.scene;

import arcacia.game.handler.InputHandler;
import arcacia.game.scene.panel.*;

import java.util.Locale;

public class SceneHandler {
    public static String lastMenu = "null";
    private static final MainFrame frame = new MainFrame();
    private static final MainMenuPanel mainMenuPanel = new MainMenuPanel();
    private static final TutorialPanel tutorialPanel = new TutorialPanel();
    private static final PauseMenuPanel pauseMenuPanel = new PauseMenuPanel();
    private static final GameOverPanel gameOverPanel = new GameOverPanel();
    private static final HighscorePanel highScorePanel = new HighscorePanel();



    //region showScene Functions

    public static void goBack() {
        switch(lastMenu.toLowerCase(Locale.ROOT)) {
            case "main" -> showMainMenu();
            case "pause" -> showPauseMenu();
        }
    }

    public static void showMainMenu() {
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
        frame.setContentPane(highScorePanel);
        frame.update();
    }

    public static void showGameOver() {
        frame.setContentPane(gameOverPanel);
        frame.update();
    }

    public static void showLevel() {

    }

    public static void showTutorial() {
        frame.setContentPane(tutorialPanel);
        frame.update();
    }

    public static void dispose() {
        frame.dispose();
    }
    //endregion

    public static void initialise() {
        frame.addKeyListener(new InputHandler());
    }

}
