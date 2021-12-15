package arcacia.game.scene.menu;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.WindowEvent;
        import java.awt.event.WindowListener;

public class PauseMenu extends JFrame implements WindowListener, ActionListener {
    private JButton Resume;
    private JButton Restart;
    private JButton Tutorial;
    private JButton Settings;
    private JButton Quit;

    public PauseMenu() {
        super("Pause Menu");
        setLayout(new FlowLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pic = new JLabel(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\IMAGES\\Acacia.png"));
        setContentPane(pic);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Resume = new JButton("Resume");
        Resume.setPreferredSize(new Dimension(18, 18));
        Resume.setAlignmentX(Component.CENTER_ALIGNMENT);
        Resume.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Resume);

        Restart = new JButton("Restart");
        Restart.setPreferredSize(new Dimension(18, 18));
        Restart.setAlignmentX(Component.CENTER_ALIGNMENT);
        Restart.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Restart);

        Tutorial = new JButton("Tutorial");
        Tutorial.setPreferredSize(new Dimension(18, 18));
        Tutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
        Tutorial.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Tutorial);

        Settings = new JButton("Settings");
        Settings.setPreferredSize(new Dimension(18, 18));
        Settings.setAlignmentX(Component.CENTER_ALIGNMENT);
        Settings.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Settings);

        Quit = new JButton("Quit");
        Quit.setPreferredSize(new Dimension(18, 18));
        Quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        Quit.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Quit);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        PauseMenu settingsMenu = new PauseMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Resume) {
            super.dispose();
        }else if(e.getSource() == Restart){
            super.dispose();
        }else if(e.getSource() == Tutorial){
            super.dispose();
        }else if(e.getSource() == Settings){
            super.dispose();
            SettingsMenu settingsMenu = new SettingsMenu();
        }else{
            super.dispose();
            MainMenu mainMenu = new MainMenu();
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

