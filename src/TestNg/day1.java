package TestNg;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



public class day1 {

	@AfterTest
	public void lastExecute() {
		System.out.println("I will execute Last , I am on After Test ");
	}

	@Test(groups={"Smoke"})
	public void AnnulPersonalLoan() {
		System.out.println("Hello In Day 1");
	}
	@Test
	public void MonthlyPersonalLoan() {
		System.out.println("Bye Bye MonthlyPersonalLoan");
		
		Assert.assertTrue(false);
	
	}

	@AfterSuite
	public void AfSuite() {
		System.out.println("I am the last no  1, I am on After Suite");
	}


		
		
	}

