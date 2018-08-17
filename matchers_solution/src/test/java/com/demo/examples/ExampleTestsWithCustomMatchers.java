package com.demo.examples;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static com.demo.matchers.CustomMatchers.startAndEndsWith;
import static com.demo.matchers.CustomMatchers.eachAndEveryIntegerIs;

import static org.hamcrest.Matchers.greaterThan;

public class ExampleTestsWithCustomMatchers {

	@Test
	public void exampleTestWithStartsAndEndsWithMatcher(){
		assertThat("that", startAndEndsWith("t"));
	}

	@Test
	public void exampleTestWithStartsAndEndsWithMatcherThatFails(){
		assertThat("theatre", startAndEndsWith("t"));
	}
	
	@Test
	public void exampleTestWithEachAndEveryIntegerMatcher(){
		Integer[] data = {1,2,3,4};
		assertThat(data , eachAndEveryIntegerIs(greaterThan(0)));
	}
	
	
	
	
	
	
	
	
	

}
