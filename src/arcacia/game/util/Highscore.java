package arcacia.game.util;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Highscore implements Serializable {
    protected String description;
    protected List<Score> scoreList;
    protected static int numberOfEntries = 10;
    protected String dirName = "./highscore/highscore.txt";

    // number of entries set list limit to 10, setAsHighscore is always true
    public Highscore(String description) {
        this.description = description;
        scoreList = new ArrayList<Score>();
    }

    private void sort() {
        scoreList.sort(new Comparator<Score>() {
            @Override
            public int compare(Score score1, Score score2) {
                Integer int1 = score1.getPoints();
                Integer int2 = score2.getPoints();
                return int1.compareTo(int2);
            }
        });
    }

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

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dirName))) {
            oos.writeObject(this);
            //     System.out.println("write : " + this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serialized data is saved in " + dirName);
    }

    public void load(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dirName))){
            Highscore loadedGame = (Highscore) ois.readObject();
            System.out.println("\nRead : \n" + loadedGame);
            ois.close();

        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("DeSerialized data from " + dirName);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
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
}