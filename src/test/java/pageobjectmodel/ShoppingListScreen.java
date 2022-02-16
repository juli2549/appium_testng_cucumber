package pageobjectmodel;

import base.BasePageObjectModel;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingListScreen extends BasePageObjectModel {

    public ShoppingListScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Mobile Elements*/
    By btnNewList   = MobileBy.AccessibilityId("NEW LIST");
    By txtShoppingListName   = MobileBy.className("android.widget.EditText");
    By btnAdd   = MobileBy.AccessibilityId("ADD");
    By btnArchive = MobileBy.AccessibilityId("ARCHIVE");
    By btnDelete = MobileBy.AccessibilityId("Delete");
    By btnDeleteOnAlert = MobileBy.AccessibilityId("DELETE");
    By lblNoArchivedListMsg = MobileBy.AccessibilityId("There are no archived lists.");
    By lblNoCurrentListsMsg = MobileBy.AccessibilityId("There are no current lists, create one!");

    /**Actions*/
    public void tapToNewListBtn() {
        wait(btnNewList);
        tap(btnNewList);
    }

    public void tapToAddBtn() {
        wait(btnAdd);
        tap(btnAdd);
    }

    public void tapArchiveButton(){
        wait(btnArchive);
        tap(btnArchive);
    }

    public void swipeToArchiveListsTab(){
        swipeToLeft();
    }

    public void swipeToCurrentListsTab(){
        swipeToRight();
    }

    public void tapToThreePointsIconMenu() {
        int heightOfScreen = driver.manage().window().getSize().getHeight();
        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int x = (int) (widthOfScreen * 0.925);
        int y = (int) (heightOfScreen * 0.256704980842912);
        tapByCoordinates(x,y);
    }

    public void tapToDeleteBtn() {
        wait(btnDelete);
        tap(btnDelete);
    }

    public void tapToDeleteOnAlertBtn() {
        wait(btnDeleteOnAlert);
        tap(btnDeleteOnAlert);
    }

    public void typeOnShoppingListNameTxt(String value){
        waitAndClick(txtShoppingListName);
        typeTextOnKeyboard(value);
        hideKeyboard();
    }

    public void verifyThatListWasDeleted() {
        waitAndFindElement(lblNoArchivedListMsg);
    }

    public void verifyThatThereIsNoListInCurrentListsTab() {
        waitAndFindElement(lblNoCurrentListsMsg);
    }


}
