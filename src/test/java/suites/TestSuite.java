package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ArticleTests;
import tests.ChangeAppConditionTests;
import tests.MyListsTest;
import tests.SearchTests;
import tests.iOS.GetStartedTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArticleTests.class,
        ChangeAppConditionTests.class,
        GetStartedTest.class,
        MyListsTest.class,
        SearchTests.class
})

public class TestSuite {}
