package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculateForMonthlyPaymentModel extends BaseModel{

	public CalculateForMonthlyPaymentModel(WebDriver driver) {
		super(driver);
	}
	
	

public WebElement getHomePrice() {
		
		WebElement homePrice = driver.findElement(By.xpath("//input[1]"));
		
		
		return homePrice;
		
	}
	
	
public WebElement getSelectDolarSign() {
		
	WebElement SelectDolarSign = driver.findElement(By.xpath("//select/option[2]"));
		
		return SelectDolarSign;
		
	}



public WebElement getDownPayment() {
	
	WebElement DownPayment = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input"));
	
	return DownPayment;
	
}


public WebElement getEnterLoanTerm() {
	
	WebElement EnterLoanTerm = driver.findElement(By.xpath("//tbody/tr[3]/TD[2]/input"));
	
	return EnterLoanTerm;
	
}


public WebElement getEnterInterestRate() {
	
	WebElement EnterInterestRate = driver.findElement(By.xpath("//tbody/tr[4]/TD[2]/input"));
	
	
	return EnterInterestRate;
	
}



public WebElement getClickCalculate() {
	
	WebElement ClickCalculate = driver.findElement(By.xpath("//div/form/table/tbody/tr[8]/td/input[2]"));
	
	
	return ClickCalculate;
	
}



public String getMonthlyPayment() {
	
	String MonthlyPayment = driver.findElement(By.xpath("//div[4]/table/tbody/tr/td/h2")).getText();
	
	
	return MonthlyPayment;
	
}





public WebElement getEnterNegativeValue() {
	
	WebElement EnterNegativeValue = driver.findElement(By.xpath("//input[1]"));
	
	
	return EnterNegativeValue;
	
}









public String getTestInvalidAmount() {
	
	String TestInvalidAmount = driver.findElement(By.xpath("//div[4]/div[2]")).getText();
	
	
	return TestInvalidAmount;
	
}








	
	
	
}




