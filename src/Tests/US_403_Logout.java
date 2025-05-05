package Tests;

import Pages.US_401_402_403_POM;
import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_403_Logout extends BaseDriver {

    // This test verifies that a logged-in user can successfully log out
    // and is redirected back to the login page.
    @Test
    public void successfulLogout() {

        US_402_Login.successfulLogin();
        US_401_402_403_POM elements = new US_401_402_403_POM();

        Assert.assertTrue(elements.verifyLocation.getText().contains("Inpatient Ward"));
        elements.logout.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://o2.openmrs.org/openmrs/login.htm"));
    }
}
