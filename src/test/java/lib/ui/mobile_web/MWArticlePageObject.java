package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:minerva-footer";
//        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://a[@class='mw-ui-icon-element watch-this-article mw-ui-icon view-border-box mw-ui-icon-wikimedia-star-base20']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://a[@class='mw-ui-icon-element mw-ui-icon-wikimedia-star-base20 watch-this-article mw-ui-icon view-border-box']/..";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[@class='mw-ui-icon-element watch-this-article mw-ui-icon view-border-box mw-ui-icon-wikimedia-unStar-progressive watched']";

        DESIGNED_BY = "css:td>a[title='James Gosling']";
        JAVA_VIRTUAL_MACHINES = "css:li[title='Java virtual machine']";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
