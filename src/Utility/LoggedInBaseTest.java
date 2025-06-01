package Utility;

import Pages.US_401_402_403_POM;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LoggedInBaseTest extends BaseDriver {

    @BeforeClass
    public void setup() {
        super.setup();
        login();
    }

    public void login() {

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
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
