package uk.co.cucumber.steps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

class DriverFactory {
    static ChromeDriver createDriver(String browser) {
        switch (browser) {
            case "chrome":
                return createChromeDriver();
            default:
                throw new IllegalArgumentException("Cannot create driver from browser type [$browser]");
        }
    }

    private static ChromeDriver createChromeDriver() {
        File chromeDriver = null;
        ChromeOptions options = new ChromeOptions();
        if (isMac()) {
            //to run from project test resources
            //URL file = DriverFactory.class.getClassLoader().getResource("drivers/mac/chrome/chromedriver");
            //to run from OS folder
            File file = new File("/drivers/mac/chrome/chromedriver");
            chromeDriver = new File(file.getPath());
        } else if (isLinux()) {
            File file = new File("/home/ubuntu/drivers/chrome/chromedriver");
            chromeDriver = new File(file.getPath());
            options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        }
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        return new ChromeDriver(options);
    }


    private static String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }

    private static boolean isWindows() {
        return (getOSName().indexOf("win") >= 0);
    }

    private static boolean isMac() {
        return (getOSName().indexOf("mac") >= 0);
    }

    private static boolean isLinux() {
        return (getOSName().indexOf("linux") >= 0);
    }
}