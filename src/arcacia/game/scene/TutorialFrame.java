package arcacia.game.scene;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TutorialFrame extends javax.swing.JFrame {
    public TutorialFrame()
    {
        JFrame tutorialFrame = new JFrame("Tutorial");
        JPanel tutorialPanel = new JPanel();
        tutorialPanel.setLayout(null);

        JLabel keys = new JLabel("Tastenbelegung:");
        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("W/Pfeil oben:     Spieler bewegt sich nach oben");
        l1.addElement("A/Pfeil links:    Spieler bewegt sich nach links");
        l1.addElement("S/Pfeil unten:    Spieler bewegt sich nach unten");
        l1.addElement("D/Pfeil rechts:   Spieler bewegt sich nach rechts");
        JList<String> list = new JList<>(l1);

        JLabel Items = new JLabel("Items:");
        JLabel Coin = new JLabel("Beim aufsammeln erhöht dies die Punkte des Spielers um 1.");
        Coin.setIcon(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\ITEMS\\Coin.png"));
        JLabel Key = new JLabel("Wenn der Spieler diesen Schlüssel aufsammelt, kann er zum Ausgang gehen um ins nächste Level zu kommen.");
        Key.setIcon(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\ITEMS\\Key.png"));
        JLabel SpeedItem = new JLabel("Der Spieler kann zwei Züge machen bevor die Gegner wieder ziehen können.");
        SpeedItem.setIcon(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\ITEMS\\SpeedItem.png"));
        JLabel Stopwatch = new JLabel("Die Gegner bleiben für 10 Runden stehen.");
        Stopwatch.setIcon(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\ITEMS\\Stopwatch.png"));
        JLabel KillEnemy = new JLabel("Wenn der Spieler dieses Item aufgesammelt hat, kann er für 10 Runden lang die Gegner berühren und sie somit zurück zu ihrem Startpunkt befördern.");
        KillEnemy.setIcon(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\ITEMS\\KillEnemy.png"));
        JLabel Multiplier = new JLabel("Wenn der Spieler nach dem Aufsammeln dieses Items Punkte bekommt, werden diese verdoppelt.");
        Multiplier.setIcon(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\ITEMS\\Multiplier.png"));
        JLabel HPUp = new JLabel("Der Spieler bekommt ein extra Leben.");
        HPUp.setIcon(new ImageIcon("C:\\Users\\mertt\\OneDrive\\Masaüstü\\arcacia\\ITEMS\\HPUp.png"));

        JLabel game = new JLabel("Spielbeschreibung");
        JTextArea gameDescription = new JTextArea("Allgemein geht es in dem Spiel darum in einem Labyrinth mit Gegnern zu überleben und alle drei Level zu schaffen.\n" +
                "Der Spieler muss einen Schlüssel einsammeln und damit zum Ausgang gehen um von ins nächste Level zu kommen.\n" +
                "Die Level werden dabei immer schwieriger, aber der Spieler kann Items einsammeln, die ihm helfen.\n" +
                "Wenn der Spieler alle Leben verliert oder in dem dritten Level durch den Ausgang geht ist das Spiel vorbei.\n" +
                "Wenn der Spieler alle Level beendet hat kann er seine Punktanzahl in eine Highscore Liste eintragen.");

        JButton back = new JButton("Zurück");

        ArrayList<JLabel> itemList = new ArrayList<>();
        itemList.add(Coin);
        itemList.add(Key);
        itemList.add(SpeedItem);
        itemList.add(Stopwatch);
        itemList.add(KillEnemy);
        itemList.add(Multiplier);
        itemList.add(HPUp);

        keys.setBounds(400,0,200,30);
        list.setBounds(300,30,300,80);
        Items.setBounds(400,120,200,30);
        int i = 150;
        for(JLabel jlabel : itemList)
        {
            jlabel.setBounds(80,i, 1000, 30);
            i = i+32;
        }
        game.setBounds(400,380,200,30);
        gameDescription.setBounds(100,410,750,90);
        back.setBounds(400,520,80,20);


        tutorialPanel.add(keys);
        tutorialPanel.add(list);
        tutorialPanel.add(Items);
        tutorialPanel.add(Coin);
        tutorialPanel.add(Key);
        tutorialPanel.add(SpeedItem);
        tutorialPanel.add(Stopwatch);
        tutorialPanel.add(KillEnemy);
        tutorialPanel.add(Multiplier);
        tutorialPanel.add(HPUp);
        tutorialPanel.add(game);
        tutorialPanel.add(gameDescription);
        tutorialPanel.add(back);

        tutorialFrame.add(tutorialPanel);
        tutorialFrame.setSize(1000,1000);
        tutorialFrame.setLocationRelativeTo(null);
        tutorialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tutorialFrame.setVisible(true);
    }
}
