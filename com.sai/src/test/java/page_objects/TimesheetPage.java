package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimesheetPage {
	
	
	private static TimesheetPage timesheetPageInstance=null;
	private TimesheetPage()
	{
		
	}
	public static TimesheetPage getInstance()
	{
		if(timesheetPageInstance==null)
		{
			timesheetPageInstance=new TimesheetPage();
		}
		return timesheetPageInstance;
		
	}
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement EMPLOYEENAME;

	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement VIEW;
	
	@FindBy(xpath="//div[@class='orangehrm-header-container']")
	private WebElement MESSAGE;
	
	
	public void enterEmployeeName(String name)
	{
		EMPLOYEENAME.sendKeys(name);
	}
	
	public void clickView()
	{
		VIEW.click();
	}
	 public String getMessage()
	 {
		 return MESSAGE.getText();
	 }
}
