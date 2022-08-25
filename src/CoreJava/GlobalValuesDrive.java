package CoreJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\RahulShettyLearnAutomation\\src\\CoreJava\\data.properties");

		prop.load(fis);

		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		// System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("email"));

		// to change the prop file we use set property

		prop.setProperty("browser", "chrome");
		prop.setProperty("username", "Jintojose1996");

		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("username"));

		// to store the changed data in the propertices file

		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\RahulShettyLearnAutomation\\src\\CoreJava\\data.properties");
		
		prop.store(fos, null);

	}

}
