import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectMedel.MainPage;

import static junit.framework.Assert.assertEquals;

// Indique que l'ordre d'exécution des tests suit l'ordre alphabétique des noms des méthodes
@TestMethodOrder(MethodOrderer.MethodName.class)
public class initwebdriver  {
    // Déclaration du WebDriver en tant que variable statique partagée entre tous les tests
    static WebDriver driver; // Déclaration de la variable partagée

    // Méthode exécutée avant tous les tests - Initialisation du WebDriver
    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver(); // Utilisation de la variable globale
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
    }
    // Premier test : remplissage du formulaire et vérification de deux champs
    @Test
    public void t001_test() {
        // --- Remplissage des champs du formulaire ---

        // Champ ID (nom d'utilisateur)
//        WebElement ID = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(1) > td > input[type=text]"));
//        ID.click();
//        ID.sendKeys("test");

        // declaré un objet de type MainPage
        MainPage objmainPage = new MainPage(driver);
        //utilisé la méthode ID qui existe dans la classe MainPage
        //------------------------------------------------------------------------------------
//        objmainPage.ID().click();
//        objmainPage.ID().sendKeys("test");
        //------------------------------------------------------------------------------------
        //page model
        //objmainPage.remplissageUserName("test");
        //factory model
        objmainPage.setID("test");

        // Champ Mot de passe
//        WebElement PSS =driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(2) > td > input[type=password]"));
//        PSS.click();
//        PSS.sendKeys("test1234");

        //utilisé la méthode PSS qui existe dans la classe MainPage
          objmainPage.PSS().click();
          objmainPage.PSS().sendKeys("test1234");

        // Champ zone de texte
        //WebElement TEXTAREA = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(3) > td > textarea"));
//        TEXTAREA.click();
//        TEXTAREA.clear();
//        TEXTAREA.sendKeys("test");
            objmainPage.TEXTAREA().click();
            objmainPage.TEXTAREA().clear();
            objmainPage.TEXTAREA().sendKeys("test");

        // Téléversement d'une image (chemin local de l'image à adapter selon votre PC)

//        WebElement Upload = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(4) > td > input[type=file]:nth-child(2)"));
//        Upload.sendKeys("C:\\Users\\aymane\\IdeaProjects\\selenium-avec-Junit\\target\\Image\\2.png");
        objmainPage.Upload().sendKeys("C:\\Users\\aymane\\IdeaProjects\\selenium-avec-Junit\\target\\Image\\2.png");

        //CheckBox Items   // Cases à cocher

//        WebElement CheckBox = driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(5) > td > input[type=checkbox]:nth-child(3)"));
//        CheckBox.click();
        objmainPage.CheckBox().click();

        //MUlti Fildes   // Sélection multiple (multi-select)
//        driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(5) > td > input[type=checkbox]:nth-child(4)")).click();
//        driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(7) > td > select > option:nth-child(1)")).click();
        objmainPage.MUltiFildes1().click();
        objmainPage.MUltiFildes2().click();
        // Dropdown // Liste déroulante (dropdown)
//        driver.findElement(By.cssSelector("#HTMLFormElements > table > tbody > tr:nth-child(8) > td > select > option:nth-child(5)")).click();
       objmainPage.Dropdown().click();
        // Bouton de soumission du formulaire
        objmainPage.BoutonSoumission().click();

        // --- Vérification des valeurs transmises après soumission ---
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
        assertEquals(chkCmt.getText(), "test");
        assertEquals(chkFile.getText(), "2.png");
        assertEquals(chkChcBox.getText(), "cb2");
        assertEquals(chkRadio.getText(), "rd2");
        assertEquals(chkMultiSelect1.getText(), "ms1");
        assertEquals(chkMultiSelect2.getText(), "ms4");
        assertEquals(chkDropDown.getText(), "dd5");
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
