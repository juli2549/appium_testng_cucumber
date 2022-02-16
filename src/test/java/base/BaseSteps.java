package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageobjectmodel.MainScreen;
import pageobjectmodel.ShoppingListScreen;

public class BaseSteps {
    protected MainScreen mainScreen;
    protected ShoppingListScreen shoppingListScreen;
    public void setupScreens(AndroidDriver<MobileElement> driver) {
        mainScreen = new MainScreen(driver);
        shoppingListScreen = new ShoppingListScreen(driver);
    }
}