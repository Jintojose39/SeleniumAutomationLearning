package TestNg;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class day4 {

	@Test
	public void WebLoginUserloan() {
		System.out.println("Selenium Web");
	}

	@Test(groups={"Smoke"})
	public void MobileLoginPersonalloan() {
		System.out.println("Mobile Appium");
	}

	@Test
	public void LoginAPIHome() {
		System.out.println("Home API Ptinting");
	}

}
