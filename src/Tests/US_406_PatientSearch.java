package Tests;

import Pages.US_406_POM;
import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_406_PatientSearch extends BaseDriver {

    /**
     * This test class verifies the patient search functionality.
     * It confirms that searching with valid input displays patient details,
     * and searching with invalid input shows an appropriate warning message.
     */
    @Test
    public void searchPatientByValidInput() {

        US_406_POM elements = new US_406_POM();
        US_402_Login.successfulLogin();

        elements.findPatientRecordButton.click();
        elements.searchInput.clear();
        elements.searchInput.sendKeys("William Lee");

        wait.until(ExpectedConditions.visibilityOf(elements.resultsTable));

        WebElement patient = elements.getPatientByFullName("William Lee");
        patient.click();

        wait.until(ExpectedConditions.visibilityOf(elements.patientInfoPanel));
        Assert.assertTrue(elements.patientInfoPanel.isDisplayed(), "Hasta bilgi paneli görünmüyor!");
    }

    @Test
    public void searchPatientByInvalidInput() {

        US_406_POM elements = new US_406_POM();
        US_402_Login.successfulLogin();

        elements.findPatientRecordButton.click();
        elements.searchInput.clear();
        elements.searchInput.sendKeys("Demir");

        wait.until(ExpectedConditions.visibilityOf(elements.resultsTable));

        Assert.assertTrue(elements.noMatchingRecordsMessage.isDisplayed(), "Uyarı mesajı görünmüyor!");
    }
}
