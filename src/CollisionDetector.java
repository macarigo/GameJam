import GameObjects.DisplayScore;
import GameObjects.Mario;
import GameObjects.Scoreline;
import GameObjects.Structures.Tubes;

public class CollisionDetector {

    private final Mario mario;
    private final Tubes[] tubs;
    private final Scoreline[] scoreline;
    private final DisplayScore score;


    public CollisionDetector(Mario mario, Tubes[] tubs, Scoreline[] scoreline, DisplayScore score) {
        this.mario = mario;
        this.tubs = tubs;
        this.scoreline = scoreline;
        this.score = score;


    }

    public boolean isCrashed() {
        for (Tubes tube : tubs) {

            if ((mario.getX() + mario.getMarioWidth() >= tube.getXBot() &&
                    mario.getX() <= tube.getXBot() + tube.getWidth() &&
                    mario.getY() + mario.getMarioHeight() >= tube.getYBot())) {
                return true;
            } else if (mario.getX() + mario.getMarioWidth() >= tube.getXTop() &&
                    mario.getX() <= tube.getXTop() + tube.getWidth() &&
                    mario.getY() <= tube.getYTop() + tube.getHeightTop()) {
                return true;
            }
        }
        return false;
    }


    public void incrementScore() {
        for (Scoreline line : scoreline) {
            if (mario.getX() >= line.getX() && line.canScore()) {
                score.setScore();
                line.setCanScore(false);
            } else if (line.isReset()) {
                line.setCanScore(true);
                line.setReset(false);
            }
        }
    }
}
