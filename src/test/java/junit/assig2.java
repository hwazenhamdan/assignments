package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class assig2 extends Tester{
     /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
     @Test
     public void dragAndDrop(){
         driver.get("http://demo.guru99.com/test/drag_drop.html");
         By draggable = By.xpath("//*[@id='credit2']/a");
         By droppable = By.xpath("//*[@id='bank']/li");

       //Drag and drop the BANK button to the Account section in DEBIT SIDE
         new Actions(driver)
                 .dragAndDrop(driver.findElement(By.xpath("//*[@id='credit2']/a"))
                         , driver.findElement(By.xpath("//*[@id='bank']/li")))
                 .perform();

         //Drag and drop the SALES button to the Account section in CREDIT SIDE
         new Actions(driver)
                 .dragAndDrop(driver.findElement(By.xpath("//*[@id='credit1']/a"))
                         , driver.findElement(By.xpath("//*[@id='loan']/li")))
                 .perform();

         //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
         new Actions(driver)
                 .dragAndDrop(driver.findElement(By.xpath("(//*[@id='fourth']/a)[1]"))
                         , driver.findElement(By.xpath("//*[@id='amt7']/li")))
                 .perform();

         //Drag and drop the second 5000 button to the Amount section in CREDIT SID
         new Actions(driver)
                 .dragAndDrop(driver.findElement(By.xpath("(//*[@id='fourth']/a)[2]"))
                         , driver.findElement(By.xpath("//*[@id='amt8']/li")))
                 .perform();

         Assertions.assertEquals("Perfect!", driver.findElement((By.xpath("//a[@class='button button-green']"))).getText());

     }

     }


