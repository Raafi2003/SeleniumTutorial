package part1;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import  java.util.*;
public class attributesPractice {
    @Test(priority = 0, enabled = false)
    public void test1(){
        System.out.println("first");
    }
    @Test(priority = 2,enabled = false, dependsOnMethods = {"test3"}, alwaysRun = true)
    void test2(){
        System.out.println("second");
    }
    @Test(priority = 1, enabled = false)
    void test3(){
        System.out.println("third");
    }

    @DataProvider(name = "testData")
    public Object[][] provideData() {
        return new Object[][] {
                {"Alice", 25},
                {"Bob", 30},
                {"Charlie", 35}
        };
    }
    @Test(dataProvider = "testData")
    public void testWithDataProvider(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }


}
