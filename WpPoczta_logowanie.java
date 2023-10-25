package Testy.wp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WpPoczta_logowanie {

    @Test
    public void logowanie (){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wp.pl/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/button[2]")).click();

        driver.findElement(By.xpath("//a[@href='https://poczta.wp.pl']")).click();

        driver.findElement(By.id("login")).sendKeys("jan700460@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Hasło1234");

        driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/form/button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/form/div[3]/span"))
                .getText().equals("Podany login i/lub hasło są nieprawidłowe."));
    }
}
