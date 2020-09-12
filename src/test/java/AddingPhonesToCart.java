import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingPhonesToCart {
	WebDriver dr;

	@BeforeMethod
	public void setUp() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://demo.opencart.com");
	}
	@Test
	public void Test1() throws InterruptedException {
		dr.findElement(By.xpath("//span[text()='My Account']")).click();
		dr.findElement(By.linkText("Login")).click();

		dr.findElement(By.cssSelector("input#input-email")).sendKeys("thaniisha@gmail.com");

		dr.findElement(By.cssSelector("input#input-password")).sendKeys("1234567");

		Thread.sleep(2000);

		dr.findElement(By.xpath("//input[@value='Login']")).click();
		dr.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a")).click();// homepage
		dr.findElement(By.xpath("//*[@id=\"slideshow0\"]/div/div[2]/a/img")).click();//clicking adv
		dr.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();//clicking add to cart
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]/a[2]")).click();//clicking shopping cart
		dr.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();//estimate tax
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-zone\"]")).click();//STATE
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-zone\"]/option[68]")).click();// selecting state
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-postcode\"]")).sendKeys("612 401");//postcode
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();//get qoates
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")).click();
		dr.findElement(By.xpath("//*[@id=\"button-shipping\"]")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")).click();//use coupon code
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"input-coupon\"]")).sendKeys("457");//random coupon
		dr.findElement(By.xpath("//*[@id=\"button-coupon\"]")).click();//Apply coupon
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();//my account
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();//logout
		dr.close();
	}
}
