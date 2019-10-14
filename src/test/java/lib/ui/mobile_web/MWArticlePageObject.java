package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:minerva-footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#ca-watch";
        DESIGNED_BY = "css:td>a[title='James Gosling']";
        JAVA_VIRTUAL_MACHINES = "css:li[title='Java virtual machine']";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
