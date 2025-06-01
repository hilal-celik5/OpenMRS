package Utility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GuestBaseTest extends BaseDriver {

    @BeforeClass
    public void setup() {
        super.setup();
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
