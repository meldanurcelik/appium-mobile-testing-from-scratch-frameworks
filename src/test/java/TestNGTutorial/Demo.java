package TestNGTutorial;

import org.testng.annotations.Test;

public class Demo {

    @Test
    public void Demo() {
        System.out.println("Hello world");
    }

    @Test(groups = {"Smoke"})
    public void SecondTest() {
        System.out.println("Bye");
    }

}