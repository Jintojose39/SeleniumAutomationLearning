package miscellaneousExamples;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SSlCheck2 {

	public static void main(String[] args) {
		EdgeOptions Options = new EdgeOptions();

		Options.setAcceptInsecureCerts(true);
		System.setProperty("WebDriver.edgeDriver", "EdgeDriver.exe");
		WebDriver driver = new EdgeDriver(Options);

		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

	}

}
