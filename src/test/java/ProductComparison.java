import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ProductComparison {
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
	@DataProvider
	public Object[][] getData2() throws BiffException, IOException {
		Object[][] data = TestData2(0);
		return data;
	}

	@Test(dataProvider="getData2")
	public void Test1(String str1) throws InterruptedException, IOException {
		dr.findElement(By.xpath("//span[text()='My Account']")).click();
		dr.findElement(By.linkText("Login")).click();

		dr.findElement(By.cssSelector("input#input-email")).sendKeys("thaniisha@gmail.com");

		dr.findElement(By.cssSelector("input#input-password")).sendKeys("1234567");
		dr.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		
		dr.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(str1);
		dr.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(Keys.ENTER);
		dr.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"input-sort\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"input-sort\"]/option[5]")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[3]/i")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[2]/div[2]/button[3]/i")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/div[2]/button[3]/i")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"product-category\"]/div[1]/button")).click();
		dr.findElement(By.xpath("//*[@id=\"compare-total\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[1]/td[2]/a")).click();
		String TestFile = "C:\\Users\\user\\Desktop\\Bas auto test\\ProductFlatfile.txt";
		File FC = new File(TestFile);// Created object of java File class.
		FC.createNewFile();// Create file.

		// Writing In to file.
		// Create Object of java FileWriter and BufferedWriter class.
		FileWriter FW = new FileWriter(TestFile);
		@SuppressWarnings("resource")
		BufferedWriter bf = new BufferedWriter(FW);
		Thread.sleep(2000);
		String sent1=dr.findElement(By.xpath("//*[@id=\"tab-description\"]/ul/li[5]")).getText();
		System.out.println(sent1);
		bf.write(sent1); // Writing In To File.
		// To write next string on new line.
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a")).click();
		if(dr.getPageSource().contains("not in stock!"))
    	{
			TakesScreenshot sr=(TakesScreenshot)dr;
			File sourcefile = sr.getScreenshotAs(OutputType.FILE);
			File d=new File("C:\\Users\\user\\Desktop\\Bas auto test\\pic4.png");
			Files.copy(sourcefile,d);
			System.out.println("Product out of Stock");
		
		
    	}System.out.println("Tested Successfully");
		
	
	}
	public static Object[][] TestData2(int sheetno) throws BiffException, IOException {
		File f = new File("C:\\Users\\user\\Desktop\\Bas auto test\\SearchProd.xls");
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
