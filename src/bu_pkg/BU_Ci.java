package bu_pkg;

//import java.awt.List;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class BU_Ci {
	
//resultEmail remail=new resultEmail();
	String result;	
		public String CiPaBU()
	{
		try
		{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();	
		String url="https://www.policybazaar.com/health-insurance/critical-illness-insurance/";
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
        driver.findElement(By.id("name5")).sendKeys("6767676767");
		
		driver.findElement(By.id("btnHealthStep1")).click();
		
		driver.findElement(By.id("txtName")).sendKeys("Test Test");
		String textToSelect="Gurgaon(NCR)";
		WebElement autoOptions=	driver.findElement(By.id("healthCityPincode"));
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		autoOptions.sendKeys("");
		autoOptions.sendKeys("Gurgaon");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
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
		
	driver.findElement(By.id("btnHealthStep2")).click();
		
		driver.findElement(By.id("btnHealthStep3")).click();
        
		Select SelfAge= new Select(driver.findElement(By.className("chkMemberAge")));
		SelfAge.selectByVisibleText("24 Years");
		
		driver.findElement(By.id("btnHealthStep4")).click();
		
		
    	
		 Thread.sleep(6000);
		 
		String secondurl=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurl);
		 
			if(secondurl.contains("enquiryid="))
			 {
				 System.out.println("Test Pass and Lead created");
				 result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Critical illness Form is working : Test Pass";
				 Thread.sleep(100);
				 //driver.quit();
			 }
			else 
			{
				result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Critical illness Form is not working: Test Fail";
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
