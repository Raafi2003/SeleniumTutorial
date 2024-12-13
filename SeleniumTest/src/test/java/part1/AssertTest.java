package part1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {
    @Test
    public void setup(){
        String str = "str";
        Boolean valid = true;

        Assert.assertEquals(str, "str");
//        Assert.assertEquals(str, "str"); // fails
        Assert.assertTrue(valid, "Valid");
//        Assert.assertFalse(valid, "Valid"); //fails


    }
}
