package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assig4_5 extends Tests{
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.
    By usernameInput = By.id("input-email");
    By passwordInput = By.id("input-password");
    By loginButton = By.xpath("//input[@type='submit']");
    @Test(dataProvider = "getData")
    public void test(String word){
        driver.get(" http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(usernameInput).sendKeys("clarusway@gmail.com");
        driver.findElement(passwordInput).sendKeys("123456789");
        driver.findElement(loginButton).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(word+ Keys.RETURN);

    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"Mac"}  , {"Ipad"} ,{"Samsung"},
        };
    }
}
