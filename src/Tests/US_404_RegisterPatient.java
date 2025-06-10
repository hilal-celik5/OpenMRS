package Tests;

import Pages.US_401_402_403_POM;
import Pages.US_404_405_POM;
import Utility.GuestBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class US_404_RegisterPatient extends GuestBaseTest {

    /**
     * This test verifies the patient registration process.
     * It fills out the registration form with valid data and
     * confirms that the patient is successfully registered.
     */
    @Test
    public void regPatient() {

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
        elements.registerPatientButton.click();
        elements.givenNameInput.sendKeys("John");
        elements.familyNameInput.sendKeys("Jane Doe");
        elements.nextButton.click();
        elements.genderMale.click();
        elements.nextButton.click();
        elements.birthDay.sendKeys("15");
        elements.birthMonth.sendKeys("Jun");
        elements.birthYear.sendKeys("1980");

        wait.until(ExpectedConditions.elementToBeClickable(elements.nextButton)).click();

        elements.addressInput.sendKeys("123 Main St, Los Angeles, CA");
        elements.nextButton.click();
        elements.phoneNumber.sendKeys("(555) 123-4567");
        elements.nextButton.click();
        elements.relationshipSelect.sendKeys("Sibling");
        elements.personNameInput.sendKeys("Jane Doe");
        elements.nextButton.click();
        elements.confirm.click();

        Assert.assertTrue(elements.patientName.isDisplayed());
        Assert.assertTrue(elements.patientID.isDisplayed());
    }
}
