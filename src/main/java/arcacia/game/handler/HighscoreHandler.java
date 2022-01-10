package arcacia.game.handler;

import arcacia.game.util.Score;

import java.io.*;
import java.util.*;


/**
 * Public Class Highscore,
 * die eine Scoreboard von Top 10 Scores bilden/darstellen.
 * implements Serializable, da die Attributen werden Serializiert und Deserializiert
 * mit den Klassenattributen,
 * String : description ist der Titel/Beschreibung von Highscore
 * List   : scoreList, eine (ArrayList) von Score-objekten
 * int    : numberOfEntries, Size von scoreList (Anzahl von Elementen in List)
 * String : dirName, path zu .txt datei Ordner
 */
public class HighscoreHandler implements Serializable {
    protected static List<Score> scoreList = new ArrayList<>();
    protected static int numberOfEntries = 10;
    protected static String dirName = "./TopScore/highscore.txt";

    /**
     * Sorts scoreList
     */
    private static void sort() {
        scoreList.sort(Comparator.comparing(Score::getPoints));
        Collections.reverse(scoreList);
    }
    /**
     * fügt score zur scoreListe:List hinzu, wenn sie höher als die niedrigste Score ist
     * @param score übergibt Score Object (neue erreichte Score von Spieler) die in scoreList hinzugefügt wird
     */
    public static void addScore(Score score) {
        load();
        if (scoreList.size() < numberOfEntries) {
            scoreList.add(score);
            sort();
            save();
        }else {
            Score lowestScore = scoreList.get(9);
            if (score.getPoints() > lowestScore.getPoints()) {
                scoreList.remove(lowestScore);
                scoreList.add(score);
                sort();
                save();
            }
        }
    }
    /**
     * Objekt ins directory schreiben bzw. speichern
     */
    public static void save() {
        try{
            FileOutputStream writeData = new FileOutputStream(dirName);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(scoreList);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Objekt aus directory lesen bzw. laden
     */
    public static void load(){
        try{
            FileInputStream readData = new FileInputStream(dirName);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            scoreList = (List<Score>) readStream.readObject();
            readStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Methode der Klasse Highscore, der die Klassenattributen description:String
     * und scoreList:List (und auch deren Inhalt) nach String umwandeln.
     * die Ausgabe wird aus ästhetischen Gründen in reverse ausgegeben.
     * diese Methode überschrieb den Methode toString() von Klasse Objekt
     * @return output , die StringBuilder als String
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Collections.reverse(scoreList);
        output.append("\n\n");
        for (Score score : scoreList) {
            output.append(score.getName());
            output.append(" - ");
            output.append(score.getPoints());
            output.append("\n");
        }
        return output.toString();
    }

    public static List<Score> getScoreList(){
        load();
        sort();
        return scoreList;
    }

    /**
     * fügt 10 dummy Werte ein mit einem Höhst score von 379 in die Datei Ein
     */
    public static void debugDefautlListe(){
        scoreList.add(new Score("Oscar Heuwes",35));
        scoreList.add(new Score(" Mert Öztürk",37));
        scoreList.add(new Score("Lucas Beyel",42));
        scoreList.add(new Score("Elliot Schibilla",41));
        scoreList.add(new Score("Farhan Sasono",42));
        scoreList.add(new Score("I Made Paundra Daran",36));
        scoreList.add(new Score("Byungjun Kim",51));
        scoreList.add(new Score("Vincent Salgado",52));
        scoreList.add(new Score("Mert Tanrisever",43));
        scoreList.add(new Score("Arcacia",379));
        save();
    }

    public void debugEmptyListe(){
        scoreList = new ArrayList<Score>();
        save();
    }
}
