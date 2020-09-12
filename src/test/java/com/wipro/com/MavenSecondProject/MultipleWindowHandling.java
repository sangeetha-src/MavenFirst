package com.wipro.com.MavenSecondProject;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class MultipleWindowHandling {
	WebDriver dr;
    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        dr= new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("http://demo.automationtesting.in/Windows.html");
    }
    @Test
    public void Test1() throws InterruptedException
    {
    	String oldTab = dr.getWindowHandle();
    	dr.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
    	if(dr.getPageSource().contains("www.sakinalium.in"))
    	{
    		System.out.println("Title is present");
    	}
    	else
    	{
    		System.out.println("Title not Present");
    	}
    	 ArrayList<String> newTab = new ArrayList<String>(dr.getWindowHandles());
         newTab.remove(oldTab);
         // change focus to new tab
         dr.switchTo().window(newTab.get(0));
         // change focus back to old tab
         dr.switchTo().window(oldTab);
    	dr.findElement(By.linkText("Open New Seperate Windows")).click();
    	dr.findElement(By.xpath("//*[@id=\"Seperate\"]/button")).click();
        Set<String> winId = dr.getWindowHandles();
        Thread.sleep(2000);
    	if (winId.size() > 1)
        {
           System.out.println("New window has been opened.");
        }
    	dr.close();
    	dr.quit();
    }
}

