package arcacia.game.scene.menu;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.WindowEvent;
        import java.awt.event.WindowListener;

public class MainMenu extends JFrame implements WindowListener, ActionListener {
    private JButton Continue;
    private JButton LoadGame;
    private JButton NewGame;
    private JButton Editor;
    private JButton Scoreboard;
    private JButton Settings;
    private JButton Extras;
    private JButton QuitToDesktop;

    public MainMenu() {
        super("Main Menu");
        setLayout(new FlowLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pic = new JLabel(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\IMAGES\\Acacia.png"));
        setContentPane(pic);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(35));

        Continue = new JButton("Continue");
        Continue.setPreferredSize(new Dimension(18, 18));
        Continue.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Continue.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Continue);

        LoadGame = new JButton("Load Game");
        LoadGame.setPreferredSize(new Dimension(18, 18));
        LoadGame.setAlignmentX(Component.RIGHT_ALIGNMENT);
        LoadGame.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(LoadGame);

        NewGame = new JButton("New Game");
        NewGame.setPreferredSize(new Dimension(18, 18));
        NewGame.setAlignmentX(Component.RIGHT_ALIGNMENT);
        NewGame.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(NewGame);

        Editor = new JButton("Editor");
        Editor.setPreferredSize(new Dimension(18, 18));
        Editor.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Editor.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Editor);

        Scoreboard = new JButton("Scoreboard");
        Scoreboard.setPreferredSize(new Dimension(18, 18));
        Scoreboard.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Scoreboard.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Scoreboard);

        Settings = new JButton("Settings");
        Settings.setPreferredSize(new Dimension(18, 18));
        Settings.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Settings.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Settings);

        Extras = new JButton("Extras");
        Extras.setPreferredSize(new Dimension(18, 18));
        Extras.setAlignmentX(Component.RIGHT_ALIGNMENT);
        Extras.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Extras);

        QuitToDesktop = new JButton("Quit to Desktop");
        QuitToDesktop.setPreferredSize(new Dimension(18, 18));

        QuitToDesktop.setAlignmentX(Component.RIGHT_ALIGNMENT);
        QuitToDesktop.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(QuitToDesktop);

        //add(Box.createVerticalStrut(35));
        //add(Box.createVerticalStrut(30));
        //add(Box.createHorizontalStrut(20));

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Continue) {
            super.dispose();
        }else if(e.getSource() == LoadGame){
            super.dispose();
        }else if(e.getSource() == NewGame){
            super.dispose();
        }else if(e.getSource() == Editor){
            super.dispose();
        }else if(e.getSource() == Scoreboard){
            super.dispose();
            HighscoreMenu highscoreMenu = new HighscoreMenu();
        }else if(e.getSource() == Settings){
            super.dispose();
            SettingsMenu settingsMenu = new SettingsMenu();
        }else if(e.getSource() == Extras){
            super.dispose();
        }else{
            super.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}


