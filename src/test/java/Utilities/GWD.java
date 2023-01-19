package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    public static WebDriver driver;

    // ! Paralel static local anlatmadna önce mikroişlemci gelişimini anlatalık, thread e gelelimki
    // aşağıdaki değişkenler için, thread.Sleep den bahsedilebilir, pipeline, local ama static eğişken olmalı
    // pipeline-thread-tread.sleep selenium dedği explicit kullanın biz böyle yaptık.burada thread bazlı static değişken
    // yaplaıyızı o lokale özel

    // biz burada tüm sistemi static ebdriver üzerine kurduk, bu durumda bize local static lazım threade özel
    //Bana neler lazım:  1 browser tipi lazım burada ona göre oluşturucam
    // her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
    // çünkü runner classdaki işaret edilen tüm senaryolarda aynısını çalışması lazım.
    // demekki her pipeline için (Local) ve de ona özel static bir drivera ihtiyacım var
    //donanımdaki adı pipeline , yazılımdaki adı Thread , paralel çalışan her bir süreç

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // WebDriver 1 WebbDriver 2
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox ...

    // threadDriver.get() -> ilgili thread deki driveri verecek
    // threadDriver.set(driver) -> ilgili thread e driver set ediliyor.

    public static WebDriver getDriver() {
        // extend report türkçe bilginin çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
//
        if (threadBrowserName.get() == null) // paralel çalışmayan yani XML den parametreyle gelmeyen her çağıran
            threadBrowserName.set("chrome"); // Basic arayanlar için


        if (threadDriver.get() == null) {

            String browserName = threadBrowserName.get(); // bu threaddeki browsername i verdi.
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    if (!runningFromIntelliJ()) {
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                        threadDriver.set(new ChromeDriver()); // bu thread e chrome istenmişse ve yoksa bir tane ekleniyor
                        //options
                    }
                    else {
                        threadDriver.set(new ChromeDriver());
                    }
                    break;

                case "firefox":
                    //System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());  // bu thread e firefox istenmişse ve yoksa bir tane ekleniyor
                    break;

                case "safari": //Bilgisayarda kuruulu olması gerekiyor olmazsa çalışmıyor.
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                   // System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;

            }
        }

        return threadDriver.get();
    }


    public static void quitDriver() {

        if (threadDriver.get() != null) { // driver varsa
            threadDriver.get().quit();
            //driver.quit();
            WebDriver driver = threadDriver.get();
            driver = null;
    threadDriver.set(driver); // tekrar gelirse için boş olmuş olsun
        }

    }

    public static boolean runningFromIntelliJ()
    {
        String classPath = System.getProperty("java.class.path");
        return classPath.contains("idea_rt.jar");
    }
    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}

