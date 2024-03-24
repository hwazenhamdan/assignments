package testng;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assig2_5 extends Tests {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ‘’Invalid credentials’’ is displayed.
    //Run it parallel with 3 threads
    //Generate Allure report.
    @Test(dataProvider = "credentilas")
    public void test01(String userName , String password) throws InterruptedException {
        bot.navigate("https://opensource-demo.orangehrmlive.com/");

        bot.type(By.name("username"), userName);
        bot.type(By.name("password"), password);
        bot.click(By.tagName("button"));

        String expectedErrorMessage = "Invalid credentials";
        Thread.sleep(15000);

        String actualErrorMessage = driver.findElement(By.xpath("//*[.='Invalid credentials']")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials");
    }

  @DataProvider(name = "credentilas")
   public Object[][] getData(){
    return new Object[][]{
            {"admin*","admin123"},
            {"admin12","123"},
            {"Admin1","***00**"},
            {"test","123"},
            {"user","369"},

    };
}
}
