package arcacia.game.util;
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
public class Highscore implements Serializable {
    protected String description;
    protected List<Score> scoreList;
    protected static int numberOfEntries = 10;
    protected String dirName = "./highscore/highscore.txt";

   /** Constructor für Class Highscore
    * der eine neue ArrayList von Score Objekten erzeugt
     * @param description ist der Titel
     */
    public Highscore(String description) {
        this.description = description;
        scoreList = new ArrayList<Score>();
    }
    /**
     * Sorts scoreList
     */
    private void sort() {
        scoreList.sort((score1, score2) -> {
            Integer int1 = score1.getPoints();
            Integer int2 = score2.getPoints();
            return int1.compareTo(int2);
        });
    }
    /**
     * fügt score zur scoreListe:List hinzu, wenn sie höher als die niedrigste Score ist
     * @param score übergibt Score Object (neue erreichte Score von Spieler) die in scoreList hinzugefügt wird
     * @return true wenn score Highscore ist
     */
    public boolean addScore(Score score) {
        if (scoreList.size() < numberOfEntries) {
            scoreList.add(score);
            sort();
            save();
            return true;
        }

        Score lowestScore = scoreList.get(0);
        if (score.getPoints() > lowestScore.getPoints()) {
            scoreList.remove(lowestScore);
            scoreList.add(score);
            sort();
            save();
            return true;
        }
        return false;
    }
    /**
     * Objekt ins directory schreiben bzw. speichern
     */
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dirName))) {
            oos.writeObject(this);
            //     System.out.println("write : " + this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serialized data is saved in " + dirName);
    }
    /**
     * Objekt aus directory lesen bzw. laden
     */
    public void load(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dirName))){
            Highscore loadedGame = (Highscore) ois.readObject();
            System.out.println("\nRead : \n" + loadedGame);
            ois.close();
            this.scoreList = loadedGame.scoreList;
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("DeSerialized data from " + dirName);
    }
    /**
     * Methode der Klasse Highscore, der die Klassenattributen description:String
     * und scoreList:List (und auch deren Inhalt) nach String umwandeln
     * diese Methode überschrieb den Methode toString() von Klasse Objekt
     * @return output , die StringBuilder als String
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Collections.reverse(scoreList);
        output.append(description);
        output.append("\n\n");
        for (Score score : scoreList) {
            output.append(score.getName());
            output.append(" - ");
            output.append(score.getPoints());
            output.append("\n");
        }
        return output.toString();
    }

    public List<Score> getScoreList(){
        load();
        return scoreList;
    }

    /**
     * fügt 10 dummy Werte ein mit einem Höhst score von 379
     */
    public void debugDefautlListe(){
        addScore(new Score("Oscar Heuwes",35));
        addScore(new Score(" Mert Öztürk",37));
        addScore(new Score("Lucas Beyel",42));
        addScore(new Score("Elliot Schibilla",41));
        addScore(new Score("Farhan Sasono",42));
        addScore(new Score("I Made Paundra Daran",36));
        addScore(new Score("Byungjun Kim",51));
        addScore(new Score("Vincent Salgado",52));
        addScore(new Score("Mert Tanrisever",43));
        addScore(new Score("Arcadia",379));
    }
}