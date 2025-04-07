import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class initwebdriver  {
    static WebDriver driver; // Déclaration de la variable partagée

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver(); // Utilisation de la variable globale
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
    }
    @Test
    public void t001_test() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
//        driver.manage().window().maximize();
//        //ID
        WebElement ID = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(1) > td > input[type=text]"));
        ID.click();
        ID.sendKeys("test");
        //PASSWORD
        WebElement PSS =driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(2) > td > input[type=password]"));
        PSS.click();
        PSS.sendKeys("test1234");
        //TEXTAREA
        WebElement TEXTAREA = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(3) > td > textarea"));
        TEXTAREA.click();
        TEXTAREA.clear();
        TEXTAREA.sendKeys("test");
        //Upload Image
        WebElement Upload = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(4) > td > input[type=file]:nth-child(2)"));
        Upload.sendKeys("C:\\Users\\aymane\\IdeaProjects\\selenium-avec-Junit\\target\\Image\\2.png");
        //CheckBox Items
        WebElement CheckBox = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(5) > td > input[type=checkbox]:nth-child(3)"));
        CheckBox.click();
        driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(5) > td > input[type=checkbox]:nth-child(4)")).click();
        //MUlti Fildes
        driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(7) > td > select > option:nth-child(1)")).click();
        // Dropdown
        driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(8) > td > select > option:nth-child(5)")).click();

        driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(9) > td > input:nth-child(2)")).click();

//  Verification des champs
        WebElement chkUsername = driver.findElement(By.id("_valueusername"));
        WebElement chkPwd = driver.findElement(By.id("_valuepassword"));
        WebElement chkCmt = driver.findElement(By.id("_valuecomments"));
        WebElement chkFile = driver.findElement(By.id("_valuefilename"));
        WebElement chkChcBox = driver.findElement(By.id("_valuecheckboxes0"));
        WebElement chkRadio = driver.findElement(By.id("_valueradioval"));
        WebElement chkMultiSelect1 = driver.findElement(By.id("_valuemultipleselect0"));
        WebElement chkMultiSelect2 = driver.findElement(By.id("_valuemultipleselect1"));
        WebElement chkDropDown = driver.findElement(By.id("_valuedropdown"));

        assertEquals(chkUsername.getText(), "test");
        assertEquals(chkPwd.getText(), "test1234");
    }
    @Test
    public void t002_test() {
        driver.navigate().refresh();
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
