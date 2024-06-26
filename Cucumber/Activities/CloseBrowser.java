package stepDefinitions;

import io.cucumber.java.en.Then;

public class CloseBrowser extends BaseClass{
    @Then("close the browser")
    public void closeTheBrowser(){
        driver.quit();
    }
}
