import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

public class OpenCartRegistrationAndAddToCart {
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

//	@DataProvider
//	public Object[][]getData1() throws BiffException, IOException{
//		Object[][] data=TestData1(0);
//		
//		
//		return data;
//	}
	@DataProvider
	public Object[][] getData2() throws BiffException, IOException {
		Object[][] data = TestData2(0);
		return data;
	}

//	@Test(dataProvider="getData1" ,priority=1)
//	public void Registration(String fn,String ln,String email,String phone,String pass,String confirmpass)
//	{
//		dr.findElement(By.xpath("//span[text()='My Account']")).click();
//		dr.findElement(By.linkText("Register")).click();
//		dr.findElement(By.name("firstname")).sendKeys(fn);
//		dr.findElement(By.name("lastname")).sendKeys(ln);
//		dr.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
//		dr.findElement(By.name("telephone")).sendKeys(phone);
//		dr.findElement(By.name("password")).sendKeys(pass);
//		dr.findElement(By.name("confirm")).sendKeys(confirmpass);
//		dr.findElement(By.xpath("//input[@value='0']")).click();
//		dr.findElement(By.xpath("//input[@type='checkbox']")).click();
//		dr.findElement(By.xpath("//input[@value='Continue']")).click();
//		dr.findElement(By.xpath("//*[@id=\"content\"]/p[4]/a")).click();
//		dr.findElement(By.xpath("//*[@id=\"input-enquiry\"]")).sendKeys("My new number is 9659753462");
//		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
//		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
//	}
	@Test(dataProvider = "getData2", priority = 2)
	public void AddToCart(String name, String Reviews) throws InterruptedException, IOException {
		dr.findElement(By.xpath("//span[text()='My Account']")).click();
		dr.findElement(By.linkText("Login")).click();

		dr.findElement(By.cssSelector("input#input-email")).sendKeys("thaniisha@gmail.com");

		dr.findElement(By.cssSelector("input#input-password")).sendKeys("1234567");

		Thread.sleep(2000);

		dr.findElement(By.xpath("//input[@value='Login']")).click();
		dr.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a")).click();// homepage
		dr.findElement(By.xpath("//*[@id=\"slideshow0\"]/div/div[2]/a/img")).click();//clicking adv
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"input-name\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"input-name\"]")).sendKeys(name);
		dr.findElement(By.xpath("//*[@id=\"input-review\"]")).sendKeys(Reviews);
		dr.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[2]")).click(); // ratings
		dr.findElement(By.xpath("//*[@id=\"button-review\"]")).click(); // lick Continue
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]/i")).click();// Wishlist
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]/button")).click();// Closing option
		dr.findElement(By.xpath("//*[@id=\"wishlist-total\"]/i")).click();
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button")).click();
		Thread.sleep(2000);
		String TestFile = "C:\\Users\\user\\Desktop\\Bas auto test\\FlatFile.txt";
		File FC = new File(TestFile);// Created object of java File class.
		FC.createNewFile();// Create file.

		// Writing In to file.
		// Create Object of java FileWriter and BufferedWriter class.
		FileWriter FW = new FileWriter(TestFile);
		BufferedWriter BW = new BufferedWriter(FW);
		String str = dr.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/table/tbody/tr/td[5]/div")).getText();
		System.out.println(str);
		BW.write(str); // Writing In To File.
		BW.newLine();// To write next string on new line.
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i")).click();
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button")).click();
		String str1 = dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]/div")).getText();
		BW.write(str1);
		BW.newLine();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/i")).click();
		dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button")).click();
		String str2 = dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[5]/div")).getText();
		BW.write(str2);
		BW.close();
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")).click();// clicking Add to cart
		Thread.sleep(2000);
		dr.findElement(By.xpath("/html/body/div[2]/div[1]/button")).click();	//closing tab
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")).click();//
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		dr.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).click();
	}

//	public static Object[][] TestData1(int sheetno) throws BiffException, IOException{
//		File f=new File("C:\\Users\\user\\Desktop\\Bas auto test\\RegistrationDetails.xls");
//		Workbook w=Workbook.getWorkbook(f);
//		Sheet s=w.getSheet(sheetno);
//		int rows=s.getRows();
//		int col=s.getColumns();
//		Object[][] data1=new Object[rows][col];
//		int k=0;
//		
//		for(int i=0;i<rows;i++)
//		{
//			for(int j=0;j<col;j++)
//			{
//				
//				Cell c=s.getCell(j,i);
//				data1[k][j]=c.getContents().toString();
//			
//			}
//			k++;
//		}
//		return data1;
//		
//		
//	}
	public static Object[][] TestData2(int sheetno) throws BiffException, IOException {
		File f = new File("C:\\Users\\user\\Desktop\\Bas auto test\\ReviewsProduct.xls");
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
