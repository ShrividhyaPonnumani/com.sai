package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage;
import page_objects.TimesheetPage;
import utilities.CommonUtils;
import webdriver_manager.DriverManager;

public class Verify_Pending_timesheets_step_def {
	private static Logger LOGGER=LogManager.getLogger();
	
	@Given("the user is on homepage")
	public void the_user_is_on_homepage() {
		try
		{
		String url=DriverManager.getDriver().getCurrentUrl();
		if(url.contains("dashboard"))
		{
			LOGGER.info("the user is on homepage");
		}
		}
		catch (Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	 }

	@When("the user clicks on time option from the menu")
	public void the_user_clicks_on_time_option_from_the_menu() throws InterruptedException {
		try
		{
		Thread.sleep(2000);
		HomePage.getInstance().clickTime();
		}
		catch (Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	    
	}

	@When("the user enters the name as {string}")
	public void the_user_enters_the_name_as(String name) throws InterruptedException {
		try
		{
		Thread.sleep(2000);
		TimesheetPage.getInstance().enterEmployeeName(name);
		}
		catch (Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
 
	}

	@When("clicks on the view button")
	public void clicks_on_the_view_button() throws InterruptedException {
		try {
		Thread.sleep(2000);
	   TimesheetPage.getInstance().clickView();
		}
		catch (Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
		
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expectedMessage) throws InterruptedException {
		try
		{
		Thread.sleep(2000);
		String actualMessage=TimesheetPage.getInstance().getMessage();
		if(expectedMessage.equals(actualMessage))
		{
			LOGGER.info("expected message is seen");
		}
		}
		catch (Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
		
	}


}
