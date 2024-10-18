package GameObjects;

import GameObjects.Grid.SimpleGxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class DisplayScore {

    private String score;
    private String maxscore;
    private int currentScore = 0;
    private int highscore = 0;
    private final Text display = new Text(30, 30, score);
    private final Text displayHighscore = new Text(510,500,maxscore);


    public DisplayScore(SimpleGxGrid grid) {
        score = "Score: " + currentScore;
        currentScore = 0;
    }
    public int getCurrentScore(){
        return currentScore;
    }

    public void draw(){
        displayHighscore.delete();
        display.setText(score);
        display.setColor(Color.WHITE);
        display.grow(10,5);
        display.draw();

    }

    public void setScore() {
        currentScore++;
        score = "Score: " + currentScore;
        display.setText(score);
    }

    public void displayHighscore(){
        maxscore = "Highscore: " + highscore;
        displayHighscore.setText(maxscore);
        displayHighscore.draw();
    }

    public void resetScore(){
        if(currentScore > highscore){
            highscore = currentScore;
        }
        currentScore = 0;
        score = "Score: " + currentScore;
        display.delete();
    }
}