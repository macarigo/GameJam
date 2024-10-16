package GameObjects.Menu;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private final Picture mainMenuBackground = new Picture(5, 5, "resources/start_screen.png");
    private final Picture gameOver = new Picture (5, 5, "resources/gameover_mario.JPG");
    private final Picture gameRunningSky = new Picture (5, 5, "resources/background2.jpg");
    private final Picture gameRunningFire = new Picture(5, 5, "resources/fire_bottom.png");

    public void renderMainMenu(){
        mainMenuBackground.draw();
    }

    public void hideMainMenu() {
        mainMenuBackground.delete();
    }

    public void renderGameRunning() {
        gameRunningSky.draw();
        gameRunningFire.draw();

    }

    public void gameOver() {
        gameOver.draw();

    }

    public Picture getGameOver() {
        return gameOver;
    }

    public void hideGameOver(){
        gameOver.delete();
    }

}
