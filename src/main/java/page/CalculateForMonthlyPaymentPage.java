package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import model.CalculateForMonthlyPaymentModel;



public class CalculateForMonthlyPaymentPage extends CalculateForMonthlyPaymentModel{
	
	

	public CalculateForMonthlyPaymentPage(WebDriver driver) {
		super(driver);
		

	}
	
	
public void typeHomePrice(String HomePrice) throws InterruptedException {
		
	Thread.sleep(500);
		WebElement homePrice = getHomePrice();
		

        homePrice.clear();
        homePrice.sendKeys(HomePrice);

        
		
		
		
		
	}
	
	
	public void typeSelectDolarSign() throws InterruptedException {
		
		Thread.sleep(500);
		
		WebElement SelectDolarSign = getSelectDolarSign();
		
		SelectDolarSign.click();
        
        
	}
	
	
	
	
	public void typeDownPayment(String DownPayment) throws InterruptedException {
		
		Thread.sleep(500);
		
		WebElement downPayment = getDownPayment();
		
		downPayment.clear();
		
		downPayment.sendKeys(DownPayment);
	}
	
	
	
	public void typeEnterLoanTerm(String LoanTerm) throws InterruptedException {
		
		Thread.sleep(500);
		
		 	WebElement EnterLoanTerm = getEnterLoanTerm();
		 
		 	EnterLoanTerm.clear();
	        
		 	EnterLoanTerm.sendKeys(LoanTerm);
	}
	
	
	
	public void typeEnterInterestRate(String InterestRate) throws InterruptedException {
		
		Thread.sleep(500);
		
		WebElement EnterInterestRate = getEnterInterestRate();
		
		EnterInterestRate.clear();
		
		EnterInterestRate.sendKeys(InterestRate);
		

	}
	

	
	
	public void typeClickCalculate() throws InterruptedException {
		
		Thread.sleep(500);
		
		WebElement ClickCalculate = getClickCalculate();
		
		ClickCalculate.click();
		
		Thread.sleep(500);
		
	}
	
	
	
	
/* public String typeMonthlyPayment() throws InterruptedException {
		

String MonthlyPayment = getMonthlyPayment();
  
    System.out.println("PASS if actual result and expected result is TRUE:\nActual Result:   " + 
    MonthlyPayment);
    
return MonthlyPayment;
		
		
		
	
		
	}
	
	*/
	
	
	
	
	
	
	
	
	
	public String typeMonthlyPayment(boolean isValid) throws InterruptedException {
	    String MonthlyPayment;
	    if (isValid) {
	         MonthlyPayment = getMonthlyPayment();
	    } else {
	        MonthlyPayment = getTestInvalidAmount();
	    }

	    System.out.println(isValid
	        ? "\nPASS if actual result and expected result is TRUE:\nActual Result:   " + MonthlyPayment
	        : "\nPASS if actual result and expected result is FALSE:\nActual Result:   " + MonthlyPayment);

	    return MonthlyPayment;
	}

	




	

	
public String typeTestInvalidAmount() throws InterruptedException {
	

String TestInvalidAmount = getTestInvalidAmount();
  
    System.out.println("\nPASS if actual result and expected result is FALSE:\nActual Result:   " + TestInvalidAmount);
    
return TestInvalidAmount;
		
		
				
		
		
		
	}




	
	

}
	





