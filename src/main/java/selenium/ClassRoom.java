package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import selenium.driver.Driver;

public class ClassRoom extends Driver{
    public ClassRoom(String email, String password) {
    // public ClassRoom() {
        super(false);
        driver.get("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fclassroom.google.com&passive=true");

        //inserindo o email institucional.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierId\"]"))).sendKeys(email, Keys.ENTER); 
        
        //inserindo usuário -------------- precisa de uma classe responsável por dar o usuário já pronto FRONT é seu serviço
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]"))).sendKeys("lucas.e.tavares");

        // inserindo senha
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(password, Keys.ENTER);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/span"))).click();
    }

    public static void main(String[] args) {
        new ClassRoom("lucas.e.tavares@edu.ufes.br", "vamopavupli");
    }
}
