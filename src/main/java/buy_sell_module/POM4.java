package buy_sell_module;

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
//find watchlist
	@FindBy(xpath="//div[@id='watchlistSelect']")private WebElement Watchlist;
//find indices companies
	@FindBy(xpath="//div[text()='Indices']")private WebElement indices;
//find first company
	@FindBy(xpath="(//div[@class='F9Jx2Z1yb6NPapDPIxxhQ 127m3JFg0WYtmrQh3-5-c'])[1]")private WebElement cmpnylist;
	
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
	
	
//TC 2 steps to open buy window
	public void tatachem()
	{
		TATACHEM.click();
	}
	public void gridclick()
	{
		grid.click();
	}
	public void buyclick()
	{
		buybutton.click();
	}
	public String tatatext()
	{
		String share = tatachemtext.getText();
		return share;
	}
	public boolean buyenable()
	{
		boolean b = buyenable.isEnabled();
		return b;
	}
	
//TC3 check quantity textbox
	public void qtyclear()
	{
		qtybox.clear();
		}
	public void qtysendkey(String qty)
	{
		qtybox.sendKeys(qty);
	}
	public void buyorder() 
	{
		buyorder.click();
	}
	public void returntobuyorder()
	{
		returntobuyorder.click();
	}
		
public boolean placeorderisdisplayed()
		{
		boolean	dis=placeorder.isDisplayed();
		return dis;	
		}
	
	
//next tc	
	public void watchL()
	{
		Watchlist.click();
	}

	public void indic()
	{
		indices.click();
	}

	public boolean clist()
	{
		boolean c = cmpnylist.isDisplayed();
		return c;
	}
	
	
	
	
	
}
