package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

	@BeforeClass

	public void BfOClass() {
		System.out.println("Before Executing any methods in the class,Before Class");
	}

	//@Parameters({ "URL" })
	@Test
	public void WebLoginCarloan() {
		System.out.println("Selenium Web");

		//System.out.println("The parametirized URL is:" + urlname);
	}

	@Test
	public void MobileLoginCarloan() {
		System.out.println("Mobile Appium");
	}

	// here we can pick the specified tests using groups and using include tag name

	@Test(groups = { "Smoke" })
	public void LoginCarLoanAPi() {
		System.out.println("Login Car Loan API");
	}

	// here we skip the test using enabled

	@Test(enabled = false)
	public void MobileAppCarLoan() {
		System.out.println("MobileAppCarLoan Print");
	}

	@BeforeMethod
	public void BeforeEveryMethod() {
		System.out.println("I will execute Before Every test  Method in Day3 Class,I am on Before Method");
	}

	@AfterMethod
	public void AfterEveryMethod() {

		System.out.println("I will exceute After Every test method in Day3 Class,I am on After Nethod ");

	}

	@AfterClass

	public void AfClass() {
		System.out.println("After exectuing all methods in the class,After Class");
	}

	// here we use timeout so it will not fail till 40 seconds
	// it is only for this test case.

	@Test(timeOut = 4000)
	public void MobileSignUpLoan() {
		System.out.println("Mobile Sign Up loan day3 class");
	}

	@Test
	public void MobileUserCarLoan() {
		System.out.println("MobileUserCarLoan");
	}

	@BeforeSuite

	public void BfSuite() {
		System.out.println("I am the no 1,I am on Before Suite");
	}

	@Test

	public void MobileAppCompanyCarLoan() {

		System.out.println("Mobile Aoo Company Car Loan");

	}

	@Parameters({ "URL" })
	@Test
	public void Carloan(String uname1) {
		System.out.println("This will print Car Loan");

		System.out.println("The url of the Car loan is:" + uname1);
	}

	// here we use depends so the advantage is if we put a method in depends that
	// will be execute before this methood
	// that means method don't be executed in the alphabetic order.

	@Test(dependsOnMethods = { "WebLoginCarloan", "MobileAppCompanyCarLoan" })
	public void ApiCarLoan() {
		System.out.println("Api  car loan will be executed");
	}

}
