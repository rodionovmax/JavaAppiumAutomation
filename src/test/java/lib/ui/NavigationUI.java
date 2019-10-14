package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static String
            MY_LISTS_LINK;

    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void clickMyList() {
        if (Platform.getInstance().isMW()) {
//            this.tryClickElementWithFewAttempts(
//                    MY_LISTS_LINK,
//                    "Cannot find navigation button to My list",
//                    5
//            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to my list",
                    5
            );
        }
    }
}
