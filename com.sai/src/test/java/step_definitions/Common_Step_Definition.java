package step_definitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.Constants;
import utilities.CommonUtils;
import webdriver_manager.DriverManager;

import io.cucumber.java.Before;
import io.cucumber.messages.types.Scenario;

public class Common_Step_Definition {
	
	private static String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
	}
	
	private static final Logger LOGGER=LogManager.getLogger(Common_Step_Definition.class);
	@Before
	public void beforeScenario(Scenario scenario)
	{
		LOGGER.info("Execution started");
		try
		{
			scenarioName=scenario.getName();
			LOGGER.info("Instantiating the CommonUtils");
			LOGGER.info("Loading the properties file");
			CommonUtils.getInstance().loadProperties();;
			LOGGER.info("Checking the driver is null or not");
			if(DriverManager.getDriver()==null)
			{
			LOGGER.info("Driver is Null, Instantiating the browser");
			DriverManager.launchBrowser();
			CommonUtils.getInstance().initWebElements();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	


}
	
