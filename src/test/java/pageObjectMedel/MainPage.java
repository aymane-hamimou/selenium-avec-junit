package pageObjectMedel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    //Initialisation de pages factory
    @FindBy(css = "#HTMLFormElements > table > tbody > tr:nth-child(1) > td > input[type=text]")
    //Variable privée donc il faut ajouter le setter (La ligne 53)
    private WebElement ID;



    WebDriver driver;
    //Constructeur qui utilise le driver
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//    public WebElement ID(){
//        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(1) > td > input[type=text]"));
//    }
    public WebElement PSS(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(2) > td > input[type=password]"));
    }
    public WebElement TEXTAREA(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(3) > td > textarea"));
    }
    public WebElement Upload(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(4) > td > input[type=file]:nth-child(2)"));
    }
    public WebElement CheckBox(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(5) > td > input[type=checkbox]:nth-child(3)"));
    }
    public WebElement MUltiFildes1(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(5) > td > input[type=checkbox]:nth-child(4)"));

    }
    public WebElement MUltiFildes2(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(7) > td > select > option:nth-child(1)"));

    }
    public WebElement Dropdown(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(8) > td > select > option:nth-child(5)"));
    }
    public WebElement BoutonSoumission(){
        return driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(9) > td > input:nth-child(2)"));
    }
    // Page identification de setter
    public void setID(String userName){
        ID.click();
        ID.sendKeys(userName);
    }

}
