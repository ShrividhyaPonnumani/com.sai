package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private static HomePage homePageInstance;
	private HomePage()
	{
		
	}
	public static HomePage getInstance()
	{	
	if(homePageInstance==null)
	{
		 homePageInstance=new HomePage();
	}
	return homePageInstance;
	}
	
	@FindBy(xpath="//span[text()='Directory']")
	private WebElement DIRECTORY;

	@FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[4]")
	private WebElement TIME;
	
	public void clickDirectory()
	{
		DIRECTORY.click();
	}

	public void clickTime()
	{
		TIME.click();
	}
}
