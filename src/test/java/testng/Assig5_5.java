package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assig5_5 extends Tests {
    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
    @Test
    @Parameters({"browser"})
    public void ToDoApp(@Optional("chrome")String browser){
        driver.get("http://crossbrowsertesting.github.io/");
        //Click to To-Do App
        driver.findElement(By.xpath("//a[@href='todo-app.html']")).click();

        //Checking Box to do-4 and Checking Box to do-5
        driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();

        // check if the length of list is 2 or not .
        By selectedCheckBoxList = By.cssSelector(".done-true");
        int toDoListSize = driver.findElements(selectedCheckBoxList).size();
        Assert.assertEquals(toDoListSize, 2);

        // add new check box and verify .
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Test the App"+ Keys.RETURN);
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='done-false'])[4]")).isDisplayed());

        // check if the length of list is 2 or not . (for archive old todos )
        bot.click( By.xpath("//a[@ng-click='todoList.archive()']"));
        int ListSize = driver.findElements(By.cssSelector(".done-false")).size();
        Assert.assertEquals(ListSize, 4, "List size is :4");
    }
}
