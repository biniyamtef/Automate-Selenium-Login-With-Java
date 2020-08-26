package mailLogin;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class gmailLoginTest {

    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com");

        // email
        driver.findElement(By.id("identifierId")).sendKeys("kkjavatest@gmail.com",Keys.ENTER);
        Thread.sleep(3000);

        // password
        driver.findElement(By.name("password")).sendKeys("Java12345",Keys.ENTER);
        Thread.sleep(6000);

        // Assertion
        String actualUrl = "https://mail.google.com/mail/u/0/#inbox";
        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        if(actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}

