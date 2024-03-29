package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.driver.Driver;

public class Login extends Driver {

    public Login() {

    }

    public Login(String email, String password) throws Exception {
        super(false);

        int indexAroba = email.indexOf("@");

        driver.get("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fclassroom.google.com&passive=true");

        //inserindo o email institucional.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierId\"]"))).sendKeys(email, Keys.ENTER); 

        Thread.sleep(2000);

        if(driver.findElements(By.cssSelector("div.rFrNMe.N3Hzgf.jjwyfe.QBQrY.zKHdkd.sdJrJc.Tyc9J.CDELXb.k0tWj.IYewr")).size() == 1) {
            throw new Exception("Email inválido!");            
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]"))).sendKeys(email.substring(0, indexAroba));

        // inserindo senha
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(password, Keys.ENTER);
        
        if(driver.findElements(By.cssSelector("div.banner.banner-danger.banner-dismissible")).size() == 1) {
            throw new Exception("Senha inválida!");            
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"))).click();
        
        // Quem vai instancia a classe é o gui telaSalas.
        new Salas(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li.gHz6xd.Aopndd.rZXyy"))));
    }

    public static void main(String[] args) throws Exception {

    }
}
