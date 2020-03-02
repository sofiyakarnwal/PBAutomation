package bu_pkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BU_Pa {

	String result;	
	public String PaBU()
{
	try
	{
	System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
	WebDriver driver= new FirefoxDriver();	
	String url="https://www.policybazaar.com/health-insurance/personal-accident-insurance/";
	driver.get(url);
	String firsturl=driver.getCurrentUrl();
	System.out.println("Tested URL is: " + firsturl);
	
	Select Gender=new Select(driver.findElement(By.id("termGender")));
	Gender.selectByVisibleText("Ms.");
	driver.findElement(By.id("termName")).sendKeys("Test Agent");
	driver.findElement(By.id("termMobile")).sendKeys("7878787878");
	driver.findElement(By.id("termEmail")).sendKeys("test@gmail.com");
	
	String textToSelect= "Noida(NCR)";
	WebElement autoOptions=driver.findElement(By.id("termCity"));
	autoOptions.sendKeys("Noida");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement ul_element=driver.findElement(By.id("ui-id-1"));
	List<WebElement> li_element=ul_element.findElements(By.className("ui-menu-item"));
	for(WebElement option : li_element)
	{
		System.out.println(option);
	    if(option.getText().equals(textToSelect)) 
	    {
	    	System.out.println("Trying to select: "+textToSelect);
	    	option.click();
	    	break;
	    }
	}
	
    
	driver.findElement(By.id("btnSubmitCritical")).click();
	
	 Thread.sleep(6000);
	 
	String secondurl=driver.getCurrentUrl();
	 System.out.println("URL after Submit Button click is : " + secondurl);
	 
		if(secondurl.contains("cipainsurance.policybazaar.com/health-insurance/personal-accident-insurance.aspx"))
		 {
			 System.out.println("Test Pass and Lead created");
			 result="Personal Accident Form is working : Test Pass";
			 Thread.sleep(100);
			 //driver.quit();
		 }
		else 
		{
			result="Personal Accident Form is not working: Test Fail";
			System.out.println("Test Fail and unable to create lead");
			
		}
	
	
	}
	catch(Exception exc) 
	{
		exc.printStackTrace();
	}
	return(result);
}


	
}
