package com.wipro.com.MavenSecondProject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class MouseHover {
	public static WebDriver dr;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.google.com/");
		
	}
	@Test
	public void Test1() throws IOException, InterruptedException {
		dr.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("guru 99");
		 dr.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER); 

//		dr.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]")).click();
		dr.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
		Actions actions = new Actions(dr);
    	WebElement menuOption = dr.findElement(By.xpath("//*[@id=\"menu-3688-particle\"]/nav/ul/li[2]/div/span[1]/span"));
    	actions.moveToElement(menuOption).perform();
//    	WebElement subMenuOption = dr.findElement(By.xpath("//*[@id=\"menu-3688-particle\"]/nav/ul/li[2]/ul/li/div/div[3]/ul/li[5]/a/span/span"));
//    	actions.moveToElement(subMenuOption).perform();
    	 dr.findElement(By.xpath("//*[@id=\"menu-3688-particle\"]/nav/ul/li[2]/ul/li/div/div[3]/ul/li[5]/a/span/span")).click();
    	 Thread.sleep(2000);
    	 Thread.sleep(2000);
    	TakesScreenshot sr=(TakesScreenshot)dr;
		File sourcefile = sr.getScreenshotAs(OutputType.FILE);
		File d=new File("C:\\java\\TestingImages\\pic3.png");
		Files.copy(sourcefile,d);
	



	}

}
