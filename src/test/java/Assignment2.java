
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;




public class Assignment2 {

	public static WebDriver dr;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://petstore.octoperf.com/");

		dr.findElement(By.linkText("Enter the Store")).click();
		dr.findElement(By.linkText("Sign In")).click();
		dr.findElement(By.linkText("Register Now!")).click();
		
	}
//	
//	
//	@DataProvider
//	public Object[][]getData1() throws BiffException, IOException{
//		Object[][] data=TestData1(0);
//		
//		
//		return data;
//	}
//	
//	@Test(dataProvider="getData1")
//	public void Test2(String id,String password,String repeatedpass,String fn,String ln,String email,String phone,String add1,String add2,String city,String state,String zip,String country) {
//		dr.findElement(By.name("username")).sendKeys(id);
//		dr.findElement(By.name("password")).sendKeys(password);
//		dr.findElement(By.name("repeatedPassword")).sendKeys(repeatedpass);
//		dr.findElement(By.name("account.firstName")).sendKeys(fn);
//		dr.findElement(By.name("account.lastName")).sendKeys(ln);
//		dr.findElement(By.name("account.email")).sendKeys(email);
//		dr.findElement(By.name("account.phone")).sendKeys(phone);
//		dr.findElement(By.name("account.address1")).sendKeys(add1);
//		dr.findElement(By.name("account.address2")).sendKeys(add2);
//		dr.findElement(By.name("account.city")).sendKeys(city);
//		dr.findElement(By.name("account.state")).sendKeys(state);
//		dr.findElement(By.name("account.zip")).sendKeys(zip);
//		dr.findElement(By.name("account.country")).sendKeys(country);
//		dr.findElement(By.xpath("//option[@value='english']")).click();
//		dr.findElement(By.xpath("//option[@value='DOGS']")).click();
//		dr.findElement(By.name("account.listOption")).click();
//		dr.findElement(By.name("account.bannerOption")).click();
//		dr.findElement(By.name("newAccount")).click();
//		dr.close();
//		
//		
//	}
	@Test
	public void signIn() throws InterruptedException
	{
		dr.findElement(By.linkText("Sign In")).click();
		
		dr.findElement(By.xpath("/html/body/div[2]/div/form/p[2]/input[1]")).sendKeys("anitha");
		Thread.sleep(2000);
		dr.findElement(By.xpath("//input[@value='j2ee']")).clear();
		dr.findElement(By.xpath("//input[@value='j2ee']")).sendKeys("sabari1");
		Thread.sleep(2000);
		dr.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Welcome to JpetStore");
		dr.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[1]")).click();
	
		String str=dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[4]/td[2]")).getText();
		dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[4]/td[1]/a")).click();
		System.out.println("The name of the fish is: "+str);
		dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[3]/td[1]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[7]/td/a")).click();
		dr.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input")).clear();
		dr.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input")).sendKeys("3");
		dr.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[1]/input")).click();
		String Str1=dr.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[1]")).getText();
		String sub=Str1.substring(12,17);
		int val=Integer.parseInt(sub);
		System.out.println("The cost of the fish is: "+val);
		dr.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/a")).click();
		dr.findElement(By.xpath("[@type='submit']")).click();
	
	}
	
//	public static Object[][] TestData1(int sheetno) throws BiffException, IOException{
//		File f=new File("C:\\Users\\user\\Desktop\\AccountInformation.xls");
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
}
	


