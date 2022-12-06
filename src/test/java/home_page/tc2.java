package home_page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import buy_sell_module.POM1;
import buy_sell_module.POM2;
import buy_sell_module.POM3;
import buy_sell_module.POM4;

public class tc2 
{
	WebDriver driver;
	POM1 p1;
	POM2 p2;
	POM3 p3;
	POM4 p4;
	FileInputStream f;
	Sheet sh;
	
	
	@BeforeClass
	public  void open() throws EncryptedDocumentException, IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rahul Jadhav\\Downloads\\01 Velocity Testing notes\\Selenium app\\chromedriver.exe" );
		driver=new ChromeDriver();
		
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
	//login
		String un = sh.getRow(1).getCell(0).getStringCellValue();
		p1.setuserpom1(un);
		String p = sh.getRow(1).getCell(1).getStringCellValue();
		p1.setpswpom1(p);
		p1.setclickpom1();
		String pc = sh.getRow(1).getCell(2).getStringCellValue();
		p2.pascode(pc);
		p3.wlcmpage();
		
	}
	
	
	@Test
	public void verify_added_share()
	{
		driver.findElement(By.xpath("(//button[@data-testid='button'])[3]")).click();
		driver.findElement(By.xpath("//input[@data-id='scripSearchInput']")).sendKeys("tata");
		driver.findElement(By.xpath("(//div[@id='scripResult'])[2]/div[2]")).click(); // add 2nd from list=TATACOFFEE

//every neww added element will appear 1st on list
		String tatacoffee = driver.findElement(By.xpath("//div[@style='position: relative;']/div[1]")).getText();
		String expected= "TATACOFFEE";
		Assert.assertEquals(tatacoffee, expected);
		Reporter.log("selected stock added in watchlist", true);
	}
	
	
@AfterClass
public void closebrowser()
{
	//logout
		p4.dropdwn();
	    p4.clicklogout();  
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
