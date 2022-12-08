package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD_OLD {

    public static WebDriver driver;
   // private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // WebDriver 1 WebbDriver 2
   // public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox ...




    public static WebDriver getDriver(){
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");



        if (driver==null) {
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.SEVERE);//sadece errorları göster.
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            //firefox
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) { // driver varsa
            //threadDriver.get().quit();
            driver.quit();
//            WebDriver driver = threadDriver.get();
            driver = null;
  //          threadDriver.set(driver); // tekrar gelirse için boş olmuş olsun
        }

    }
    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

