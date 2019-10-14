package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Platform {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform(){

    }

    public static Platform getInstance(){
        if(instance == null){
            instance = new Platform();
        }
        return instance;
    }

    protected AppiumDriver driver;

    public AppiumDriver getDriver() throws Exception{
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()){
            return new AndroidDriver(URL, this.getAndroidDesiredCapabiities());
        } else if(this.isIOS()){
            return new IOSDriver(URL, this.getIOSDesiredCapabiities());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid(){
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS(){
        return isPlatform(PLATFORM_IOS);
    }

    public DesiredCapabilities getAndroidDesiredCapabiities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", "main.MainActivity");
//        capabilities.setCapability("app", "/Users/max/sandbox/JavaAppiumAutomation_lesson4/apks/org.wikipedia.apk");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apks/org.wikipedia.apk");
        return capabilities;
    }

    public DesiredCapabilities getIOSDesiredCapabiities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("platformVersion", "12.2");
//        capabilities.setCapability("app", "/Users/max/sandbox/JavaAppiumAutomation_lesson4/apks/Wikipedia.app");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/apks/Wikipedia.app");
        capabilities.setCapability("automationName", "XCUITest");
        return capabilities;
    }

    private boolean isPlatform(String my_plaform){
        String platform = this.getPlatformVar();
        return my_plaform.equals(platform);
    }

    public String getPlatformVar(){
        return System.getenv("PLATFORM");
    }

}