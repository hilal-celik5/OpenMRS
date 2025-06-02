package Tests;

import Pages.US_407_408_410_POM;
import Utility.LoggedInBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_407_DeletePatient extends LoggedInBaseTest {

    @Test
    public void deletePatient() {

        US_407_408_410_POM elements = new US_407_408_410_POM();

        elements.findPatientRecordButton.click();
        elements.searchInput.sendKeys("1000T9");

        try {
            wait.until(ExpectedConditions.visibilityOf(elements.noMatchMessage));
            System.out.println("Hasta bulunamadı: " + "1000T9");
            return;
        } catch (Exception e) {
            System.out.println("Hasta siliniyor...");
        }

        wait.until(ExpectedConditions.elementToBeClickable(elements.firstPatientRow)).click();
        elements.deletePatient.click();
        elements.deleteReasonInput.sendKeys("Incorrect information");
        elements.confirmButton.click();

        Assert.assertTrue(elements.deleteSuccessMessage.getText().contains("deleted"));
    }
}
