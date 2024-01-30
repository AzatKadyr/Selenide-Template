package Main;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static Main.Constants.*;

public class driver {

    public static void browserConfig() {

        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;

        if (!IS_USING_SELENOID) {

            System.out.println("DriverManager local");
            Configuration.headless = false;
            Configuration.browserVersion = "114.0.5735.90";
            Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        }else{
            System.out.println("Using selenoid");
            Configuration.remote = SELENOID_URL+"/wd/hub";

            Map<String, Object> options = new HashMap<>();
            options.put("enableVNC", true);
            options.put("enableVideo", true);
            options.put("enableLog", true);
            options.put("videoName", SELENOID_VIDEO_NAME);

            ChromeOptions capabilities = new ChromeOptions();
            capabilities.setBrowserVersion(BROWSER_VERSION);
            Configuration.browserCapabilities = capabilities;
            Configuration.browserCapabilities.setCapability("selenoid:options", options);

        }

    }



}
