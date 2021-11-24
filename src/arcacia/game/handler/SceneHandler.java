package arcacia.game.handler;

import arcacia.game.scene.MainFrame;
import arcacia.game.scene.menu.MainMenu;

public class SceneHandler {
    private static final MainFrame frame = new MainFrame();
    private static final MainMenu mainMenu = new MainMenu();

    private static boolean initialised = false;


    //region showScene Functions
    public static void showMainMenu() {
        if(initialised) initialise();
        mainMenu.setVisible(true);
    }

    public static void showPauseMenu() {
        if(initialised) initialise();
    }

    public static void showHighscore() {
        if(initialised) initialise();
    }

    public static void showVictory() {
        if(initialised) initialise();
    }

    public static void showLevel() {
        if(initialised) initialise();
    }
    //endregion

    public static boolean isInitialised() {
        return initialised;
    }

    public static void initialise() {
        initialised = true;
        frame.add(mainMenu);
    }

}
