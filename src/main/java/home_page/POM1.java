package home_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM1 
{

	@FindBy(xpath="//input[@name='userId']")private WebElement usernm;
	@FindBy(xpath="//input[@name='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	
	public POM1(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	public void clearuserpom1()
	{
		usernm.clear();
	}
	
	
	public void setuserpom1(String un)
	{
		usernm.sendKeys(un);
	}
	
	public void setpswpom1(String pas)
	{
		password.sendKeys(pas);
	}
	
	public void setclickpom1()
	{
		signin.click();
	}
}
