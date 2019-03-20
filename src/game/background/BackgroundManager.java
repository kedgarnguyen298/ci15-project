package game.background;

import game.GameObject;
import game.Settings;
import game.Vector2D;

public class BackgroundManager extends GameObject {
    Background b1;
    Background b2;
    Background currentDisplay;
    Background currentHide;

    public BackgroundManager() {
        b1 = new Background();
        b1.position.set(0, 0);
        b2 = new Background();
        setAfter(b2, b1);
        currentDisplay = b1;
        currentHide = b2;
    }

    @Override
    public void run() {
        super.run();
        if(currentDisplay.position.x < 0) {
            setAfter(currentHide, currentDisplay);
            Background temp = currentDisplay;
            currentDisplay = currentHide;
            currentHide = temp;
        }
    }

    public void setAfter(Background a, Background b) {
        Vector2D newAPosition = b.position.clone();
        newAPosition.add(Settings.BACKGROUND_WIDTH, 0);
        a.position.set(newAPosition);
    }
}
