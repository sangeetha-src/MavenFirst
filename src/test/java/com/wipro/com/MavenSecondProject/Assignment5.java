package com.wipro.com.MavenSecondProject;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class Assignment5 {
	WebDriver dr;

	@Given("^Open chrome and navigate to Jpetstore application$")
	public void open_chrome_and_navigate_to_Jpetstore_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://petstore.octoperf.com/");
		dr.findElement(By.linkText("Enter the Store")).click();
		dr.findElement(By.linkText("Sign In")).click();
	}

	@When("^I enter valid Username aNd password$")
	public void i_enter_valid_Username_aNd_password(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<List<String>> data = arg1.raw();

		dr.findElement(By.xpath("/html/body/div[2]/div/form/p[2]/input[1]")).sendKeys(data.get(1).get(1));// Enter
																											// username
		dr.findElement(By.xpath("//input[@value='j2ee']")).clear();
		dr.findElement(By.xpath("//input[@value='j2ee']")).sendKeys(data.get(2).get(1));// Enter password
		dr.findElement(By.xpath("//input[@value='Login']")).click();// clicking login button
		
	}

	@Then("^I can able to login successfully$")
	public void i_can_able_to_login_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Login successfully");
		String actualUrl = "https://petstore.octoperf.com/actions/Catalog.action";
		String expectedUrl = dr.getCurrentUrl();// After Successfully signedin it will redirect to home page

		assertEquals(expectedUrl, actualUrl);
		System.out.println("Scenario 1 Completed");
	}

	@When("^I put Large AngelFish with Item ID EST-(\\d+) in my cart$")
	public void i_put_Large_AngelFish_with_Item_ID_EST_in_my_cart(int arg1) throws Throwable {

		dr.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[1]")).click();// Select the items
		dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click(); //Selecting product id
		dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();	//Click add to cart
		System.out.println("Scenario 2 Completed");

	}

	@When("^I further proceed to checkout and confirm the item$")
	public void i_further_proceed_to_checkout_and_confirm_the_item() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dr.findElement(By.xpath("//*[@id=\"Cart\"]/a")).click(); 	// Click proceed to checkout
		dr.findElement(By.xpath("/html/body/div[2]/div/form/input")).click(); 	// Click to Continue
		

	}

	@Then("^My Order has been submitted successfully$")
	public void my_Order_has_been_submitted_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dr.findElement(By.xpath("/html/body/div[2]/div[2]/a")).click(); 	// Clicking Confirm button.
		String ActualURL = "https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true";
		String expectedurl = dr.getCurrentUrl();
		assertEquals(ActualURL, expectedurl);
		System.out.println("Submitted my orders");
	}

	@When("^Selecting Amazon Parrot with item id EST-(\\d+) and add to cart$")
	public void selecting_Amazon_Parrot_with_item_id_EST_and_add_to_cart(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dr.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[5]")).click();	// Select the items
		dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();		//selecting product id
	
		dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click(); 	//clicking add to cart
		System.out.println("Scenario 3 Completed");

	}

}
