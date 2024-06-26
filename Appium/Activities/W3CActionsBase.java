package examples;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class W3CActionsBase {

    //create pointer
    // PointerInput is a class
    private final static PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration){

        Sequence swipe = new Sequence(finger, 1).
                addAction(finger.createPointerMove(ofMillis(0),viewport(), start.getX(), start.getY()));
    }
}
