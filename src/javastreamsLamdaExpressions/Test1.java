package javastreamsLamdaExpressions;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void regular() {
		

		ArrayList<String> names = new ArrayList<String>();

		names.add("Jinto");
		names.add("Shiju");
		names.add("Jomy");
		names.add("Bibin");
		names.add("Jobil");
		names.add("Jinu");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("J")) {
				count++;
			}

		}

		System.out.println("The number of words started with J:"+ " "+count);
	}

}
