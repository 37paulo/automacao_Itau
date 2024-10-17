package br.com.teste.page;

import br.com.teste.support.Utils;
import org.junit.After;
import org.openqa.selenium.By;

import java.io.IOException;

public class SeguroPage extends Utils {


    private By valor = By.id("ids-input-0");
    private By radioParcelamento = By.xpath("//input[@ng-reflect-value=\"2\"]");
    private By btnContinuar = By.xpath("//span[@class=\"ids-main-button__content\" and text()=\" Continuar \"]");
    private By seguro = By.xpath("//*[text()=\"Seguro\"]");
    private By checkBoxAutorizacao  = By.id("ids-checkbox-1");
    private By btnEnviarAnalise = By.xpath("//span[@class=\"ids-main-button__content\" and text()=\" Enviar para análise \"]");
    private By btnQueroMeProteger = By.xpath("//span[@class=\"ids-main-button__content\" and text()=\" Quero me proteger \"]");
    private By btnAgoraNao = By.xpath("//span[@class=\"ids-main-button__content\" and text()=\" Agora não \"]");
    private By btnParcelamento = By.xpath("//*[text()=\"Parcelamento\"]");
    private By btnConfirmar = By.xpath("//span[@class=\"ids-main-button__content\" and text()=\" Confirmar \"]");

    public String valorValido1 = "80.00";
    public String valorValido2 = "186418.00";
    public String valorInvalido1 = "79.00";
    public String valorInvalido2 = "186418.01";


    public void informarValorValido1() throws IOException {
        esperaElemento(valor);
        clearValue(valor);
        sendValue(valor, valorValido1);
    }

    public void informarValorValido2() throws IOException {
        esperaElemento(valor);
        clearValue(valor);
        sendValue(valor, valorValido2);
    }

    public void informarValorInvalido1() throws IOException {
        esperaElemento(valor);
        clearValue(valor);
        sendValue(valor, valorInvalido1);
    }

    public void informarValorInvalido2() throws IOException {
        esperaElemento(valor);
        clearValue(valor);
        sendValue(valor, valorInvalido2);
    }

    public void clickBtnContinuar() throws IOException {
        click(btnContinuar);
    }

    public void clicarEmSeguro() throws IOException {
        click(seguro);
    }

    public void clickCheckBoxAutorizacao() throws IOException {
        scroll(checkBoxAutorizacao);
        click(checkBoxAutorizacao);
    }

    public void clickBtnEnviarAnalise() throws IOException {
        click(btnEnviarAnalise);
    }

    public void clickBtnAgoraNao() throws IOException {
        click(btnAgoraNao);
    }

    public void clickBtnQueroProteger() throws IOException {
        click(btnQueroMeProteger);
    }

    public void clickBtnParcelamento() throws IOException {
        click(btnParcelamento);
    }

    public void clickRadioParcelamento() throws IOException {
        click(radioParcelamento);
    }

    public void clickBtnConfirmar() throws IOException {
        click(btnConfirmar);
    }

}
