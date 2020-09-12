package com.wipro.com.MavenSecondProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;



import cucumber.api.java.en.*;

public class BDD {
	public static WebDriver dr;
	@BeforeMethod
	@Given("^Open chrome and strat the application$")
	public void open_chrome_and_strat_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://in.linkedin.com/");
	}

	@When("^Enter valid credentials$")
	public void enter_valid_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		dr.findElement(By.xpath("/html/body/nav/a[3]")).click();
		dr.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sangeetha61098@gmail.com");
		dr.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Tcsworld@11");
		dr.findElement(By.xpath("//*[@id=\"app__container\"]/main/div[2]/form/div[3]/button")).click();
	}

	@Then("^Users can able to login successfully\\.$")
	public void users_can_able_to_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Login Successfully");
	}
		
	
}
