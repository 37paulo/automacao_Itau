package br.com.teste.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseTest {

    public static WebDriver driver;

    protected String baseUrl = "http://localhost:8080/Projeto_Exemplo_automacao.html";

    public static boolean isServerRunning(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.connect();
            int responseCode = connection.getResponseCode();
            return responseCode == 200;
        } catch (IOException e) {
            return false;
        }
    }

    public static void startServer() throws IOException {
        if (!isServerRunning("http://localhost:8080")) {
            ProcessBuilder processBuilder = new ProcessBuilder("npm", "start");
            processBuilder.start();
            System.out.println("Servidor iniciado...");
        } else {
            System.out.println("Servidor já está rodando.");
        }
    }

    public static WebDriver getDriver() throws IOException {
        startServer();
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void stopDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}
