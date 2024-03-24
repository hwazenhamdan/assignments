package junit;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class assig6 extends Tester {
    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    @Test
    public void ScreenShotTest(){
        driver.get("http://amazon.com");
        // Take Full Page Screenshot.
        File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileHandler.copy(src, new File(/var/folders/hy/xcx81qk93b94gpgsx547xzp00000gn/T/screenshot8021523845440852233.png"));

        // Take any spesific WebElement ScreenShot.
     WebElement spesificScreenshot= driver.findElement(By.xpath("//i[@class='a-icon a-logo']"));
        File source= spesificScreenshot.getScreenshotAs(OutputType.FILE);

    }
}
