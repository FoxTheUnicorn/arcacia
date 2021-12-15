package arcacia.game.scene.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class HighscoreMenu extends JFrame implements WindowListener, ActionListener {
    //TODO switch to JPanel
    private JButton Back;
    public HighscoreMenu() {
        super("Highscore Menu");
        setLayout(new FlowLayout());
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pic = new JLabel(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\IMAGES\\Acacia.png"));
        setContentPane(pic);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("HI-SCORE",SwingConstants.CENTER));

        String[][] rec = {
                { "1", "Elliot", "100"},
                { "2", "Lucas", "99"},
                { "3", "Mert", "98"},
                { "4", "Alina", "97"},
                { "5", "Byungjun", "96"},
        };
        String[] header = { "Rank", "Player", "Score"};
        JTable table = new JTable(rec, header);
        table.setRowHeight(20);
        add(new JScrollPane(table));

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
        HighscoreMenu highscoreMenu = new HighscoreMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Back) {
            super.dispose();
            MainMenuPanel mainMenu = new MainMenuPanel();
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









