package Tests;

import Pages.US_407_408_410_POM;
import Utility.LoggedInBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_407_DeletePatient extends LoggedInBaseTest {

    @Test(dataProvider = "patientInformation")
    public void deletePatient(String patient) {

        US_407_408_410_POM elements = new US_407_408_410_POM();

        elements.findPatientRecordButton.click();
        elements.searchInput.sendKeys(patient);

        try {
            wait.until(ExpectedConditions.visibilityOf(elements.noMatchMessage));
            System.out.println("Hasta bulunamadı: " + patient);
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

    @DataProvider
    Object[] patientInformation() {
        return new Object[]{"1000NG"};
    }
}
