package buy_sell_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM3
{
@FindBy(xpath="//div[text()='No, I’m good']") private WebElement welcome;


public	POM3(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public void wlcmpage()
	{
		welcome.click();
	}
	
	
}
