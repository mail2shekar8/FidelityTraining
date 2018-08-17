package com.demo.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class StartsAndEndsWithMatcher extends TypeSafeMatcher<String> {

	private String startAndEndValue;
	private String value;
	
	
	public StartsAndEndsWithMatcher(String startAndEndValue) {
		this.startAndEndValue = startAndEndValue;
	}

	public void describeTo(Description description) {
		description.appendText(value + " should start and end with " + startAndEndValue);
	}
	
	@Override
	protected boolean matchesSafely(String value) {
		this.value = value;
		return value.startsWith(startAndEndValue) && value.endsWith(startAndEndValue);
	}

}
