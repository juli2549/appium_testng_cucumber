package bddfeatures.steps;

import base.BaseSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ThreadLocalDriver;

import java.util.List;
import java.util.Map;

import static utils.DTO.*;
import static utils.DTO.editedItemsQuantity;
import static utils.Helpers.waitFor;

public class ItemSteps extends BaseSteps {

    @Before
    public void setupItemSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
        addedItemsName.clear();
        deletedItems.clear();
        editedItemsName.clear();
        editedItemsQuantity.clear();
    }

    @When("he adds the items")
    public void whenHeAddsTheItems(DataTable dataTable) {
        List<Map<String, String>> values = dataTable.asMaps(String.class, String.class);
        for(int i=0;i<values.size();i++) {
            mainScreen.tapPlusButton();
            mainScreen.typeOnShoppingItemNameTxt(values.get(i).get("item"));
            mainScreen.tapToAddBtn();
            addedItemsName.add(values.get(i).get("item"));
        }
    }

    @When("he edits the items adding the quantity")
    public void whenHeEditsTheItemsAddingTheQuantity(DataTable dataTable) {
        List<Map<String, String>> values = dataTable.asMaps(String.class, String.class);
        for(int i=0;i<values.size();i++) {
            mainScreen.tapListItem(values.get(i).get("item"));
            mainScreen.tapEditButton();
            mainScreen.addQuantityToItemTxt(values.get(i).get("quantity"));
            mainScreen.tapSaveButton();
            editedItemsName.add(values.get(i).get("item"));
            editedItemsQuantity.add(values.get(i).get("quantity"));
        }
    }

    @When("he removes two items")
    public void whenHeRemovesTwoItems(DataTable dataTable) {
        List<Map<String, String>> values = dataTable.asMaps(String.class, String.class);
        for(int i=0;i<values.size();i++) {
            for (int j=0;j<editedItemsName.size();j++){
                if((editedItemsName.get(j)).equals(values.get(i).get("item"))){
                    mainScreen.tapListItem(editedItemsName.get(j) + " - " + editedItemsQuantity.get(j) + " units");
                    mainScreen.tapRemoveButton();
                    deletedItems.add(editedItemsName.get(j) + " - " + editedItemsQuantity.get(j) + " units");
                }
            }
        }
    }

    @Then("the deleted items will not appear in list")
    public void thenTheDeletedItemsWillNotAppearInList() {
        for(int i=0;i<deletedItems.size();i++) mainScreen.verifyThatDeletedItemDoesNotAppear(deletedItems.get(i));

    }

    @When("he checks all the rest of the items")
    public void whenHeChecksAllTheRestOfTheItems() {
        for(int i=0;i<(editedItemsName.size() - deletedItems.size());i++) mainScreen.checkListItem(i);
    }

    @Then("the created items are displayed")
    public void thenTheCreatedItemsAreDisplayed() {
        for(int i=0;i<addedItemsName.size();i++) mainScreen.verifyThatAddedItemsAreVisible(addedItemsName.get(i));
    }


}
