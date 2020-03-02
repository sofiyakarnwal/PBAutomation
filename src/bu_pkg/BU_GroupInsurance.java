package bu_pkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BU_GroupInsurance {
	
	String result;
	public String SmeBU()
	{
		try
		{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();	
		String url="https://www.policybazaar.com/group-insurance/";
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
		Select InsPolicy= new Select(driver.findElement(By.id("healthsmeOption")));
		InsPolicy.selectByVisibleText("Group Health Insurance");
		driver.findElement(By.id("healthsmeCompanyname")).sendKeys("ABC");
		Select Gender= new Select(driver.findElement(By.id("healthsmeGender")));
		Gender.selectByVisibleText("Ms.");
		driver.findElement(By.id("healthsmeContactPerson")).sendKeys("Test Agent");
		driver.findElement(By.id("healthsmeMobile")).sendKeys("6767676767");
		driver.findElement(By.id("healthsmeEmail")).sendKeys("test@gmail.com");
		
		String textToSelect="Noida";
		WebElement autoOptions=	driver.findElement(By.id("healthsmeCityPincode"));
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
		driver.findElement(By.id("btnSubmitHealthsme")).click();
		 Thread.sleep(6000);
		 String secondurl=driver.getCurrentUrl();
		 System.out.println("URL after Proceed Button click is : " + secondurl);
		 
			if(secondurl.contains("sme.policybazaar.com"))
			 {
				 System.out.println("Test Pass and Lead created");
				  result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Sme Form is working : Test Pass";
				 Thread.sleep(600);
				 //driver.quit();
			 }
			else 
			{
				
				System.out.println("Test Fail and unable to create lead");
				result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Sme Form is not working: Test Fail" ;
			}
			
		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(result);
	}

}
