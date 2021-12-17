package arcacia.game.scene.panel;

    import arcacia.game.scene.SceneHandler;
    import arcacia.game.scene.other.MenuButton;

    import java.awt.*;

public class MainMenuPanel extends AbstractMenu {
    private static Image background = null;

    public MainMenuPanel() {
        super();

        addSpacer(35);

        add(new MenuButton("New Game", (e) -> SceneHandler.showLevel(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Load Game", (e) -> SceneHandler.showLevel(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Highscores", (e) -> SceneHandler.showHighscore(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Tutorial", (e) -> SceneHandler.showTutorial(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Test Pause Menu", (e) -> SceneHandler.showPauseMenu(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Test Game Over Menu", (e) -> SceneHandler.showGameOver(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Exit to Desktop", (e) -> SceneHandler.dispose(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);
    }
}


