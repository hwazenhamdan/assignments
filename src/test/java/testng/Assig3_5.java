package testng;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assig3_5 extends Tests{
    /* Add three different log messages for the task below:
go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By submitButton = By.id("submit");
    private final By Label = By.className("post-title");
    private final By errorMessage = By.id("error");
    @Test
    public void successfulLogin(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");
        JSONObject testCaseData = (JSONObject) testData.get("SoftAssertionsTestData");
        bot.type(usernameInput, (String) testCaseData.get("Username"));
        bot.type(passwordInput, (String) testCaseData.get("Password"));
        bot.click(submitButton);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(Label).isDisplayed(), "Successful Login label is not displayed!");

    }
    @Test
    public void failedLogin(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");
        JSONObject testCaseData = (JSONObject) testData.get("SoftAssertionsTestData");
        bot.type(usernameInput, (String) testCaseData.get("Username"));
        bot.type(passwordInput, (String) testCaseData.get("WrongPassword"));
        bot.click(submitButton);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Your password is invalid!");
    }

    @Test
    public void failedLogin2(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");
        JSONObject testCaseData = (JSONObject) testData.get("SoftAssertionsTestData");
        bot.type(usernameInput, (String) testCaseData.get("WrongUsername"));
        bot.type(passwordInput, (String) testCaseData.get("Password"));
        bot.click(submitButton);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "");
        softAssert.assertAll();
    }
}
