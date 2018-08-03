package WeatherGroupID;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Weather24 {

    WebDriver driver24;
      public void con24()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver24 = new ChromeDriver();
        String baseUrl = "http://weather.news24.com/sa/durban";
        driver24.get(baseUrl);

    }


    public String elementLow() {
          String result=null;
        driver24.manage().timeouts().implicitlyWait(50, TimeUnit.DAYS.SECONDS);

        String[] arrdays = new String[6];

        int c = 2;

        String[] high = new String[6];
        String[] low = new String[6];
        for (int i = 2; i < 6; i++) {

            By day1on24 = By.xpath("//*[@id=\"div7DayForecast\"]/div/div/div[" + c + "]");
            arrdays[i] = driver24.findElement(day1on24).getText();

            int indexy = arrdays[i].lastIndexOf('Y');
            int indexdash = arrdays[i].lastIndexOf('-');
            int indexc = arrdays[i].lastIndexOf('C');

            low[i] = arrdays[i].substring(indexy + 1, indexdash - 3);

            System.out.println("Day " + i + " low : " + low[i]);

            c++;
        }
        return result;
    }


        public String elementHigh()
        {
            String result=null;
            driver24.manage().timeouts().implicitlyWait(50,TimeUnit.DAYS.SECONDS);

            String[] arryhight= new String[6];

            int c=2;

            String[] high=new String[6];
           // String[] low=new String[6];
            for(int i=2;i<6;i++)
            {

                By day1on24 = By.xpath ("//*[@id=\"div7DayForecast\"]/div/div/div["+c+"]");
                arryhight[i]=driver24.findElement(day1on24).getText();

                int indexy =arryhight[i].lastIndexOf('Y');
                int indexdash = arryhight[i].lastIndexOf('-');
                int indexc=arryhight[i].lastIndexOf('C');

                high[i] =arryhight[i].substring(indexdash+1,indexc-2);

                result=("  hight :"+high[i] );

                c++;
            }
            return result;
    }

    public void close24()
    {
        driver24.close();
    }

}
