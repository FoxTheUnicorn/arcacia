package arcacia.game.scene.panel;

    import arcacia.game.handler.GameHandler;
    import arcacia.game.scene.SceneHandler;
    import arcacia.game.scene.other.MenuButton;

    import java.awt.*;

public class MainMenuPanel extends AbstractMenu {
    private static Image background = null;

    public MainMenuPanel() {
        super();

        addSpacer(40);

        add(new MenuButton("New Game", (e) -> GameHandler.startNewGame(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Load Game", (e) -> SceneHandler.showLevel(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Highscores", (e) -> SceneHandler.showHighscore(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Tutorial", (e) -> SceneHandler.showTutorial(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Exit to Desktop", (e) -> SceneHandler.dispose(), Component.RIGHT_ALIGNMENT));
        addSpacer(15);
    }
}


