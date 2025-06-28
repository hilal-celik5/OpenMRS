package Tests;

import Pages.US_401_402_403_POM;
import Utility.ElementActions;
import Utility.GuestBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_401_CheckingLoginErrors extends GuestBaseTest {

    // This test verifies that login fails when no location is selected
    // and incorrect user credentials are entered.
    @Test(dataProvider = "invalidCredentials")
    public void incorrectLogin(String username, String password) {

        US_401_402_403_POM elements = new US_401_402_403_POM();

        driver.get("https://openmrs.org/tr/");

        elements.demo.click();
        ElementActions.scrollToElement(elements.exploreOpenMRS2);
        ElementActions.clickElement(elements.exploreOpenMRS2);
        ElementActions.clickElement(elements.enterTheOpenMRS2);
        elements.username.sendKeys(username);
        elements.password.sendKeys(password);
        elements.loginButton.click();

        Assert.assertTrue(elements.locationErrorMessage.getText().contains("You must choose a location!"));

        driver.navigate().refresh();
        elements.username.sendKeys(username);
        elements.password.sendKeys(password);

        ElementActions.Wait(2);
        elements.inpatientWard.click();
        elements.loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(elements.invalidLoginMessage));
        Assert.assertTrue(elements.invalidLoginMessage.getText().contains("Invalid username/password"));
    }

    @DataProvider
    Object[][] invalidCredentials() {
        return new Object[][] {
                {"adMin", "ADmin123"},
                {"ADMIN", "Admin123"},
                {"", "Admin123"},
                {"admin", ""},
                {"admin", "admin123"},
                {"Admin", "Admin123"}
        };
    }
}
