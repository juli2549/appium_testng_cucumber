package bddfeatures.steps;

import base.BaseSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ThreadLocalDriver;

import java.util.List;
import java.util.Map;
import static utils.DTO.*;
import static utils.Helpers.waitFor;

public class ListSteps extends BaseSteps {


    @Before
    public void setupListSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
        addedItemsName.clear();
        deletedItems.clear();
        editedItemsName.clear();
        editedItemsQuantity.clear();
    }

    @Given("the user is in the shopping list screen")
    public void givenTheUserIsInTheShoppingListScreen() {
        mainScreen.tapToHamburguerIconMenu();
    }

    @When("the user create new list")
    public void whenTheUserCreateNewList(DataTable dataTable) {
        List<Map<String, String>> values = dataTable.asMaps(String.class, String.class);
        list = values.get(0).get("list");
        shoppingListScreen.tapToNewListBtn();
        shoppingListScreen.typeOnShoppingListNameTxt(values.get(0).get("list"));
        shoppingListScreen.tapToAddBtn();
    }

    @Then("the list created is visible in main screen at bottom of the screen")
    public void thenTheListCreatedIsVisibleInMainScreenAtBottomOfTheScreen() {
        mainScreen.verifyThatListWasCreated(list);
    }

    @When("he archives the complete list")
    public void whenHeArchivesTheCompleteList() {
        mainScreen.tapArchiveButton();
    }

    @When("he deletes the archived list")
    public void whenHeDeletesTheArchivedlist() {
        mainScreen.tapToHamburguerIconMenu();
        shoppingListScreen.swipeToArchiveListsTab();
        shoppingListScreen.tapToThreePointsIconMenu();
        shoppingListScreen.tapToDeleteBtn();
        shoppingListScreen.tapToDeleteOnAlertBtn();
    }

    @Then("the deleted list will not appear in archived lists")
    public void thenTheDeletedListWillNotAppearInArchivedList() {
        shoppingListScreen.verifyThatListWasDeleted();
    }

    @Then("the deleted list will not appear in current lists")
    public void thenTheDeletedListWillNotAppearInCurrentList() {
        shoppingListScreen.swipeToCurrentListsTab();
        shoppingListScreen.verifyThatThereIsNoListInCurrentListsTab();
    }





}
