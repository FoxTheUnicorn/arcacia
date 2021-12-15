package arcacia.game.scene.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VictoryScreen extends JFrame implements WindowListener, ActionListener {
    private JButton BackButton;
    private JButton NextLevel;
    private JButton Restart;

    public VictoryScreen() {
        super("Victory Screen");
        setLayout(new FlowLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pic = new JLabel(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\IMAGES\\Acacia.png"));
        setContentPane(pic);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Restart = new JButton("Restart");
        Restart.setPreferredSize(new Dimension(18, 18));
        Restart.setAlignmentX(Component.CENTER_ALIGNMENT);
        Restart.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(Restart);

        NextLevel = new JButton("Next Level");
        NextLevel.setPreferredSize(new Dimension(18, 18));
        NextLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
        NextLevel.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(NextLevel);

        BackButton = new JButton("Back Button");
        BackButton.setPreferredSize(new Dimension(18, 18));
        BackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        BackButton.addActionListener(this);
        add(Box.createVerticalStrut(15));
        add(BackButton);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        VictoryScreen victoryScreen = new VictoryScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == Restart) {
             super.dispose();
         }else if(e.getSource() == BackButton){
             super.dispose();
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        }else{
             super.dispose();
             //THIS IS SOME NEXT LEVEL SHIT
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

