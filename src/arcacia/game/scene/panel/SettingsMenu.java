package arcacia.game.scene.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SettingsMenu extends JFrame implements WindowListener, ActionListener {
    //TODO Unused
    private JButton Back;
    private JButton MusicVolume;
    private JButton SEVolume;

    public SettingsMenu() {
        super("Settings Menu");
        setLayout(new FlowLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pic = new JLabel(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\IMAGES\\Acacia.png"));
        setContentPane(pic);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        SEVolume = new JButton("SE Volume");
        SEVolume.setPreferredSize(new Dimension(18, 18));
        SEVolume.setAlignmentX(Component.CENTER_ALIGNMENT);
        SEVolume.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(SEVolume);

        MusicVolume = new JButton("Music Volume");
        MusicVolume.setPreferredSize(new Dimension(18, 18));
        MusicVolume.setAlignmentX(Component.CENTER_ALIGNMENT);
        MusicVolume.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(MusicVolume);

        Back = new JButton("Back");
        Back.setPreferredSize(new Dimension(18, 18));
        Back.setAlignmentX(Component.CENTER_ALIGNMENT);
        Back.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Back);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SettingsMenu settingsMenu = new SettingsMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SEVolume) {
            super.dispose();
        }else if(e.getSource() == MusicVolume){
            super.dispose();
        }else{
            super.dispose();
            MainMenuPanel mainMenu = new MainMenuPanel();
            mainMenu.setVisible(true);
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

