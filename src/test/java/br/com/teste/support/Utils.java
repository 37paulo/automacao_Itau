package br.com.teste.support;

import br.com.teste.config.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class Utils extends BaseTest {


    public void acessarPage() throws IOException {
        getDriver().get(baseUrl);

    }

    public void click(By element) throws IOException {
        getDriver().findElement(element).click();
    }

    public void clearValue(By element) throws IOException {
        getDriver().findElement(element).clear();
    }

    public void sendValue(By element, String value) throws IOException {
        getDriver().findElement(element).sendKeys(value);
    }

    public void selecionar(By element, String value) throws IOException {
        WebElement select = getDriver().findElement(element);
        Select selecao = new Select(select);
        selecao.selectByVisibleText(value);
    }

    public void esperaElemento(By element) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scroll(By element) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scroll(0, 390);");
    }
}
