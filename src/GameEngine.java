import GameObjects.DisplayScore;
import GameObjects.Mario;
import GameObjects.Grid.SimpleGxGrid;
import GameObjects.Menu.Background;
import GameObjects.Scoreline;
import GameObjects.Structures.Tubes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameEngine{

    private SimpleGxGrid grid;
    private Background background;
    private Mario mario;
    private Scoreline scoreline1, scoreline2, scoreline3;
    private Scoreline[] scorelineArray;
    private DisplayScore displayScore;
    private CollisionDetector collisionDetector;
    private Controller controller;
    private Picture gameOver;
    private static final int FPS = 60;
    private static final long maxLoopTime = 1000 / FPS;
    private Tubes tubes1, tubes2, tubes3;
    private Tubes[] tubeArray;
    private boolean gameRunning;
    private boolean isGameOver;

    public void setGamerunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public void init() {
        grid = new SimpleGxGrid(73, 45);
        background = new Background();
        mario = new Mario(10, 10, grid);

        //lots of tubes
        tubes1 = new Tubes(70, 0, grid);
        tubes2 = new Tubes(48.33d, 0, grid);
        tubes3 = new Tubes(26.67d, 0,175, grid);
        tubeArray = new Tubes[]{tubes1, tubes2, tubes3};
        displayScore = new DisplayScore(grid);

        scoreline1 = new Scoreline(grid, tubes1);
        scoreline2 = new Scoreline(grid, tubes2);
        scoreline3 = new Scoreline(grid, tubes3);
        scorelineArray = new Scoreline[]{scoreline1, scoreline2, scoreline3};

        collisionDetector = new CollisionDetector(mario, tubeArray, scorelineArray, displayScore);
        controller = new Controller();
        controller.setGameEngine(this);
        gameOver = new Picture(5, 5, "resources/game_over_v2.png");
        grid.init();
        background.renderMainMenu();
        controller.setCharacter(mario);
        controller.init();
        gameState();
    }
    public void gameState(){

        while(true){
            System.out.println();
            if(gameRunning) {
                if(background.getGameOver()!= null){
                    background.hideGameOver();
                }
                background.hideMainMenu();
                background.renderGameRunning();

                mario.render();
                displayScore.draw();
                for (Tubes tube: tubeArray) {

                    tube.show();
                }
                run();
                break;
            }
            if(isGameOver){
                isGameOver = false;
               init();

            }
        }
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void run() {
        long timestamp;
        long oldTimestamp;
        while (true) {
            oldTimestamp = System.currentTimeMillis();
            timestamp = System.currentTimeMillis();
            mario.run();
            for (Tubes tube : tubeArray) {
                tube.moveLeft();
            }
            for (Scoreline line : scorelineArray) {
                line.moveLeft();
            }
            collisionDetector.incrementScore();

            if (displayScore.getCurrentScore() % 5 == 0 && displayScore.getCurrentScore() != 0) {
                for (Tubes tube : tubeArray) {
                    tube.setSpeed();
                }
            }
            if (grid.isOutOfBoundsBot(mario) || grid.isOutOfBoundsTop(mario) || collisionDetector.isCrashed()) {
                background.gameOver();
                gameOver();
                gameRunning = false;
                displayScore.resetScore();
                displayScore.displayHighscore();
                break;
            }
            if (timestamp - oldTimestamp <= maxLoopTime) {

                try {
                    Thread.sleep(maxLoopTime - (timestamp - oldTimestamp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        gameState();
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
    public void gameOver() {
        for (Tubes tube : tubeArray) {
            tube.hide();
        }
        mario.hide();
        for (Scoreline line : scorelineArray) {
            line.hide();
        }
    }

    public Tubes randomTube() {
        int selectedTube = (int) (Math.floor(Math.random() * tubeArray.length));
        return tubeArray[selectedTube];
    }
}
