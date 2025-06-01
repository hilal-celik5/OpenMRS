package Tests;

import Pages.US_401_402_403_POM;
import Utility.LoggedInBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_402_Login extends LoggedInBaseTest {

    // This test verifies a successful login attempt.
    @Test
    public void successfulLogin() {
        US_401_402_403_POM elements = new US_401_402_403_POM();
        Assert.assertTrue(elements.userAccountName.getText().contains("admin"));
    }
}
