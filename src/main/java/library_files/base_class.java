package library_files;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import buy_sell_module.POM1;
import buy_sell_module.POM2;
import buy_sell_module.POM3;
import buy_sell_module.POM4;

public class base_class 
{

	public static void browser_URL_POMobj()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rahul Jadhav\\Downloads\\01 Velocity Testing notes\\Selenium app\\chromedriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login-v2.upstox.com/");
		driver.manage().window().maximize();
		POM1 p1=new POM1(driver);
		POM2 p2=new POM2(driver);
		POM3 p3=new POM3(driver);
		POM4 p4=new POM4(driver);
	}
	
}
