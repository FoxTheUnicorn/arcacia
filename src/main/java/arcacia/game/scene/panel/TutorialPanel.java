package arcacia.game.scene.panel;

import arcacia.game.objects.item.*;
import arcacia.game.scene.other.HomeButton;
import arcacia.game.scene.other.IconLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TutorialPanel extends JPanel {
    public TutorialPanel()
    {
        setLayout(null);
        initControls();
        initItemGuide();
        initGameDescription();
        setPreferredSize(new Dimension(1000,500));

        HomeButton homeButton = new HomeButton();
        homeButton.setLocation(0,0);
        add(homeButton);
    }

    private void initGameDescription() {
        JLabel game = new JLabel("Spielbeschreibung");
        JTextArea gameDescription = new JTextArea("""
                Allgemein geht es in dem Spiel darum in einem Labyrinth mit Gegnern zu ueberleben und alle drei Level zu schaffen.
                Der Spieler muss einen Schluessel einsammeln und damit zum Ausgang gehen um ins naechste Level zu kommen.
                Die Level werden dabei immer schwieriger, aber der Spieler kann Items einsammeln, die ihm helfen.
                Wenn der Spieler alle Leben verliert oder in dem dritten Level durch den Ausgang geht ist das Spiel vorbei.
                Wenn der Spieler alle Level beendet hat kann er seine Punktanzahl in eine Highscore Liste eintragen.""");

        game.setBounds(400,380,200,30);
        gameDescription.setBounds(100,410,750,90);
        add(game);
        add(gameDescription);
    }

    private void initControls() {
        JLabel inputLabel = new JLabel("Tastenbelegung:");
        inputLabel.setBounds(400,0,200,30);

        //region Control List
        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("W/Pfeil oben:     Spieler bewegt sich nach oben");
        l1.addElement("A/Pfeil links:    Spieler bewegt sich nach links");
        l1.addElement("S/Pfeil unten:    Spieler bewegt sich nach unten");
        l1.addElement("D/Pfeil rechts:   Spieler bewegt sich nach rechts");
        l1.addElement("Escape:           Pause Menu aufrufen");
        JList<String> list = new JList<>(l1);
        list.setBounds(300,30,300,90);
        //endregion

        add(inputLabel);
        add(list);
    }

    private void initItemGuide() {
        ArrayList<IconLabel> itemList = new ArrayList<>();

        //region Definition of Labels
        JLabel itemLabel = new JLabel("Items:"); itemLabel.setBounds(400,120,200,30);

        itemList.add(new IconLabel("Beim aufsammeln erhoeht dies die Punkte des Spielers um 1.", CoinItem.path));
        itemList.add(new IconLabel("Wenn der Spieler diesen Schluessel aufsammelt, kann er zum Ausgang gehen um ins naechste Level zu kommen.", Key.path));
        itemList.add(new IconLabel("Der Spieler kann fuer 20 Runden zwei Zuege machen bevor die Gegner wieder ziehen koennen.", SpeedBoots.path));
        itemList.add(new IconLabel("Die Gegner bleiben fuer 20 Runden stehen.", Stopwatch.path));
        itemList.add(new IconLabel("Wenn der Spieler dieses Item aufgesammelt hat, kann er fuer 20 Runden lang die Gegner beruehren und sie somit zurueck zu ihrem Startpunkt befoerdern.", PowerPill.path));
        itemList.add(new IconLabel("Fuer 20 Runden bekommt der Spieler beim Aufsammeln von Punkten die doppelte Anzahl.", Multiplier.path));
        itemList.add(new IconLabel("Der Spieler bekommt ein extra Leben.",ExtraLife.path));
        //endregion

        int i = 150;
        for(JLabel jlabel : itemList)
        {
            jlabel.setBounds(80, i, 1000, 30);
            i = i+32;
            this.add(jlabel);
        }
    }
}
