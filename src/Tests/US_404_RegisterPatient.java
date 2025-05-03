package Tests;

import Utility.BaseDriver;
import org.testng.annotations.Test;

public class US_404_RegisterPatient extends BaseDriver {

    @Test
    public void regPatient() {

        US_402_Login.successfulLogin();

    }
}
