package javastreamsLamdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class StreamFilter {

	@Test(enabled = false)
	public void stream() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Jinto");
		names.add("Shiju");
		names.add("Jomy");
		names.add("BibiN");
		names.add("Jobil");
		names.add("JinU");

		// for lambda operations

		Long c = names.stream().filter(s -> s.startsWith("J")).count();

		// System.out.println(c);
		// there is no life for intermediate op there is no terminal operator
		// terminal operator will execute if inter operator return true
		// we can create stream

		long d = Stream.of("jinto", "Shiju", "Jomy", "Jobin", "Jobil").filter(s -> {
			s.startsWith("J");
			return true;

		}).count();

		// System.out.println(d);
	}
	// names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

	// names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));

	// names.stream().filter(s->s.endsWith("o")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

	// names.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	// names.stream().map(s -> s.toLowerCase()).forEach(s -> System.out.println(s));

	// array to arraylist

	@Test(enabled = false)
	public void StreamMap() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Jinto");
		names.add("Shiju");
		names.add("Jomy");
		names.add("BibiN");
		names.add("Jobil");
		names.add("JinU");

		// here is we use conersion of Array to ArrayList
		List<String> names1 = Arrays.asList("Jinto", "shiju", "jomy", "Jobin", "Jobil");

		// print the names with sorted order and all the names will display first name
		// with uppercase letter

		names1.stream().filter(s -> s.startsWith("J")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// merging two different list

		Stream<String> namesStream = Stream.concat(names.stream(), names1.stream());

		Stream<String> namesStream1 = Stream.concat(names.stream(), names1.stream());

		boolean check = namesStream1.allMatch(s -> s.contains("Jin"));

		System.out.println(check);

		boolean flag = namesStream.anyMatch(s -> s.equalsIgnoreCase("Jinto"));

		System.out.println(flag);

		Assert.assertTrue(flag);

	}

	@Test(enabled=false)

	public void StreamCollect() {

		// to put into the list with uppercase and print 1st element from that list.
		List<String> ls = Stream.of("Jinto", "shiju", "jomy", "Jobio", "Jobil").filter(s -> s.endsWith("o"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());

		System.out.println(ls);
		System.out.println("Method Srtream Collect");

		System.out.println(ls.get(0) + "" + "StreamCollect");
		
		System.out.println(ls.get(2));
	}

	@Test
	public void StreamAssignment() {
	List<Integer>values=Arrays.asList(2,2,2,4,5,6,7,8,9,9,9);
	//to  print the unique numbers from list
	//to  sorted the numbers
	
	
	//values.stream().sorted().distinct().forEach(s->System.out.println(s));
	
	
	List<Integer>li=values.stream().distinct().sorted().collect(Collectors.toList());
	
	
	System.out.println(li.get(2));
	
	

	
	
	
	}
	
	
}
