import GameObjects.DisplayScore;
import GameObjects.Floppy;
import GameObjects.Scoreline;
import GameObjects.Structures.Tubes;

public class CollisionDetector {

    private final Floppy floppy;
    private final Tubes[] tubs;
    private final Scoreline[] scoreline;
    private final DisplayScore score;


    public CollisionDetector(Floppy floppy, Tubes[] tubs, Scoreline[] scoreline, DisplayScore score) {
        this.floppy = floppy;
        this.tubs = tubs;
        this.scoreline = scoreline;
        this.score = score;


    }

    public boolean isCrashed() {
        for (Tubes tube : tubs) {

            if ((floppy.getX() + floppy.getFloppyWidth() >= tube.getXBot() &&
                    floppy.getX() <= tube.getXBot() + tube.getWidth() &&
                    floppy.getY() + floppy.getFloppyHeight() >= tube.getYBot())) {
                return true;
            } else if (floppy.getX() + floppy.getFloppyWidth() >= tube.getXTop() &&
                    floppy.getX() <= tube.getXTop() + tube.getWidth() &&
                    floppy.getY() <= tube.getYTop() + tube.getHeightTop()) {
                return true;
            }
        }
        return false;
    }


    public void incrementScore() {
        for (Scoreline line : scoreline) {
            if (floppy.getX() >= line.getX() && line.canScore()) {
                score.setScore();
                line.setCanScore(false);
            } else if (line.isReset()) {
                line.setCanScore(true);
                line.setReset(false);
            }
        }
    }
}
