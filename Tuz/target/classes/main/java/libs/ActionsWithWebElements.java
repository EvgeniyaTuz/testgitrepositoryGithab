package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import javax.xml.transform.TransformerException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.transform.TransformerException;

public class ActionsWithWebElements {

    WebDriver driver;
    Logger log;
    WebDriverWait webDriverWait10;

    public ActionsWithWebElements(WebDriver webDriver) {
        this.driver = webDriver;
        log = Logger.getLogger(getClass());
        webDriverWait10 = new WebDriverWait(driver, 10);
    }

    /*
    This method input text to text field.
     */
    public void inputTextToField(WebElement inputField, String inputText) {
        try {
            inputField.clear();
            inputField.sendKeys(inputText);
            log.info("Text is inputed");
        } catch (Exception ex) {

            ex.printStackTrace();
            log.error("Text is not input");
            Assert.fail("Cannot work input");
        }
    }

    /*
    Click button.
     */
    public void tapButton(WebElement buttonPlace) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(buttonPlace));
            buttonPlace.click();
            log.info("Button is clicked");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Button is not clicked");
            Assert.fail("Can not click button");
        }
    }

    /*
    Select Drop-Drown list.
     */
    public void selectDropDownByText(String locatorDropDownList, String textDropDown) {
        try {
            Select selectDD = new Select(driver.findElement(By.xpath(locatorDropDownList)));
            selectDD.deselectByVisibleText(textDropDown);
            log.info("Text was selected");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Text does not select");
            Assert.fail("can not select");
        }
    }

    public void selectDDByValue(String locatorDropDownList, String valueDD) {
        try {
            Select selectDD = new Select(driver.findElement(By.xpath(locatorDropDownList)));
            selectDD.deselectByValue(valueDD);
            log.info("Value is selected");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Value is not selected");
        }
    }

    /*
    select check-box
     */
    public void selectCheckBox(String locatorCheckBox, boolean isNeededStatus) {
        try {
            if (isNeededStatus && (!driver.findElement(By.xpath(locatorCheckBox)).isSelected()) || (!isNeededStatus && driver.findElement(By.xpath(locatorCheckBox)).isSelected())) {
                driver.findElement(By.xpath(locatorCheckBox)).click();
            }
            log.error("All is ok!");
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Something went wrong");
        }
    }

    public boolean isElementPresent(WebElement element){

        return (element.isDisplayed() && element.isEnabled());

    }

}