package home_page;

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
//find tatachem share
	@FindBy(xpath="(//div[@data-type='container'])[3]") private WebElement TATACHEM;
//find grid button	
	@FindBy(xpath="//div[@class='_3AOrvIRXpzbdPrcTdELjJO']") private WebElement grid;
//find buy button
	@FindBy(xpath="//div[@id='chartMenuBuy_title']") private WebElement buybutton;
//find tatachem share name
	@FindBy(xpath="//span[@data-id='scripName']") private WebElement tatachemtext;
//find buy enable
	@FindBy(xpath="(//button[@type='button'])[9]") private WebElement buyenable;
//find sell 
	@FindBy(xpath="(//button[@type='button'])[10]") private WebElement sellntenable;
	
@FindBy(xpath="//input[@data-id='Quantity']") private WebElement qtybox;
		@FindBy(xpath="(//button[@data-testid='button'])[11]") private WebElement buyorder;
		@FindBy(xpath="//div[@data-id='backToOrderForm']") private WebElement returntobuyorder;
		@FindBy(xpath="(//button[@data-testid='button'])[9]") private WebElement placeorder;

	
	//find round button
	@FindBy(xpath="(//button[@data-testid='button'])[3]") private WebElement roundbtn;
	@FindBy(xpath="//input[@data-id='scripSearchInput']") private WebElement searchbox;
	@FindBy(xpath="(//div[@id='scripResult'])[2]/div[2]") private WebElement addbtn;
	
	//constructor
	public POM4(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//TC1	
	public String verifyusnm()
	{
		return usern.getText();
		
//		boolean result = actid.equals(expid);
	//	
//		if(result=true)
//		{
//			System.out.println("Pass:valid user");
//		}
//		else
//		{
//			System.out.println("Fail:invalid user");
//		}
	}

//logout steps
	public void dropdwn() 
	{
		dropdown.click();
		
	}

	//click roundbtn
	public void clickroundbuton() 
	{
		roundbtn.click();
		
	}
	//searchbox sendkey
	public void sendkeysearchbox() 
	{
		searchbox.sendKeys("tata");
    }
	//addbtn click
		public void addbtnclick() 
		{
			addbtn.click();
	    }
	
	
	
	
}
