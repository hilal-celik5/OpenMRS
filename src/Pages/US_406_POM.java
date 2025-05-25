package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_406_POM {

    public US_406_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    public WebElement findPatientRecordButton;

    @FindBy(css = "[id='patient-search']")
    public WebElement searchInput;

    @FindBy(css = "#patient-search-results-table")
    public WebElement resultsTable;

    @FindBy(css = "#content")
    public WebElement patientInfoPanel;

    @FindBy(css = "[class='dataTables_empty']")
    public WebElement noMatchingRecordsMessage;

    public WebElement getPatientByFullName(String fullName) {
        // Tablo içindeki satırlarda ilgili isim içeren <td> elementini bul
        String dynamicXpath = ".//td[contains(text(), '" + fullName + "')]";
        List<WebElement> matches = resultsTable.findElements(By.xpath(dynamicXpath));

        if (matches.size() > 0)
            return matches.get(0);
        else
            return null;
    }
}
