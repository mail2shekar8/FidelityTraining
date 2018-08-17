package Intro_lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		List<String> currencies = Arrays.asList("USD", "JPY", "EUR", "HKD", "INR", "AUD");
					 currencies.forEach (c-> System.out.println (c));
					 //currencies.forEach (System.out::println);
		
		Collections.sort(currencies, (c1, c2) -> c1.compareTo(c2));
		
		System.out.println("\nCurrencies in ascending order\n");
        currencies.forEach((c) -> System.out.println(c));
        //currencies.forEach(System.out::println);
        
        Collections.sort(currencies, (c1, c2) -> -c1.compareTo(c2));

        System.out.println("\nCurrencies in descending order\n");
        currencies.forEach((c) -> System.out.println(c));
        //currencies.forEach(System.out::println);
        
        new Thread (()-> 
        {
        for(int i=1;i<11;i++)
        {        
        	System.out.println (i);
        	//Will not work--System.out::println;
        }
        }
        ).start();

	}	
}
