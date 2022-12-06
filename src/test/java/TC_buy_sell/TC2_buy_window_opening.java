package TC_buy_sell;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import buy_sell_module.POM1;
import buy_sell_module.POM2;
import buy_sell_module.POM3;
import buy_sell_module.POM4;

public class TC2_buy_window_opening
{

	//Before class: to open the browser
	  //Before method: to login upstox
		//@test: verify the user
		//After method:logout
		//After class:close the browser
		WebDriver driver;
		POM1 p1;
		POM2 p2;
		POM3 p3;
		POM4 p4;
		FileInputStream f;
		Sheet sh;
		
//@Parameters("browsername")
@BeforeClass
public void openbrowser() throws EncryptedDocumentException, IOException, InterruptedException
		{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Rahul Jadhav\\Downloads\\01 Velocity Testing notes\\Selenium app\\chromedriver.exe" );
	driver=new ChromeDriver();
	
//if(browsername.equals("chrome"))
//{
//System.setProperty("webdriver.chrome.driver","C:\\Users\\Rahul Jadhav\\Downloads\\01 Velocity Testing notes\\Selenium app\\chromedriver.exe" );
//driver=new ChromeDriver();
//}
//			
//else if(browsername.equals("firefox"))
//{
//System.setProperty("webdriver.gecko.driver","C:\\Users\\Rahul Jadhav\\Downloads\\01 Velocity Testing notes\\Selenium app\\geckodriver.exe" );
//driver=new FirefoxDriver();
//}
//
//else if(browsername.equals("edge"))
//{
//System.setProperty("webdriver.edge.driver","C:\\Users\\Rahul Jadhav\\Downloads\\01 Velocity Testing notes\\Selenium app\\msedgedriver.exe" );
//driver=new EdgeDriver();
//}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://login-v2.upstox.com/");
			driver.manage().window().maximize();
			//To create object of pom classes
			//so that we can access the methods from POM class throughout the test class
			p1=new POM1(driver);
			p2=new POM2(driver);
			p3=new POM3(driver);
			p4=new POM4(driver);
			f=new FileInputStream("C:\\Users\\Rahul Jadhav\\Desktop\\Upstox TEST DATA.xlsx");
			sh = WorkbookFactory.create(f).getSheet("Login1");
			

		}
		
		@BeforeMethod
		public void login() throws InterruptedException
		{
//login
			String un = sh.getRow(1).getCell(0).getStringCellValue();
			p1.setuserpom1(un);
			String p = sh.getRow(1).getCell(1).getStringCellValue();
			p1.setpswpom1(p);
			p1.setclickpom1();
			Thread.sleep(3000);
			
			String pc = sh.getRow(1).getCell(2).getStringCellValue();
			p2.pascode(pc);
			p3.wlcmpage();	 
			
			
		}
	
//TC
		@Test
		public void verify_buywindow_opening()
		{
			p4.tatachem();
			p4.gridclick();
			p4.buyclick();
			
			String actual = p4.tatatext();
			String expected=sh.getRow(1).getCell(4).getStringCellValue();
			Assert.assertEquals(actual, expected);
			Reporter.log("actual and exp share name is same",true);
			
			boolean resultb=p4.buyenable();
			Assert.assertTrue(resultb);
			Reporter.log("buy button is enabled",true);
			
		}
		

		@AfterMethod
		public void logout()
		{
//logout
			p4.dropdwn();
		    p4.clicklogout();  
		    }
	
@AfterClass
public void closebrowser()
		{

//close current tab
			driver.close();
//all global variable make null		    
		    p1=null;
		    p2=null;
		    p3=null;
		    p4=null;
		    driver=null;
		    f=null;
		    sh=null;

		}
	
}