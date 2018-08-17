package com.demo.matchers;

import org.hamcrest.Matcher;

public class CustomMatchers {
	private CustomMatchers(){
	}
	
	public static StartsAndEndsWithMatcher startAndEndsWith(String value){
		return new StartsAndEndsWithMatcher(value);
	}

	public static EachAndEveryIntegerMatcher eachAndEveryIntegerIs(Matcher matcher){
		return new EachAndEveryIntegerMatcher(matcher);
	}
}
