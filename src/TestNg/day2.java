package TestNg;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {

	
	@Test
	public void ploan() {
		System.out.println("Good Bye");
	}

	@Test(groups = { "Smoke" })
	public void UloanAb() {

		System.out.println("This is day2 class");
	}

	@Parameters({ "URL" })
	@Test
	public void PersonalLoan(String uname) {
		System.out.println("This will print Personal Loan");
		System.out.println("The url of the Personal Loan:" + uname);
	}

	@Test(dataProvider = "getData")
	public void CarLoanSignIn(String username, String password) {
		System.out.println("This will print CarLoan Sign In");
		System.out.println("The username is:" + username);
		System.out.println("The password is:" + password);

	}

	@BeforeTest
	public void prerequisite() {
		System.out.println("I will execute First ,I am on Before Test");
	}

	@DataProvider
	public Object[][] getData() {

		// 1 st combination username ,password
		// 2 nd combination username ,pasword no credit history
		// 3 rd combination incorrect username ,password

		Object[][] data = new Object[3][2];// 3 rows and 2 coloumns

		// first set
		// [row][coloumn]

		data[0][0] = "username1";
		data[0][1] = "password1";

		// second set
		data[1][0] = "username2";
		data[1][1] = "password2";

		// Third set

		data[2][0] = "username3";
		data[2][1] = "password3";

		return data;

	}
}
