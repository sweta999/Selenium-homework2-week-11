package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterLinkForFemale {
    WebDriver driver;

    @Before
    public void setUP() {
        String baseUrl = "https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("https://demo.nopcommerce.com");
        driver.findElement(By.name("btnK")).submit();
        // driver.findElement(By.xpath("//input[@value='Google Search'][@data-ved='0ahUKEwjSq4ODmdPwAhXPz4UKHcFgB6kQ4dUDCAk']")).click();
        driver.findElement(By.xpath("//h3[text()='nopCommerce demo store']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        String expectedMessage = "Register";
        WebElement message = driver.findElement(By.xpath("//div[@class='page-title']/h1[text()='Register']"));
        String actualMessage = message.getText();
        Assert.assertEquals( "User not on Register Page",expectedMessage,actualMessage);

        driver.findElement(By.xpath("//div[@class='title']/strong[text()='Your Personal Details']"));
        //driver.findElement(By.xpath("//div[@id='gender']/span/input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//div[@id='gender']/span[2]/input[@id='gender-female']")).click();
        driver.findElement(By.xpath("//div[@class='inputs']/input[@id='FirstName']")).sendKeys("Jeena");
        driver.findElement(By.xpath("//div[@class='inputs']/input[@id='LastName']")).sendKeys("Kumari");
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[@name='DateOfBirthDay']")).sendKeys("8");
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[@name='DateOfBirthMonth']")).sendKeys("2");
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select[@name='DateOfBirthYear']")).sendKeys("1940");
        driver.findElement(By.xpath("//div[@class='inputs']/input[@id='Email']")).sendKeys("jeena@gmail.com");
        driver.findElement(By.xpath("//div[@class='inputs']/input[@name='Company']")).sendKeys("Asian Paints Ltd");
        driver.findElement(By.xpath("//div[@class='inputs']/input[@id='Password']")).sendKeys("Z123AC");
        driver.findElement(By.xpath("//div[@class='inputs']/input[@id='ConfirmPassword']")).sendKeys("Z123AC");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        //Assert
        String expectMessage = "Your registration completed";

        WebElement errorMessage = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String realMessage = errorMessage.getText();

        Assert.assertEquals(" ",expectMessage,realMessage);

    }

    @After
    public void tearDown() {
        driver.quit();
    }


}


