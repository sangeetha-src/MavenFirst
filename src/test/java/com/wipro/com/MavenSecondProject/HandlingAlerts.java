package com.wipro.com.MavenSecondProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class HandlingAlerts {
	WebDriver dr;
    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        dr= new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("http://demo.automationtesting.in/Alerts.html");
    }
    @Test
    public void Test1(){
    	dr.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
    	String str=dr.switchTo().alert().getText();
    	System.out.println(str);
    	dr.switchTo().alert().accept();
    	dr.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
    	dr.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
    	String str1=dr.switchTo().alert().getText();
    	System.out.println(str1);
    	dr.switchTo().alert().accept();
    	dr.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
    	dr.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
    	dr.switchTo().alert().sendKeys("Tester");
    	dr.switchTo().alert().accept();
    	if(dr.getPageSource().contains("Hello Tester How are you today"))
    	{
    		System.out.println("Displayed");
    	}
    	else
    	{
    		System.out.println("Not Displayed");
    	}
    }
}
    	
