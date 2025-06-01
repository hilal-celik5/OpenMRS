package Tests;

import Pages.US_406_POM;
import Utility.LoggedInBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_406_PatientSearch extends LoggedInBaseTest {

    /**
     * This test class verifies the patient search functionality.
     * It confirms that searching with valid input displays patient details,
     * and searching with invalid input shows an appropriate warning message.
     */
    @Test(dataProvider = "patientValidCredentials")
    public void searchPatientByValidInput(String patientInfo) {

        US_406_POM elements = new US_406_POM();

        elements.findPatientRecordButton.click();
        elements.searchInput.clear();
        elements.searchInput.sendKeys(patientInfo);

        wait.until(ExpectedConditions.visibilityOf(elements.resultsTable));

        WebElement patient = elements.getPatientByFullName(patientInfo);
        patient.click();

        wait.until(ExpectedConditions.visibilityOf(elements.patientInfoPanel));
        Assert.assertTrue(elements.patientInfoPanel.isDisplayed(), "Hasta bilgi paneli görünmüyor!");
    }

    @DataProvider
    Object[] patientValidCredentials() {
        return new Object[]{"William Lee", "Lisa Hall", "1000X1", "10007F"};
    }

    @Test(dataProvider = "invalidPatientCredentials")
    public void searchPatientByInvalidInput(String patient) {

        US_406_POM elements = new US_406_POM();

        elements.findPatientRecordButton.click();
        elements.searchInput.clear();
        elements.searchInput.sendKeys(patient);

        wait.until(ExpectedConditions.visibilityOf(elements.resultsTable));

        Assert.assertTrue(elements.noMatchingRecordsMessage.isDisplayed(), "Uyarı mesajı görünmüyor!");
    }

    @DataProvider
    Object[] invalidPatientCredentials() {
        return new Object[]{"Demir", "Aslı", "12345", "10236"};
    }
}
