package loginTest;

import org.junit.Test;
import parentTest.ParentTest;


public class ValidTest extends ParentTest{

    public ValidTest(String browser){
        super(browser);
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.OpenPageLogin();
        loginPage.InputValueToLoginField("Student");
        loginPage.InputPassword("909090");
        loginPage.ClickSubmitButton();
        checkAcceptanceCriteria
                ("Avatar is not present", homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria
                ("Title is not present", homePage.getTitle(), "Учет запчастей");

        homePage.isAvatarPresent();
        // homePage.clickOnsubMenuSpare();
        // homePage.clickOnsubMenuTypeSdelki();
        homePage.checkTitle("Учет запчастей");
        homePage.isAvatarStudentPresent();

        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuApparat();
        homePage.clickOnsubAddButton();
        homePage.inputTextToApparatNumberField("1234");
        homePage.inputTextToApparatCommentField("This is test");
        homePage.clickOnsubCreateButton();

        homePage.clickOnAvatarStudent();
        homePage.clickOnbuttonLogout();
    }

}
