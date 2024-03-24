package testng;

import org.testng.annotations.Test;

public class Assig1_5 extends Tests {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    @Test
    public void facebookTest(){
        logger.info("Navigating to Facebook");
        bot.navigate("https://www.facebook.com/");

    }
    @Test(dependsOnMethods ="facebookTest" )
    public void googleTest(){
        logger.info("Navigating to Google");
        bot.navigate("https://www.google.com/");
    }
    @Test(dependsOnMethods ="googleTest" )
    public void amazonTest(){
        logger.info("Navigating to Amazon");
        bot.navigate("https://www.amazon/");
    }
}
