package miscellaneousExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) {
		
		
		
		System.setProperty("WebDriver.ChromeDriver","ChromeDriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("Seession Key");
		
		driver.get("https://www.google.co.in/");
		driver.close();
	}
	
}
