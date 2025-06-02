package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_407_408_410_POM {

    public US_407_408_410_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "(//div[@id='apps']/a)[1]")
    public WebElement findPatientRecordButton;

    @FindBy(xpath = "//input[@id='patient-search']")
    public WebElement searchInput;

    @FindBy(xpath = "//*[text()='No matching records found']")
    public WebElement noMatchMessage;

    @FindBy(xpath = "//table[@id='patient-search-results-table']/tbody/tr")
    public WebElement firstPatientRow;

    @FindBy(css = "[id='org.openmrs.module.coreapps.deletePatient']")
    public WebElement deletePatient;

    @FindBy(xpath = "//input[@id='delete-reason']")
    public WebElement deleteReasonInput;

    @FindBy(xpath = "(//button[contains(text(), 'Confirm')])[4]")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[contains(text(), 'deleted')]")
    public WebElement deleteSuccessMessage;



    @FindBy(css = "#patient-search-results-table tbody tr")
    public List<WebElement> patientRows;

    @FindBy(css = "#patient-search-results-table_info")
    public WebElement totalPatientCountText;







    @FindBy(xpath = "(//div[@id='apps']/a)[5]")
    public WebElement appointmentScheduling;

    @FindBy(xpath = "(//div[@id='apps']/div)[3]")
    public WebElement manageAppointments;

    @FindBy(xpath = "//div[@id='time-zone-warning']//p")
    public WebElement timeZoneErrorMessage;
}
