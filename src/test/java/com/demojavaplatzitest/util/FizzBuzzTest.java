package com.demojavaplatzitest.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment =  WebEnvironment.RANDOM_PORT)
class FizzBuzzTest {

	@InjectMocks
	FizzBuzz fizzBuzz;
	
	@Test
	void numberDivisibleBy3WithValue3() {
		String isFizz = fizzBuzz.fizzBuz(3);
		assertEquals("Fizz", isFizz);
	}
	
	@Test
	void numberDivisibleBy3WithValue6() {
		String isFizz = fizzBuzz.fizzBuz(6);
		assertEquals("Fizz", isFizz);
	}
	
	@Test
	void numberDivisibleBy5WithValue5() {
		String isBuzz = fizzBuzz.fizzBuz(5);
		assertEquals("Buzz", isBuzz);
	}
	
	@Test
	void numberDivisibleBy5WithValue10() {
		String isBuzz = fizzBuzz.fizzBuz(10);
		assertEquals("Buzz", isBuzz);
	}
	
	@Test
	void numberDivisibleBy3and5WithValue15() {
		String isFizzBuzz = fizzBuzz.fizzBuz(15);
		assertEquals("FizzBuzz", isFizzBuzz);
	}
	
	@Test
	void numberDivisibleBy3and5WithValue30() {
		String isFizzBuzz = fizzBuzz.fizzBuz(30);
		assertEquals("FizzBuzz", isFizzBuzz);
	}
	
	@Test
	void numberNotDivisibleBy3and5WithValue2() {
		int number = Integer.parseInt(fizzBuzz.fizzBuz(2));
		assertEquals(2, number);
	}
	
	@Test
	void numberNotDivisibleBy3and5WithValue16() {
		int number = Integer.parseInt(fizzBuzz.fizzBuz(16));
		assertEquals(16, number);
	}
}
