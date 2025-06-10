package Tests;

import Pages.US_407_408_410_POM;
import Utility.LoggedInBaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_410_TimeZoneError extends LoggedInBaseTest {

    @Test
    public void shouldShowErrorWhenTimeZoneIsIncorrectDuringBooking() {
        US_407_408_410_POM elements = new US_407_408_410_POM();

        elements.appointmentScheduling.click();
        elements.manageAppointments.click();
        elements.searchInput.sendKeys("1000X");

        wait.until(ExpectedConditions.elementToBeClickable(elements.firstPatientRow));
        elements.firstPatientRow.click();

        Assert.assertTrue(elements.timeZoneErrorMessage.getText().contains("time zone"));
    }
}
