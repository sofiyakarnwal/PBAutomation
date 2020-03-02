package bu_pkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class BU_Health {
	
	
	String result;
	
	public String HealthBU()
	{
		try
		{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();	
		String url="https://www.policybazaar.com/health-insurance/health-insurance-india/";
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
        driver.findElement(By.id("name5")).sendKeys("6767676760");
		
		driver.findElement(By.id("btnHealthStep1")).click();
		/*
		  List<WebElement> oRadioBtn=driver.findElements(By.name("radio-group-gender"));
		if(true)
		{
			oRadioBtn.get(1).click();
			
		}
		else 
			oRadioBtn.get(0).click();*/
		
		//driver.findElement(By.linkText("Female")).click();
		
		driver.findElement(By.id("txtName")).sendKeys("Test Test");
		String textToSelect="Gurgaon(NCR)";
		WebElement autoOptions=	driver.findElement(By.id("healthCityPincode"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
		
		 Thread.sleep(600);
		
	driver.findElement(By.id("btnHealthStep2")).click();

	
	/*List<WebElement> oCheckbox=driver.findElements(By.id("step_3"));
	int iSize=oCheckbox.size();
	for(int i=0; i<iSize; i++)
	{
		String sValue=((WebElement) oCheckbox.get(i)).getAttribute("value");
		if(sValue.equalsIgnoreCase("Son"))
		{
			oCheckbox.get(i).click();
			break;
		}
			
	}*/
		driver.findElement(By.id("btnHealthStep3")).click();
				
		//driver.findElement(By.id("healthMember")).sendKeys("");
		//Select SelfAge= new Select(driver.findElement(By.xpath("//*[@class='chkMemberAge']")));
		Select SelfAge= new Select(driver.findElement(By.className("chkMemberAge")));
		SelfAge.selectByVisibleText("22 Years");
		
		driver.findElement(By.id("btnHealthStep4")).click();
		
		
		/*driver.findElement(By.id("healthcheckbox2")).click();
		Select SpouseAge= new Select(driver.findElement(By.xpath("//*[@class='chkMemberAge']")));
		SpouseAge.selectByVisibleText("24 Years");*/
		
		//driver.switchTo().alert().dismiss();
		
		//driver.findElement(By.xpath("//*[@class='done']")).click();  
			
	
		
		/*
		Select Gender= new Select(driver.findElement(By.id("healthGender")));
		Gender.selectByVisibleText("Ms.");
		driver.findElement(By.id("healthName")).sendKeys("Test Agent");
		
		driver.findElement(By.id("btnSubmitHealth")).click();*/
		
		Thread.sleep(6000);
		 
		String secondurl=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurl);
		 
			if(secondurl.contains("enquiryid="))
			 {
				 System.out.println("Test Pass and Lead created");
				 result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Health Form is working : Test Pass";
				 Thread.sleep(1000);
				 //driver.quit();
				 
			 }
			else 
			{
				System.out.println(" Test Fail and unable to create lead");
				result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Health Form is not working : Test Fail";
				
			}
		
		}
		
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(result);
		
	}

}
