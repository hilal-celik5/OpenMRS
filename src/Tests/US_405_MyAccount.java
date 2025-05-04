package Tests;

import Pages.US_401_402_403_POM;
import Pages.US_404_405_POM;
import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class US_405_MyAccount extends BaseDriver {

    @Test
    public void myAccount() {

        US_401_402_403_POM element = new US_401_402_403_POM();
        US_404_405_POM elements = new US_404_405_POM();

        Random random = new Random();
        int num = random.nextInt(7);

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        element.username.sendKeys("admin");
        element.password.sendKeys("Admin123");

        switch (num) {
            case 1: elements.inpatientWard.click(); break;
            case 2: elements.isolationWard.click(); break;
            case 3: elements.laboratory.click(); break;
            case 4: elements.outpatientClinic.click(); break;
            case 5: elements.pharmacy.click(); break;
            case 6: elements.registrationDesk.click(); break;
        }

        element.loginButton.click();
        actions.moveToElement(elements.userIcon).perform();
        elements.myAccountLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.changePassword));
        Assert.assertTrue(elements.changePassword.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(elements.myLanguages));
        Assert.assertTrue(elements.myLanguages.isDisplayed());
    }
}
