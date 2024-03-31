package testng;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Registration;
public class Assig6 extends Tests {

    @Test(description = "Successful Registration")
    public void FluentRegisteration(){
        String actualText = new Registration(driver,bot)
                .goTo()
                .successfulLogin((String) testData.get("fname"),
                        (String) testData.get("lname"),
                        (String) testData.get("email"),
                        (String) testData.get("telphone"),
                        (String) testData.get("password"),
                        (String) testData.get("confirmpass"))
                .readSuccessMessage();
        Assert.assertEquals(actualText, (String) testData.get("ExpectedSuccessMessage"));
        logger.info("Registration was successful as expected!");
    }


    @BeforeClass
    public void initializeTestDataReader(){
        testData = (JSONObject) testData.get("expandTesting");
    }
}
