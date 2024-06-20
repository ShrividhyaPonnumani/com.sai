package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {
	
	private static DirectoryPage directoryPageInstance;
	private DirectoryPage()
	{
		
	}
	public static DirectoryPage getInstance()
	{
		if(directoryPageInstance==null)
		{
			directoryPageInstance=new DirectoryPage();
		}
		return directoryPageInstance;
	}
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
	private WebElement JOB_TITLE;
	
	@FindBy(xpath="//*[text()='Chief Executive Officer']")
	private WebElement CHOOSE;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement SEARCH;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement Name;

	
	public void selectJobTitle()
	{
		JOB_TITLE.click();
	}
	public void chooseElement()
	{
		 CHOOSE.click();
	}
	public void clickSearch()
	{
		SEARCH.click();
	}
	public String getName()
	{
		return Name.getText();
	}
}
