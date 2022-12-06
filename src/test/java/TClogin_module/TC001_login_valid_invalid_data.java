package TClogin_module;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import buy_sell_module.POM1;
import buy_sell_module.POM2;
import buy_sell_module.POM3;
import buy_sell_module.POM4;
import library_files.base_class;

public class TC001_login_valid_invalid_data 
{
	WebDriver driver;
	POM1 p1;
	POM2 p2;
	POM3 p3;
	POM4 p4;
	@BeforeClass
	public void openbrowser()
	{
		base_class.browser_URL_POMobj();
	}
	
	@Test(dataProvider="testdata")
	public void login(String user, String pwd, String pc, String datatype) throws IOException
	{
		p1.clearuserpom1();
		p1.setuserpom1(user);
		p1.setpswpom1(pwd);
		p1.setclickpom1();
		p2.pascode(pc);
		
	}
	
	@DataProvider(name="testdata")
	public static String[][] data()
	{
		String [][] values= {{"FB0685","Mayur@1234","1997","valid"},
				              {"FB0685","Mayur@1234","1997","valid"},
				              {"FB0685","Mayur@1234","1997","valid"}
				              };
		return values;
	}
	

}
