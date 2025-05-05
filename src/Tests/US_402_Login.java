package Tests;

import Pages.US_401_402_403_POM;
import Utility.BaseDriver;
import Utility.ElementActions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class US_402_Login extends BaseDriver {

    // This test verifies a successful login attempt.
    @Test
    public static void successfulLogin() {

        US_401_402_403_POM elements = new US_401_402_403_POM();

        driver.get("https://openmrs.org/tr/");

        elements.demo.click();
        ElementActions.scrollToElement(elements.exploreOpenMRS2);
        ElementActions.clickElement(elements.exploreOpenMRS2);
        ElementActions.clickElement(elements.enterTheOpenMRS2);

        elements.username.sendKeys("admin");
        elements.password.sendKeys("Admin123");
        elements.inpatientWard.click();
        elements.loginButton.click();

        Assert.assertTrue(elements.userAccountName.getText().contains("admin"));
    }
}
