package login_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM6_email
{

@FindBy(xpath="//input[@id='user']") private WebElement emailbox;	
@FindBy(xpath="//input[@id='pass']") private WebElement passbox;	
@FindBy(xpath="(//button[@type='submit'])[2]") private WebElement emaillogin;	



public POM6_email(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}



public void loginmail()
{}





	
}
