import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GiftVoucher {
	WebDriver dr;

	@BeforeMethod
	public void setUp() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://demo.opencart.com");
	}
	@DataProvider
	public Object[][] getData2() throws BiffException, IOException {
		Object[][] data = TestData1(0);
		return data;
	}
	@Test(dataProvider="getData2")
	public void Test1(String name,String email,String message,String phone) throws InterruptedException
	{
		dr.findElement(By.xpath("//span[text()='My Account']")).click();
		dr.findElement(By.linkText("Login")).click();

		dr.findElement(By.cssSelector("input#input-email")).sendKeys("thaniisha@gmail.com");

		dr.findElement(By.cssSelector("input#input-password")).sendKeys("1234567");

		Thread.sleep(2000);

		dr.findElement(By.xpath("//input[@value='Login']")).click();
		dr.findElement(By.xpath("/html/body/footer/div/div/div[3]/ul/li[2]/a")).click();//gift certificate
		dr.findElement(By.xpath("//*[@id=\"input-to-name\"]")).sendKeys(name);
		dr.findElement(By.xpath("//*[@id=\"input-to-email\"]")).sendKeys(email);		
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div[5]/div/div[1]/label")).click();	//
		dr.findElement(By.xpath("//*[@id=\"input-message\"]")).sendKeys(message);	
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div[8]/div/input[1]")).click();	//policy
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div[8]/div/input[2]")).click();	//continue
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();//continue
		dr.findElement(By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a")).click();//Contact us
		dr.findElement(By.xpath("//*[@id=\"input-enquiry\"]")).sendKeys("This is of change of address or phone number");//enquires
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();//submit
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();//Continue
		dr.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[3]/a")).click();//wishlist
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();//Continue
		dr.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();//Edit profile
		dr.findElement(By.xpath("//*[@id=\"input-telephone\"]")).clear();//telephone
		dr.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(phone);//telephone
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();//Continue
		dr.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).click();//Logout
	
	
	}
	public static Object[][] TestData1(int sheetno) throws BiffException, IOException {
		File f = new File("C:\\Users\\user\\Desktop\\Bas auto test\\flatexcel.xls");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet(sheetno);
		int rows = s.getRows();
		int col = s.getColumns();
		Object[][] data1 = new Object[rows][col];
		int k = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {

				Cell c = s.getCell(j, i);
				data1[k][j] = c.getContents().toString();

			}
			k++;
		}
		return data1;

	}


}
