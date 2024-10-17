package br.com.teste.test;

import br.com.teste.page.SeguroPage;
import br.com.teste.support.Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class SeguroTest extends Utils {

    private String msgAtual = "O dinheiro já está na sua conta";

     SeguroPage seguropage = new SeguroPage();

    @Before
    public void open() throws IOException {
        acessarPage();
    }

    @Test
    public void ContratacaoSeguroAtivadoComSucesso() throws IOException {
        seguropage.informarValorValido1();
        seguropage.clickBtnContinuar();
        seguropage.clickCheckBoxAutorizacao();
        seguropage.clickBtnEnviarAnalise();
        WebElement msgEsperada = driver.findElement(By.xpath("//h1[@class=\"ids-title -small -bold\"]"));
        String textoEsperado = msgEsperada.getText();
        assertEquals(textoEsperado,msgAtual);
    }

    @Test
    public void ContratacaoSeguroDesativadoComSucesso() throws IOException {
        seguropage.informarValorValido2();
        seguropage.clicarEmSeguro();
        seguropage.clickBtnAgoraNao();
        seguropage.clickBtnContinuar();
        seguropage.clickCheckBoxAutorizacao();
        seguropage.clickBtnEnviarAnalise();
        WebElement msgEsperada = driver.findElement(By.xpath("//h1[@class=\"ids-title -small -bold\"]"));
        String textoEsperado = msgEsperada.getText();
        assertEquals(textoEsperado, msgAtual);
    }

    @Test
    public void jornadaContratacaoAlterandoParcela() throws IOException {
        seguropage.informarValorValido1();
        seguropage.clickBtnParcelamento();
        seguropage.clickRadioParcelamento();
        seguropage.clickBtnConfirmar();
        seguropage.clickBtnContinuar();
        seguropage.clickCheckBoxAutorizacao();
        seguropage.clickBtnEnviarAnalise();
        WebElement msgEsperada = driver.findElement(By.xpath("//h1[@class=\"ids-title -small -bold\"]"));
        String textoEsperado = msgEsperada.getText();
        assertEquals(textoEsperado, msgAtual);
    }

    @Test
    public void jornadaContratacaoComValorInválido1() throws IOException {
        seguropage.informarValorInvalido1();
        seguropage.clickBtnContinuar();
        seguropage.clickCheckBoxAutorizacao();
        seguropage.clickBtnEnviarAnalise();
        WebElement msgEsperada = driver.findElement(By.xpath("//h1[@class=\"ids-title -small -bold\"]"));
        String textoEsperado = msgEsperada.getText();
        assertEquals(textoEsperado, msgAtual);
    }

    @Test
    public void jornadaContratacaoComValorInválido2() throws IOException {
        seguropage.informarValorInvalido2();
        seguropage.clickBtnContinuar();
        seguropage.clickCheckBoxAutorizacao();
        seguropage.clickBtnEnviarAnalise();
        WebElement msgEsperada = driver.findElement(By.xpath("//h1[@class=\"ids-title -small -bold\"]"));
        String textoEsperado = msgEsperada.getText();
        assertEquals(textoEsperado, msgAtual);
    }

    @AfterEach
    public void close(){
        stopDriver();
    }
}
