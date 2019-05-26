package loginTest;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;
import java.util.Map;

public class ValidLoginWithXlsParam extends ParentTest {

    public ValidLoginWithXlsParam(String browser) {
        super(browser);
    }

    @Test

    public void validLogin () throws Exception {
        Map dataFromExcelForValidTest = excelDriver.getData(ConfigData.getCfgValue("DATA_FILE"),"validLogOn");
        loginPage.OpenPageLogin();
        loginPage.InputValueToLoginField(dataFromExcelForValidTest.get("login").toString());
        loginPage.InputPassword(dataFromExcelForValidTest.get("pass").toString());
        loginPage.ClickSubmitButton();
        checkAcceptanceCriteria
                ("Login is not correct", loginPage.getTitle(), "Учет запчастей");

    }
}
