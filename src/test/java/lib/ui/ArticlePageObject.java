package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            DESIGNED_BY,
            JAVA_VIRTUAL_MACHINES,
            CLOSE_ARTICLE_BUTTON;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 5);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    20);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementToAppear(FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40);
        }
    }

    public void scrollWebPageDownByPixels(int pixels) {
        if (Platform.getInstance().isMW()) {
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0," + pixels + ")");
        } else {
            System.out.println("Method scrollWebPageUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    public void findDesignedBy() {
        this.waitForElementAndClick(
                DESIGNED_BY,
                "Cannot find button to open article options",
                10
        );
    }

    public void checkThatElementIsPresent() {

//        waitForElementPresentBy(By.cssSelector("li[title='Java virtual machine']"), "error", 10);
        waitForElementPresentBy(By.cssSelector("ul>li>a[href='/wiki/Java_virtual_machine']"), "error", 10);
//        WebElement element = driver.findElement(By.cssSelector("li[title='Java virtual machine']"));
//        if (element.)
    }

    public void findJavaVirtualMachines() {
        this.waitForElementAndClick(
                JAVA_VIRTUAL_MACHINES,
                "Cannot find button to open article options",
                10
        );
    }





    public void addArticleToMyList(String name_of_folder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                10
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find the option to add article to option list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find GOT IT button",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );


        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot enter text for into articles folder",
                5
        );

        this.waitForElementAndClick(
                //in case of error use By.xpath("//*[@text='OK']"),
                MY_LIST_OK_BUTTON,
                "Cannot find OK button",
                5
        );
    }

    public void addArticlesToMySaved() {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItsAdded();
        }

        javaWaitInSec(2);

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list", 10);
    }

    public void removeArticleFromSavedIfItsAdded() {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove article from saved",
                    1
            );
            this.waitForElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add article to saved list after removing from this list",
                    1
            );
        }
    }

    public void closeArticle() {
        if (Platform.getInstance().isIOS() || (Platform.getInstance().isAndroid())) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close the article, cannot find X link",
                    5
            );
        } else {
            System.out.println("Method closeArticle() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

}
