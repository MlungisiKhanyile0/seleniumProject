package WeatherGroupID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Driverclass {

   WebDriver driverAcu,weather24;

    Weather24 obj24 = new Weather24();
    Accuweather objAccu = new Accuweather();

    @Before
    public void setupBeforeTest() {
        obj24.con24();
        objAccu.conAccu();

    }

    @Test
    public void openWeather24() {
        obj24.elementLow();
        obj24.elementHigh();

    }

    @Test
    public void openAccuweather() {
        objAccu.accuelow();
        objAccu.accueHigh();
    }

    @Test
    public void comp() {
        String ans = "false";
        if (objAccu.accuelow().equals(obj24.elementLow())) {
            ans = "True";

        } else {
            ans = "not done";
        }
        System.out.println(ans);
    }

         @After
        public void tearDownTest ()
        {
            obj24.close24();
            objAccu.closeacc();

        }
    }

