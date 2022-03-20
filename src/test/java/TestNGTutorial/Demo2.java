package TestNGTutorial;

import org.testng.annotations.Test;

public class Demo2 {

    @Test(groups = {"Smoke"})
    public void Demo() {
        System.out.println("good");
    }

}