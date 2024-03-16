package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class assig5 extends Tester {
    /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */
    @Test
    public void cookies(){
        driver.get("http://facebook.com");
        //getCookies
        System.out.println("Initial list of cookies:");
        driver.manage().getCookies().forEach(System.out::println);
        // addCookie
        driver.manage().addCookie(new Cookie("test1","cookis1"));
       //deleteCookieNamed,
        driver.manage().deleteCookieNamed("test1");
       // deleteAllCookies
        driver.manage().deleteAllCookies();
}
}
