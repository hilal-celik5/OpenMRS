package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_409_POM {

    public US_409_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = ".logo")
    public WebElement OpenMRSLogo;

    @FindBy(css = ".icon-hdd")
    public WebElement dataManagement;

    @FindBy(css = "#tasks a")
    public WebElement mergePatientElectronicRecords;

    @FindBy(css = "#patient1-text")
    public WebElement patientID1;

    @FindBy(css = "#patient2-text")
    public WebElement patientID2;

    @FindBy(css = "#patient-search")
    public WebElement patientSearch;

    @FindBy(css = ".confirm")
    public WebElement confirm;

    @FindBy(css = "#first-patient")
    public WebElement firstPatient;

    @FindBy(css = ".messages-container>h1")
    public WebElement mergeMessage;

    @FindBy(css = "#confirm-button")
    public WebElement continueButton;

    @FindBy(css = ".float-sm-right>span")
    public WebElement firstIDText;

    @FindBy(css = ".float-sm-right>span")
    public WebElement secondIDText;
}
