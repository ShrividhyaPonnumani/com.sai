package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import constants.Constants;
import webdriver_manager.DriverManager;
import page_objects.DirectoryPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import utilities.CommonUtils;

public class VerifyCEOName_Step_Def {

	

	private static final Logger LOGGER=LogManager.getLogger(VerifyCEOName_Step_Def.class);

	@Given("the user is logged in successfully and is on Home Page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() throws InterruptedException {
		try {
	   //login
		DriverManager.getDriver().get(Constants.APP_URL);

		Thread.sleep(2000);
		
		LoginPage.getInstance().enterUserName(Constants.USERNAME);
		LoginPage.getInstance().enterPassword(Constants.PASSWORD);
		LoginPage.getInstance().clickLoginButton();

		String url=DriverManager.getDriver().getCurrentUrl();
		if(url.contains("dashboard"))
		{
			LOGGER.info("the user is logged in succesfully the home page");
		}
		
		}
		catch(Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
		
	}

	@When("the user clicks on the directory option from the Menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() throws InterruptedException {
		try
		{
		Thread.sleep(2000);
		HomePage.getInstance().clickDirectory();
	    LOGGER.info("the user clicks on the directory option from the Menu bar");
	}
        catch(Exception e)
		{
        	LOGGER.error(e);
        	CommonUtils.getInstance().takeScreenshot();
		}
	}
		
	@When("the user selects the job titles as {string} from the drop down")
	public void the_user_selects_the_job_titles_as_from_the_drop_down(String jobTitle) throws InterruptedException {
		try
		{
		Thread.sleep(2000);
		DirectoryPage.getInstance().selectJobTitle();
		Thread.sleep(2000);
		DirectoryPage.getInstance().chooseElement();
	    LOGGER.info("the user selects the job titles as {string} from the drop down");
	}
		catch(Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
		}

	@When("clicks the search button")
	public void clicks_the_search_button() throws InterruptedException {
		try
		{
		Thread.sleep(2000);

		DirectoryPage.getInstance().clickSearch();
	    LOGGER.info("clicks the search button");
	}
		catch(Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}
		

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedName) throws InterruptedException {
		try
		{
		Thread.sleep(2000);
		
		String actualName=DirectoryPage.getInstance().getName();
		if(actualName.equalsIgnoreCase(expectedName))
		{
			LOGGER.info("the user should see the CEO name as No Records Found");	
		}
	    
	}
		catch(Exception e)
		{
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}

	}
