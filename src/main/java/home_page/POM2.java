package home_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM2 
{

	@FindBy(xpath="//input[@type='text']")private WebElement passcode;
	
	public POM2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void pascode(String pc)
	{
		passcode.sendKeys(pc);
	}
	
	
}
