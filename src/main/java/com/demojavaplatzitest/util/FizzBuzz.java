package com.demojavaplatzitest.util;

public class FizzBuzz {

	public String fizzBuz(int n) {
		StringBuilder message = new StringBuilder();
		if(n % 3 == 0) message.append("Fizz");
		if(n % 5 == 0) message.append("Buzz");
		return message.length() > 0 ? message.toString() : String.valueOf(n);
	}
}
