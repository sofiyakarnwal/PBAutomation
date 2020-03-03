package bu_pkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BU_Travel {
	
	String result;
	String GrpResult;
	String StudResult;
	public String TravelBU()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
					
		String url="https://www.policybazaar.com/travel-insurance/";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		String firsturl=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturl);
		
		String textToSelect="United States of America (USA)";
		WebElement autoOptions=	driver.findElement(By.id("destination-autocomplete"));
		autoOptions.sendKeys("United");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	    WebElement ul_element=driver.findElement(By.xpath("//*[@class='autocomplete wn-insurance-quote-editor left']"));
		
		List<WebElement> li_element=ul_element.findElements(By.className("selectable"));
		
		for(WebElement option : li_element)
		{
			System.out.println(option.getText().equals(textToSelect));
		    if(option.getText().equals(textToSelect)) 
		    {
		    	System.out.println("Trying to select: "+textToSelect);
		    	option.click();
		    	break;
		    }
		}
		
		driver .findElement(By.id("memage1")).click();
		driver.findElement(By.id("memage1")).sendKeys("25");
		//driver .findElement(By.id("memage2")).click();
		//driver.findElement(By.id("memage2")).sendKeys("22");
		driver .findElement(By.id("startdate")).click();
        WebElement sDate_calender=driver.findElement(By.className("opensright"));
		
		List<WebElement> sDate_td=sDate_calender.findElements(By.className("available"));
		
		for(WebElement SDoption : sDate_td)
		{
			System.out.println(SDoption.getText());
			System.out.println(SDoption.getText().equals("1"));
			
		    if(SDoption.getText().equals("1")) 
		    {
		    	//System.out.println("Trying to select: "+textToSelect);
		    	SDoption.click();
		    	break;
		    }
		}
		
		driver .findElement(By.id("enddate")).click();
        WebElement endDate_calender=driver.findElement(By.className("opensleft"));
		
		List<WebElement> endDate_td=endDate_calender.findElements(By.className("available"));
		
		for(WebElement EDoption : endDate_td)
		{
			System.out.println(EDoption.getText());
			System.out.println(EDoption.getText().equals("28"));
		    if(EDoption.getText().equals("28")) 
		    {
		    	//System.out.println("Trying to select: "+textToSelect);
		    	EDoption.click();
		    	break;
		    }
		}
		
		//WebElement MultiTrip=driver.findElement(By.className("formbox_new"));
		List<WebElement> TravelMulti=driver.findElements(By.name("MultitripRadio"));
		
		TravelMulti.get(1).isSelected();
		if(true)
			TravelMulti.get(0).click();
		else
			TravelMulti.get(1).click();
			
		List<WebElement> TripFreq=driver.findElements(By.name("radio2"));
		
		TripFreq.get(0).isSelected();
		if(true)
			TripFreq.get(1).click();
		else
			TripFreq.get(0).click();
		
		driver.findElement(By.id("proceedStepOne")).click();
		Thread.sleep(6000);
		Select gender=new Select(driver.findElement(By.id("travelgender")));
		gender.selectByVisibleText("Mr.");
		driver.findElement(By.id("travelname")).sendKeys("Test agent");
		driver.findElement(By.id("travelmobile")).sendKeys("6767676767");
		driver.findElement(By.id("travelemail")).sendKeys("test@gmail.com");
		driver.findElement(By.className("travelproceed")).click();
				
		Thread.sleep(60000);
		String secondurl=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurl);
		
		if(secondurl.contains("https://travel.policybazaar.com"))
		 {
			 System.out.println("Test Pass");
			  result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Travel Form for Family/Self is working : Test Pass";
			 Thread.sleep(6000);
			
		 }
		else 
		{
			System.out.println("Test Fail");
			result="\n"+ "Tested URL: "+ url+ "\n"+ "URL after Redirection: "+ secondurl+ "\n"+ "Travel Form for Family/Self is not working: Test Fail" ;
		}
		driver.quit();
		}
		
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(result);
	
	
	}
	
	/*Function for Group Travel*/
	
	public String GrpTravelBU()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
			
		String urll="https://www.policybazaar.com/travel-insurance/";
		driver.get(urll);
		String firsturll=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturll);
		String LinkToSelect="Group/Friends";
		WebElement ulTabs=driver.findElement(By.className("travelFormTab"));
		List<WebElement> liTabs=ulTabs.findElements(By.tagName("li"));
		for(WebElement option: liTabs)
		{
			//System.out.println(option.getText().equals(LinkToSelect));
			System.out.println(option.getText().equalsIgnoreCase(LinkToSelect));
			if(option.getText().equalsIgnoreCase(LinkToSelect)) 
		    {
		    	System.out.println("Trying to select: "+LinkToSelect);
		    	option.click();
		    	break;
		    }
		}
		
		String textToSelect="United States of America (USA)";
		WebElement autoOptions=	driver.findElement(By.id("destination-autocomplete"));
		autoOptions.sendKeys("United");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	    WebElement ul_element=driver.findElement(By.xpath("//*[@class='autocomplete wn-insurance-quote-editor left']"));
		
		List<WebElement> li_element=ul_element.findElements(By.className("selectable"));
		
		for(WebElement option : li_element)
		{
			System.out.println(option.getText().equals(textToSelect));
		    if(option.getText().equals(textToSelect)) 
		    {
		    	System.out.println("Trying to select: "+textToSelect);
		    	option.click();
		    	break;
		    }
		}
		
		driver .findElement(By.id("memage1")).click();
		driver.findElement(By.id("memage1")).sendKeys("25");
		driver .findElement(By.id("memage2")).click();
		driver.findElement(By.id("memage2")).sendKeys("22");
		driver .findElement(By.id("startdate")).click();
        WebElement sDate_calender=driver.findElement(By.className("opensright"));
		
		List<WebElement> sDate_td=sDate_calender.findElements(By.className("available"));
		
		for(WebElement SDoption : sDate_td)
		{
			System.out.println(SDoption.getText());
			System.out.println(SDoption.getText().equals("1"));
			
		    if(SDoption.getText().equals("1")) 
		    {
		    	//System.out.println("Trying to select: "+textToSelect);
		    	SDoption.click();
		    	break;
		    }
		}
		
		driver .findElement(By.id("enddate")).click();
        WebElement endDate_calender=driver.findElement(By.className("opensleft"));
		
		List<WebElement> endDate_td=endDate_calender.findElements(By.className("available"));
		
		for(WebElement EDoption : endDate_td)
		{
			System.out.println(EDoption.getText());
			System.out.println(EDoption.getText().equals("28"));
		    if(EDoption.getText().equals("28")) 
		    {
		    	//System.out.println("Trying to select: "+textToSelect);
		    	EDoption.click();
		    	break;
		    }
		}
		
		//WebElement MultiTrip=driver.findElement(By.className("formbox_new"));
		List<WebElement> TravelMulti=driver.findElements(By.name("MultitripRadio"));
		
		TravelMulti.get(1).isSelected();
		if(true)
			TravelMulti.get(0).click();
		else
			TravelMulti.get(1).click();
			
		List<WebElement> TripFreq=driver.findElements(By.name("radio2"));
		
		TripFreq.get(0).isSelected();
		if(true)
			TripFreq.get(1).click();
		else
			TripFreq.get(0).click();
		
		driver.findElement(By.id("proceedStepOne")).click();
		Thread.sleep(6000);
		Select gender=new Select(driver.findElement(By.id("travelgender")));
		gender.selectByVisibleText("Mr.");
		driver.findElement(By.id("travelname")).sendKeys("Test agent");
		driver.findElement(By.id("travelmobile")).sendKeys("6767676767");
		driver.findElement(By.id("travelemail")).sendKeys("test@gmail.com");
		driver.findElement(By.className("travelproceed")).click();
				
		Thread.sleep(60000);
		String secondurll=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurll);
		
		if(secondurll.contains("https://travel.policybazaar.com"))
		 {
			 System.out.println("Test Pass");
			  GrpResult="\n"+ "Tested URL: "+ urll+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Travel Form for Group/Friends is working : Test Pass";
			 Thread.sleep(6000);
			
		 }
		else 
		{
			System.out.println("Test Fail");
			GrpResult="\n"+ "Tested URL: "+ urll+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Travel Form for Group/Friends is not working: Test Fail" ;
		}
		driver.quit();
		}
		
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(GrpResult);
	
	
	}
	

