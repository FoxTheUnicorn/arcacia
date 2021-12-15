package arcacia.game.scene.panel;

        import arcacia.game.handler.SceneHandler;
        import arcacia.game.scene.other.MenuButton;

        import java.awt.*;

public class PauseMenuPanel extends AbstractMenu {

    public PauseMenuPanel() {
        super();

        addSpacer(35);

        add(new MenuButton("Resume", (e) -> {}, Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Restart", (e) -> {}, Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Tutorial", (e) -> SceneHandler.showTutorial(), Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Settings", (e) -> {}, Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Quit", (e) -> SceneHandler.showMainMenu(), Component.CENTER_ALIGNMENT));
        addSpacer(15);
    }
}

