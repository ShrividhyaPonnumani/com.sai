package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private static LoginPage loginInstance;
	private LoginPage()
	{
		
	}
	public static LoginPage getInstance()
	{	 
		if(loginInstance==null) {
		loginInstance=new LoginPage();
	}
	return loginInstance;
	}
	@FindBy(name="username")
	private WebElement USERNAME;
	
	@FindBy(name="password")
	private WebElement PASSWORD;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement LOGIN_BUTTON;

	
    public void enterUserName(String userName)
    {
    	USERNAME.sendKeys(userName);
    }
    public void enterPassword(String password)
    {
    	PASSWORD.sendKeys(password);
    }
    public void clickLoginButton()
    {
    	LOGIN_BUTTON.click();
    }
	
	

}
