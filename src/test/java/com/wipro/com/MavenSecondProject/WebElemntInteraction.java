package com.wipro.com.MavenSecondProject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class WebElemntInteraction {

		WebDriver dr;
	    
	    @BeforeMethod
	    public void setup()
	    {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
	        dr= new ChromeDriver();
	      //*[@id="gender-radio-2"]
	        dr.manage().window().maximize();
	        
	        dr.get("https://demoqa.com/automation-practice-form");
	    }
	    @Test
	    public void Test1() throws IOException
	    {
	    	dr.findElement(By.id("firstName")).sendKeys("Sangeetha");
	    	dr.findElement(By.id("lastName")).sendKeys("Selvam");
	    	dr.findElement(By.id("userEmail")).sendKeys("Sangeetha@gmail.com");
	    	dr.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")).click();
	    	dr.findElement(By.id("userNumber")).sendKeys("1223654789");
	    	dr.findElement(By.id("dateOfBirthInput")).sendKeys("06 oct 1998");
	    	dr.findElement(By.xpath("//html/body/div/div/div/div[2]/div[2]/div[1]/form/div[6]/div[2]/div/div/div[1]/div[2]/div/input")).sendKeys("Selenium Training");
	    	
	    	dr.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();
	    	dr.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[8]/div[2]/div/input")).sendKeys("C:\\Users\\user\\Desktop\\tc.PNG");
	    	dr.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("No.43, Co-operative nagar, sakkottai,kumbakonam");
	    	dr.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).click();
	    	dr.findElement(By.xpath("//*[@id=\"react-select-3-option-0\"]")).click();
	    	dr.findElement(By.xpath("//*[@id=\"city\"]/div[1]/div[1]/div[1]")).click();
	    	dr.findElement(By.xpath("//*[@id=\"react-select-4-option-2\"]")).click();
	    	dr.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	    	TakesScreenshot sr=(TakesScreenshot)dr;
			File sourcefile = sr.getScreenshotAs(OutputType.FILE);
			File d=new File("C:\\java\\TestingImages\\pic2.png");
			Files.copy(sourcefile,d);
			
			
			
	    }

	}


