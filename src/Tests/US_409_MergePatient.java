package Tests;

import Pages.US_404_405_POM;
import Pages.US_409_POM;
import Utility.LoggedInBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class US_409_MergePatient extends LoggedInBaseTest {

    @Test
    public void mergeTwoPatients() {

        US_404_405_POM registerPage = new US_404_405_POM();
        US_409_POM mergePage = new US_409_POM();

        String name1 = "John" + getRandomNumber();
        String surname1 = "Doe" + getRandomNumber();
        String name2 = "Alice" + getRandomNumber();
        String surname2 = "Smith" + getRandomNumber();

        registerPage.registerPatientButton.click();
        String patientID1 = registerPatient(registerPage, name1, surname1);

        mergePage.OpenMRSLogo.click();
        registerPage.registerPatientButton.click();
        String patientID2 = registerPatient(registerPage, name2, surname2);

        mergePage.OpenMRSLogo.click();
        mergePage.dataManagement.click();
        mergePage.mergePatientElectronicRecords.click();
        mergePage.patientID1.sendKeys(patientID1);
        mergePage.patientID2.sendKeys(patientID2);
        mergePage.patientSearch.click();

        wait.until(ExpectedConditions.elementToBeClickable(mergePage.confirm)).click();
        wait.until(ExpectedConditions.visibilityOf(mergePage.firstPatient)).click();

        Assert.assertTrue(mergePage.mergeMessage.getText().contains("Merging cannot be undone!"));

        wait.until(ExpectedConditions.elementToBeClickable(mergePage.continueButton)).click();

        Assert.assertTrue(mergePage.firstIDText.isDisplayed());
        Assert.assertTrue(mergePage.secondIDText.isDisplayed());
    }

    public String registerPatient(US_404_405_POM p, String firstName, String lastName) {

        p.givenNameInput.sendKeys(firstName);
        p.familyNameInput.sendKeys(lastName);
        p.nextButton.click();
        p.genderMale.click();
        p.nextButton.click();
        p.birthDay.sendKeys("15");
        p.birthMonth.sendKeys("Jun");
        p.birthYear.sendKeys("1980");

        wait.until(ExpectedConditions.elementToBeClickable(p.nextButton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(p.addressInput));
        p.addressInput.sendKeys("123 Main St, Los Angeles, CA");
        p.nextButton.click();
        p.phoneNumber.sendKeys("(555) 123-4567");
        p.nextButton.click();
        p.relationshipSelect.sendKeys("Sibling");
        p.personNameInput.sendKeys("Mary Doe");
        p.nextButton.click();
        p.confirm.click();

        return wait.until(ExpectedConditions.visibilityOf(p.patientID)).getText();
    }

    public int getRandomNumber() {
        return new Random().nextInt(2000);
    }
}
