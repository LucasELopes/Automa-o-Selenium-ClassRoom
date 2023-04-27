package selenium;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.driver.Driver;

public class Salas extends Driver {
    
    private List<String> nomeMateria;
    private List<String> nomeProfessor;
    private List<ImageIcon> imagensSalas;

    public Salas() {

    }

    public Salas(List<WebElement> salas) {
        int index = 0;
        nomeMateria = new LinkedList<>();
        nomeProfessor = new LinkedList<>();
        imagensSalas = new LinkedList<>();
        
        for(WebElement sala : salas) {
            nomeMateria.add(sala.findElement(By.cssSelector("div.R4EiSb")).findElement(By.cssSelector("h2.prWPdf")).findElement(By.cssSelector("div.YVvGBb.z3vRcc-ZoZQ1")).getText());
            nomeProfessor.add(sala.findElement(By.cssSelector("div.R4EiSb")).findElement(By.cssSelector("div.QRiHXd")).getText());
            imagensSalas.add(new ImageIcon(sala.findElement(By.cssSelector("div.TQYOZc")).findElement(By.cssSelector("img.PNzAWd")).getAttribute("src")));
            imagensSalas.get(index).setImage(imagensSalas.get(index).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        }
    }
    
}
