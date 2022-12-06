package login_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM4 
{
//find valid user
	@FindBy(xpath="(//span[@class='_3YI_lRyLDAFhz2WE-6yGuX'])[2]")private WebElement usern;
//find dropdown of logout
	@FindBy(xpath="//div[@data-id='accountDropDown']")private WebElement dropdown;
//find logout option
	@FindBy(xpath="(//div[@data-testid='dropdown-option'])[2]")private WebElement logoutupstox;

	
	//constructor
	public POM4(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//TC1	
	public String verifyusnm()
	{
		return usern.getText();
	}

//logout steps
	public void dropdwn() 
	{
		dropdown.click();
		
	}

	public WebElement movetologout()  
	//Webelement logoutbutton=d.findElement(By.xpath(""));
	//Actions class object:a
	//a.movetoElement(logoutbutton).click().perform();
	{
		return logoutupstox;
		
	}
	//here no need of movetoelement method,thats why direct click action
	public void clicklogout()
	{
		logoutupstox.click();
	}
	
	
	
	
	
}
