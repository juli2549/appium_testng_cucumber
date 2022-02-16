package pageobjectmodel;

import base.BasePageObjectModel;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainScreen extends BasePageObjectModel {

    public MainScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**Mobile Elements*/
    By iconThreePointsMenu   = MobileBy.AccessibilityId("Show menu");
    By barHamburguerMenu   = MobileBy.AccessibilityId("No list selected");
    By btnPlus = By.className("android.widget.Button");
    By txtShoppingItemName   = By.className("android.widget.EditText");
    By btnAdd   = MobileBy.AccessibilityId("ADD");
    By btnEdit = MobileBy.AccessibilityId("EDIT");
    By btnSave = MobileBy.AccessibilityId("SAVE");
    By btnRemove = MobileBy.AccessibilityId("REMOVE");
    By checkboxItem = By.className("android.widget.CheckBox");
    By btnArchive = MobileBy.AccessibilityId("ARCHIVE");


    /**Actions*/
    public void tapToThreePointsIconMenu() {
        wait(iconThreePointsMenu);
        tap(iconThreePointsMenu);
    }

    public void tapToHamburguerIconMenu() {
        wait(barHamburguerMenu);
        tap(barHamburguerMenu);
    }

    public void tapPlusButton(){
        wait(btnPlus);
        tapDynamicElement(btnPlus,1);
    }

    public void typeOnShoppingItemNameTxt(String value){
        waitAndClick(txtShoppingItemName);
        typeTextOnKeyboard(value);
        hideKeyboard();
    }

    public void addQuantityToItemTxt(String quantity){
        waitAndClick(txtShoppingItemName);
        typeTextOnKeyboard(" - " + quantity + " units");
        hideKeyboard();
    }

    public void tapToAddBtn() {
        wait(btnAdd);
        tap(btnAdd);
    }

    public void tapListItem(String item){
        wait(MobileBy.AccessibilityId(item));
        tap(MobileBy.AccessibilityId(item));
    }

    public void tapEditButton(){
        wait(btnEdit);
        tap(btnEdit);
    }

    public void tapSaveButton(){
        wait(btnSave);
        tap(btnSave);
    }

    public void tapRemoveButton(){
        wait(btnRemove);
        tap(btnRemove);
    }

    public void tapArchiveButton(){
        wait(btnArchive);
        tap(btnArchive);
    }

    public void checkListItem(int index){
        wait(checkboxItem);
        tapDynamicElement(checkboxItem, index);
    }

    public void verifyThatListWasCreated(String expectedValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(expectedValue)));
    }

    public void verifyThatDeletedItemDoesNotAppear(String itemName) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AccessibilityId(itemName)));
    }

    public void verifyThatAddedItemsAreVisible(String itemName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(itemName)));
    }

    public void verifyThatEditedItemsAreVisibleWithQuantity(String itemName, String quantity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(itemName + " - " + quantity + " units")));
    }



}
