package Tests;

import Pages.US_407_408_410_POM;
import Utility.LoggedInBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_408_PatientListSizeAssertion extends LoggedInBaseTest {

    @Test
    public void patientList() {
        US_407_408_410_POM elements = new US_407_408_410_POM();

        elements.findPatientRecordButton.click();
        wait.until(ExpectedConditions.visibilityOf(elements.totalPatientCountText));

        String patientCountText = elements.totalPatientCountText.getText();
        String[] part = patientCountText.split(" ");
        int expectedPatientCount = Integer.parseInt(part[5]);

        Assert.assertTrue(elements.patientRows.size() == expectedPatientCount, "Hasta sayıları uyuşmuyor! ");
    }
}
