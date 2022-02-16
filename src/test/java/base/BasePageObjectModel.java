package base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class BasePageObjectModel {

    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait                wait;
    protected TouchAction                  touch;

    public BasePageObjectModel(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        touch = new TouchAction(driver);
    }

    protected void waitAndClick(By by) { wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click(); }

    protected void tap(By by) {
        driver.findElement(by).click();
    }

    protected void tapDynamicElement(By by, int index) {
        driver.findElements(by).get(index).click();
    }


    protected void typeTextOnKeyboard(String text) {
        driver.getKeyboard().sendKeys(text);

    }



    protected void  wait(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void hideKeyboard() { driver.navigate().back(); }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void swipeToRight() {
        int heightOfScreen = driver.manage().window().getSize().getHeight();
        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int x1 = (int) (widthOfScreen * 0.105555555555556);
        int x2 = (int) (widthOfScreen * 0.891666666666667);
        int y = (int) (heightOfScreen * 0.551724137931034);

        touch.press(PointOption.point(x1,y))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point(x2,y))
                .release()
                .perform();

    }

    protected void swipeToLeft() {
        int heightOfScreen = driver.manage().window().getSize().getHeight();
        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int x1 = (int) (widthOfScreen * 0.105555555555556);
        int x2 = (int) (widthOfScreen * 0.891666666666667);
        int y = (int) (heightOfScreen * 0.551724137931034);

        touch.press(PointOption.point(x2,y))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point(x1,y))
                .release()
                .perform();
    }

    protected void tapByCoordinates(int x, int y) {
        touch.tap(PointOption.point(x, y))
                .perform();
    }


}
