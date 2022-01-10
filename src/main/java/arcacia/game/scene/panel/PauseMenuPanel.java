package arcacia.game.scene.panel;

        import arcacia.game.handler.FileHandler;
        import arcacia.game.handler.GameHandler;
        import arcacia.game.scene.SceneHandler;
        import arcacia.game.scene.other.MenuButton;

        import java.awt.*;
        import java.io.FileNotFoundException;

public class PauseMenuPanel extends AbstractMenu {

    public PauseMenuPanel() {
        super();

        addSpacer(35);

        add(new MenuButton("Resume", (e) -> SceneHandler.showLevel(), Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Restart", (e) -> {GameHandler.startNewGame(); SceneHandler.showLevel();}, Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Save", (e) -> {
            try {
                FileHandler.saveGame();
                ((MenuButton) e.getSource()).setText("Saved");
            } catch (FileNotFoundException ex) {
                ((MenuButton) e.getSource()).setText("Error");
                ex.printStackTrace();
            }
        }, Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Tutorial", (e) -> SceneHandler.showTutorial(), Component.CENTER_ALIGNMENT));
        addSpacer(15);

        add(new MenuButton("Quit", (e) -> SceneHandler.showMainMenu(), Component.CENTER_ALIGNMENT));
        addSpacer(15);
    }
}

