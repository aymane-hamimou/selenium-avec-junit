import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jumai {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jumia.ma/");
        driver.findElement(By.cssSelector("#pop > div > section > button > svg")).click();
        driver.findElement(By.cssSelector("#jm > div.banner-pop._def > button > span > svg")).click();



    }}