/*Function for Student Travel*/
	
	public String StudentTravelBU()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);	
			
		String urll="https://www.policybazaar.com/travel-insurance/";
		driver.get(urll);
		String firsturll=driver.getCurrentUrl();
		System.out.println("Tested URL is: " + firsturll);
		String LinkToSelect="Student";
		WebElement ulTabs=driver.findElement(By.className("travelFormTab"));
		List<WebElement> liTabs=ulTabs.findElements(By.tagName("li"));
		for(WebElement option: liTabs)
		{
			//System.out.println(option.getText().equals(LinkToSelect));
			System.out.println(option.getText().equalsIgnoreCase(LinkToSelect));
			if(option.getText().equalsIgnoreCase(LinkToSelect)) 
		    {
		    	System.out.println("Trying to select: "+LinkToSelect);
		    	option.click();
		    	break;
		    }
		}
		
		String textToSelect="United States of America (USA)";
		WebElement autoOptions=	driver.findElement(By.id("destination-autocomplete"));
		autoOptions.sendKeys("United");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	    WebElement ul_element=driver.findElement(By.xpath("//*[@class='autocomplete wn-insurance-quote-editor left']"));
		
		List<WebElement> li_element=ul_element.findElements(By.className("selectable"));
		
		for(WebElement option : li_element)
		{
			System.out.println(option.getText().equals(textToSelect));
		    if(option.getText().equals(textToSelect)) 
		    {
		    	System.out.println("Trying to select: "+textToSelect);
		    	option.click();
		    	break;
		    }
		}
		
		driver .findElement(By.id("memage1")).click();
		driver.findElement(By.id("memage1")).sendKeys("25");
		driver .findElement(By.id("memage2")).click();
		driver.findElement(By.id("memage2")).sendKeys("22");
		driver .findElement(By.id("startdate")).click();
        WebElement sDate_calender=driver.findElement(By.className("opensright"));
		
		List<WebElement> sDate_td=sDate_calender.findElements(By.className("available"));
		
		for(WebElement SDoption : sDate_td)
		{
			System.out.println(SDoption.getText());
			System.out.println(SDoption.getText().equals("1"));
			
		    if(SDoption.getText().equals("1")) 
		    {
		    	//System.out.println("Trying to select: "+textToSelect);
		    	SDoption.click();
		    	break;
		    }
		}
		
		driver .findElement(By.id("enddate")).click();
        WebElement endDate_calender=driver.findElement(By.className("opensleft"));
		
		List<WebElement> endDate_td=endDate_calender.findElements(By.className("available"));
		
		for(WebElement EDoption : endDate_td)
		{
			System.out.println(EDoption.getText());
			System.out.println(EDoption.getText().equals("28"));
		    if(EDoption.getText().equals("28")) 
		    {
		    	//System.out.println("Trying to select: "+textToSelect);
		    	EDoption.click();
		    	break;
		    }
		}
		
		/*
		List<WebElement> TravelMulti=driver.findElements(By.name("MultitripRadio"));
		
		TravelMulti.get(1).isSelected();
		if(true)
			TravelMulti.get(0).click();
		else
			TravelMulti.get(1).click();
			
		List<WebElement> TripFreq=driver.findElements(By.name("radio2"));
		
		TripFreq.get(0).isSelected();
		if(true)
			TripFreq.get(1).click();
		else
			TripFreq.get(0).click();
		*/
		
		driver.findElement(By.id("proceedStepOne")).click();
		Thread.sleep(6000);
		Select gender=new Select(driver.findElement(By.id("travelgender")));
		gender.selectByVisibleText("Mr.");
		driver.findElement(By.id("travelname")).sendKeys("Test agent");
		driver.findElement(By.id("travelmobile")).sendKeys("6767676767");
		driver.findElement(By.id("travelemail")).sendKeys("test@gmail.com");
		driver.findElement(By.className("travelproceed")).click();
				
		Thread.sleep(60000);
		String secondurll=driver.getCurrentUrl();
		 System.out.println("URL after Submit Button click is : " + secondurll);
		
		if(secondurll.contains("https://travel.policybazaar.com"))
		 {
			 System.out.println("Test Pass");
			  StudResult="\n"+ "Tested URL: "+ urll+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Travel Form for Students is working : Test Pass";
			 Thread.sleep(6000);
			
		 }
		else 
		{
			System.out.println("Test Fail");
			StudResult="\n"+ "Tested URL: "+ urll+ "\n"+ "URL after Redirection: "+ secondurll+ "\n"+ "Travel Form for Students is not working: Test Fail" ;
		}
		driver.quit();
		}
		
		catch(Exception exc) 
		{
			exc.printStackTrace();
		}
		return(StudResult);
	
	
	}

	
}
