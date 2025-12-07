package test;

import org.testng.annotations.Test;



import java.io.IOException;


import java.time.Duration;  // Correct import for WebDriverWait

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


import org.testng.annotations.DataProvider;
import lib.ExcelReader;

public class CalculateForMonthlyPaymentPageTest extends BaseTest{
	
	
	@Test(dataProvider="bb1")
	public void calculateformonthlypaymentpage(String HomePrice, String DownPayment, 
			String LoanTerm, String InterestRate, String expectedPayment, String isValidStr) throws InterruptedException {
		
getCalculateForMonthlyPaymentPage();
		
		calculateformonthlypaymentpage.typeHomePrice(HomePrice);
		calculateformonthlypaymentpage.typeSelectDolarSign();
		calculateformonthlypaymentpage.typeDownPayment(DownPayment);
		calculateformonthlypaymentpage.typeEnterLoanTerm(LoanTerm);
		calculateformonthlypaymentpage.typeEnterInterestRate(InterestRate);
		calculateformonthlypaymentpage.typeClickCalculate();
		
		
		boolean isValid = Boolean.parseBoolean(isValidStr);
		
		String actual = calculateformonthlypaymentpage.typeMonthlyPayment(isValid);
		
		System.out.println("Actual Result: " + actual);
		System.out.println("Expected Result:   " + expectedPayment);
		
		
		String expected4 = "$";
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		if(isValid) {
			
			Assert.assertTrue(actual.contains(expectedPayment), "Unexpected monthly payment result.");
			
		}
		
		else {
			
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/div[2]/div/font")));

			
			Assert.assertFalse(actual.contains(expected4), "Unexpected valid output for invalid input.");
			
		}
		
		
		
		

		
		
		
	}
	
	
	
	@DataProvider(name="bb1")
	public Object[][] dataloader() throws IOException {
		Object[][] t;
		
		String filename = "data/d1.xlsx";
		String sheetname = "Sheet1";
		ExcelReader er = new ExcelReader(filename, sheetname);
		t = er.excelToArray();
		return t;
		
		
		}
		
		
		
	

}
