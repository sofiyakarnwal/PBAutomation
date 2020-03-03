package bu_pkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



//import org.openqa.selenium.*;	
/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;*/


public class BU_page {
	
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		
		resultEmail remail=new resultEmail();
		
		// For Life Insurance
		
		BU_Life buLife = new BU_Life();
		String Life=buLife.LifeBU();
		System.out.println(Life);
		
		StringBuilder result= new StringBuilder("BU Forms Report\n");
		result.append(Life);
		
		
		
		/*Article_Life LifeArt=new Article_Life();
		String ArticleLife=LifeArt.ArtLife();
		result.append(ArticleLife);*/
		
		// For Investment
		
		BU_Investment buInvest= new BU_Investment();
		String Investment=buInvest.InvestmentBU();
		System.out.println(Investment);
		
		result.append("\n" +Investment);
		
		
					
		
		/* BU_Health buHealth=new BU_Health();
		String Health=buHealth.HealthBU();
		System.out.println(Health);
		result.append("\n" +Health);
		
		BU_Ci buCi=new BU_Ci();
		String Ci=buCi.CiPaBU();
		System.out.println(Ci);
		result.append("\n" +Ci);*/
		
		// For Car Insurance				
		BU_Car bucar=new BU_Car();
		String Car=bucar.CarBU();
		System.out.println(Car);
		result.append("\n" +Car);
				  
		String CarBULinks=bucar.CarBULinks();
		result.append("\n" +CarBULinks);
		String NewCarBULinks=bucar.NewCarBULinks();
		result.append("\n" +NewCarBULinks);
		
		BU_Tw butw=new BU_Tw();
		String TW=butw.TwBU();
		//System.out.println(TW);
		result.append("\n" +TW);
		String TWBULinks=butw.TwBULinks();
		result.append("\n" +TWBULinks);
		String NewTWBULinks=butw.NewTwBULinks();
		result.append("\n" +NewTWBULinks);
		
		
		Claim claim=new Claim();
		String Claim=claim.ClaimReq();
		//System.out.println(Claim);
		result.append("\n" +Claim);
		
		BU_Travel buTravel=new BU_Travel();
		String Travel=buTravel.TravelBU();
		System.out.println(Travel);
		result.append("\n" +Travel);
		
		
		BU_Travel GrpBuTravel= new BU_Travel();
		String GrpTravel= GrpBuTravel.GrpTravelBU();
		System.out.println(GrpTravel);
		result.append("\n" +GrpTravel);
		
		BU_Travel StudTravelBU= new BU_Travel();
		String StudTravel= StudTravelBU.StudentTravelBU();
		System.out.println(StudTravel);
		result.append("\n" +StudTravel);
		
		// Try to write output in a text file
		    String TestFile="./OutputData/Output.txt";
			File FC=new File(TestFile);
			FC.createNewFile();
			
			FileWriter FW= new FileWriter(TestFile);
			BufferedWriter BW=new BufferedWriter(FW);
			BW.append(result);
			
			BW.close();
		  
	/*	
		
		BU_GroupInsurance buGroup= new BU_GroupInsurance();
		String Sme=buGroup.SmeBU();
		System.out.println(Sme);
		result.append("\n" +Sme);
		
		*/
		
		/*
		BU_GroupInsurance buGroup= new BU_GroupInsurance();
		String Sme=buGroup.SmeBU();
		System.out.println(Sme);
		result.append("\n" +Sme);*/
		
		/*BU_Pa bupa=new BU_Pa();
		String Pa=bupa.PaBU();
		result.append("\n" +Pa);*/
		
		
        System.out.println(result);
        

		
		 // System.out.println(result);
		
        remail.sendEmail(result, "Testing BU Forms");
	}
	
	
	
			
			
}




