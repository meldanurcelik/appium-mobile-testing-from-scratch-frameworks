package MavenTutorial;

import org.testng.annotations.Test;

public class SeleniumTest {

    // testng xml file from Maven
    // how to execute all test cases from Test folder  - mvn test
    @Test
    public void BrowserAUtomation()
    {
        System.out.println("BrowserAUtomation");
    }

    @Test
    public void ElementsUi()
    {
        System.out.println("ElementsUi");
    }

}