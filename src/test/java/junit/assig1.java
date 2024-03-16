package junit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class assig1 extends Tester{
    //Go to URL: https://the-internet.herokuapp.com/windows
    //Verify the text: “Opening a new window”
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”
    @Test
    public void newWindo(){
        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //Verify the text: “Opening a new window”

        //Verify the title of the page is “The Internet”
        Assertions.assertEquals("The Internet",driver.getTitle());

        //Handle the new window
        String originWindowaHandle=driver.getWindowHandle();
        Set<String> allWindowHandles=driver.getWindowHandles();
        String newWindowHandles = null;
        for(String handle:allWindowHandles){
            if(!handle.equals(originWindowaHandle)){
                newWindowHandles=handle;
                break;
            }
        }

        //Click on the “Click Here” button
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //Verify the new window title is “New Window”
       Assertions.assertEquals("TNew Window",driver.getTitle());

        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(originWindowaHandle);
        Assertions.assertEquals("The Internet",driver.getTitle());
        driver.close();
    }
}
