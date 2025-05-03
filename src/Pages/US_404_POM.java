package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_404_POM {

    public US_404_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[id='Inpatient Ward']")
    public WebElement inpatientWard;

    @FindBy(css = "[id='Isolation Ward']")
    public WebElement isolationWard;

    @FindBy(css = "[id='Laboratory']")
    public WebElement laboratory;

    @FindBy(css = "[id='Outpatient Clinic']")
    public WebElement outpatientClinic;

    @FindBy(css = "[id='Pharmacy']")
    public WebElement pharmacy;

    @FindBy(css = "[id='Registration Desk']")
    public WebElement registrationDesk;

    @FindBy(xpath = "(//div[@id='apps']/a)[4]")
    public WebElement registerPatientButton;

    @FindBy(css = "[name='givenName']")
    public WebElement givenNameInput;

    @FindBy(css = "[name='familyName']")
    public WebElement familyNameInput;

    @FindBy(css = "[id='next-button']")
    public WebElement nextButton;

    @FindBy(xpath = "//option[text()='Male']")
    public WebElement genderMale;

    @FindBy(css = "[id='birthdateDay-field']")
    public WebElement birthDay;

    @FindBy(css = "[id='birthdateMonth-field']")
    public WebElement birthMonth;

    @FindBy(css = "[id='birthdateYear-field']")
    public WebElement birthYear;

    @FindBy(css = "[id='address1']")
    public WebElement addressInput;

    @FindBy(css = "[name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(css = "[id='relationship_type']")
    public WebElement relationshipSelect;

    @FindBy(css = "[placeholder='Person Name']")
    public WebElement personNameInput;

    @FindBy(css = "[id='submit']")
    public WebElement confirm;

    @FindBy(css = "[class='PersonName-givenName']")
    public WebElement patientName;

    @FindBy(css = "[class='float-sm-right']>em")
    public WebElement patientID;
}
