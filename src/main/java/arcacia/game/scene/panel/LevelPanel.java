package arcacia.game.scene.panel;

import arcacia.game.handler.GameHandler;
import arcacia.game.handler.PlayerHandler;
import arcacia.game.objects.item.*;
import arcacia.game.scene.other.IconLabel;
import arcacia.game.scene.other.MenuButton;

import javax.swing.*;
import java.awt.*;

public class LevelPanel extends JPanel {
    private final LevelCanvas canvas = new LevelCanvas();
    private static final JLabel scoreLabel = new JLabel();
    private static final JLabel lives = new IconLabel("Leben: 3", ExtraLife.path);
    private static final JLabel pill = new IconLabel("0", PowerPill.path);
    private static final JLabel multiplier = new IconLabel("0", Multiplier.path);
    private static final JLabel stopwatch = new IconLabel("0", Stopwatch.path);
    private static final JLabel speed = new IconLabel("0", SpeedBoots.path);
    private boolean testButtons = false;

    public LevelPanel() {
        setFocusable(false);
        setPreferredSize(new Dimension(1000,600));

        setScore(0);
        setLayout(null);

        addIconLabels();
        addTestButtons();

        add(canvas); canvas.setBounds(100, 70, 800, 480);
    }

    public static void reset() {
        setScore(0);
        lives.setText("Leben: 3");
        pill.setText("0");
        multiplier.setText("0");
        stopwatch.setText("0");
        speed.setText("0");
    }

    private void addTestButtons() {
        if(!testButtons) return;
        JButton ToggleKey = new MenuButton("Toggle key", (e) -> PlayerHandler.setHasKey(!PlayerHandler.hasKey()), Component.RIGHT_ALIGNMENT);
        add(ToggleKey); ToggleKey.setBounds(0,0,150, 20);
        JButton Highscore = new MenuButton("Display Highscore", (e) -> GameHandler.setLevel(4), Component.RIGHT_ALIGNMENT);
        add(Highscore); Highscore.setBounds(0, 30, 150, 20);
    }

    private void addIconLabels() {
        add(scoreLabel); scoreLabel.setBounds(200, 20, 100, 30);
        add(lives); lives.setBounds(300, 20, 100, 30);
        add(pill); pill.setBounds(400, 20, 50, 30);
        add(multiplier); multiplier.setBounds(450, 20, 50, 30);
        add(stopwatch); stopwatch.setBounds(500, 20, 50, 30);
        add(speed); speed.setBounds(550, 20, 50, 30);
    }

    public static void setScore(int x) {
         scoreLabel.setText("Score: " + x);
    }

    public void setLives(int x) {
         lives.setText("Leben: " + x);
    }

    public static void setPowerPill(int x) {
        pill.setText(""+x);
    }

    public static void setMultiplier(int x) {
        multiplier.setText(""+x);
    }

    public static void setStopwatch(int x) {
        stopwatch.setText(""+x);
    }

    public static void setSpeed(int x) {
        speed.setText(""+x);
    }

    public void updateFocus() {
        canvas.requestFocus();
    }

    public void drawGrid() {
        canvas.drawGrid();
    }
}
