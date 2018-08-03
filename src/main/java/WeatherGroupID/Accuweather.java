package WeatherGroupID;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Accuweather {

    WebDriver driverAcu;

      public void conAccu()
    {
        System.setProperty("webdriver.chrome.driver","C:\\accuweather\\chromedriver.exe");
        driverAcu = new ChromeDriver();
        String baseUrl = "https://www.accuweather.com/en/za/durban/305605/daily-weather-forecast/305605";
        driverAcu.get(baseUrl);

    }

    public String accuelow() {

        String result = null;
        driverAcu.manage().timeouts().implicitlyWait(120, TimeUnit.DAYS.SECONDS);

        String[] arrdays = new String[6];
        int c = 2;

        List<WebElement> row = driverAcu.findElements(By.xpath("//*[@id='panel-main']/div[2]/div/div/div[2]/ul/li"));

        String[] days = new String[5];


        for (int i = 0; i < 4; i++) {
            days[i] = row.get(i + 1).findElement(By.className("small-temp")).getAttribute("innerHTML");
             result="low : " + days[i].substring(1, days[i].length() - 1);
            }
        return result;
    }

       public String accueHigh()
        {
            String result=null;
            driverAcu.manage().timeouts().implicitlyWait(120,TimeUnit.DAYS.SECONDS);

            String[] arrdays= new String[6];


            List<WebElement> row =driverAcu.findElements(By.xpath ("//*[@id='panel-main']/div[2]/div/div/div[2]/ul/li"));

            String[] daysHigh = new String[5];

            for(int i=0;i<4;i++)
            {
                daysHigh[i]=row.get(i+1).findElement(By.className("large-temp")).getAttribute("innerHTML");

              result= ("hight : "+daysHigh[i].substring(0,daysHigh[i].length()-1));
            }
            return result;
    }

    public void closeacc() {
        driverAcu.close();
    }
}
