package pages;

import libs.ConfigData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage

{
    /*
    String usernameFieldByName = "_username";
    String passwordFieldByID = "password";
    String submitButtonByXPath = "//button[@type='submit']";

    By usernameFieldByName1 = By.name("_username1");
    By passwordFieldByID1 = By.id("password");
    By submitButtonByXPath1 = By.xpath("//button[@type='submit']");

    WebElement usernameFieldByName2 = driver.findElement(By.name("_username1"));
    WebElement passwordFieldByID2 = driver.findElement(By.id("password"));
    WebElement submitButtonByXPath2 = driver.findElement(By.xpath("//button[@type='submit']"));

     */

    @FindBy(name = "_username")
    WebElement usernameFieldByName3;

    @FindBy(id = "password")
    WebElement passwordFieldByID3;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButtonByXPath3;

    public LoginPage (WebDriver driver)
    {
        super(driver);
    }

   public void OpenPageLogin()
   {
       try
       {
           driver.get(ConfigData.getCfgValue( "base_url") + "/login");
           log.info("Page was opened");
       }

       catch (Exception ex)
       {
           Assert.fail("Can not open URL");
       }
   }

   public void OpenLoginPage(String link)
   {
       try {
           driver.get(link);
           log.info("Page was opened");
       } catch (Exception ex)
       {
           ex.printStackTrace();
           log.error("Page does not open" + ex);
       }
   }

   public void InputValueToLoginField(String loginValue)
   {
       actionsWithWebElements.inputTextToField(usernameFieldByName3, loginValue);
   }

    public void InputPassword(String pass)
    {
        actionsWithWebElements.inputTextToField(passwordFieldByID3, pass);
    }

    public void ClickSubmitButton()
    {
        actionsWithWebElements.tapButton(submitButtonByXPath3);
    }

    public void loginUser(String login, String pass){
        OpenPageLogin();
        InputValueToLoginField(login);
        InputPassword(pass);
        ClickSubmitButton();

    }

}
