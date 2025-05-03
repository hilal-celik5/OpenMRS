package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_401_402_403_POM {

    public US_401_402_403_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "[href='https://openmrs.org/tr/g%C3%B6steri/']")
    public WebElement demo;

    @FindBy(css = "[href='#openmrs2']")
    public WebElement exploreOpenMRS2;

    @FindBy(css ="[href='https://demo.openmrs.org/openmrs/login.htm']" )
    public WebElement enterTheOpenMRS2;

    @FindBy(css = "[id='username']")
    public WebElement username;

    @FindBy(css = "[id='password']")
    public WebElement password;

    @FindBy(css = "[id='Inpatient Ward']")
    public WebElement inpatientWard;

    @FindBy(css = "[id='loginButton']")
    public WebElement loginButton;

    @FindBy(css = "[id='sessionLocationError']")
    public WebElement locationErrorMessage;

    @FindBy(css = "[id='error-message']")
    public WebElement invalidLoginMessage;

    @FindBy(xpath = "//*[contains(text(), 'admin')]")
    public WebElement userAccountName;

    @FindBy(css = "[href='javascript:void(0);']")
    public WebElement verifyLocation;

    @FindBy(css = "[href='/openmrs/appui/header/logout.action?successUrl=openmrs']")
    public WebElement logout;
}
