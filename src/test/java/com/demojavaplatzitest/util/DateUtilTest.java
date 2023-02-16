package com.demojavaplatzitest.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment =  WebEnvironment.RANDOM_PORT)
class DateUtilTest {

	/*
	 * All years divisible by 400 ARE Leap years (1600, 2000, 2400)
	 * All years divisible by 100 but not by 400 are NOT leap years (1700, 1800, 1900),
	 * All years divisible by 4 but not by 100 ARE 1eap years (1996, 2004, 2008),
	 * All years not divisible by 4 are NOT Leap years (2017, 2018, 2019)
	 * 
	 * */
	
	@InjectMocks
	DateUtil dateUtil;
	
	@Test
	void returnTrueWhenIsDivisibleBy400(){
		boolean leapYearOne = dateUtil.isLeapYear(1600);
		boolean leapYearTwo = dateUtil.isLeapYear(1600);
		boolean leapYearThree = dateUtil.isLeapYear(1600);
		
		assertTrue(leapYearOne);
		assertTrue(leapYearTwo);
		assertTrue(leapYearThree);
	}
	
	@Test
	void returnFalseWhenIsNotDivisibleBy400ButIsDivisibleBy100(){
		boolean noLeapYearOne = dateUtil.isLeapYear(1700);
		boolean noLeapYearTwo = dateUtil.isLeapYear(1800);
		boolean noLeapYearThree = dateUtil.isLeapYear(1900);
		
		assertFalse(noLeapYearOne);
		assertFalse(noLeapYearTwo);
		assertFalse(noLeapYearThree);
	}
	
	@Test
	void returnTrueWhenIsNotDivisibleBy100ButIsDivisibleBy4(){
		boolean leapYearOne = dateUtil.isLeapYear(1996);
		boolean leapYearTwo = dateUtil.isLeapYear(2004);
		boolean leapYearThree = dateUtil.isLeapYear(2008);
		
		assertTrue(leapYearOne);
		assertTrue(leapYearTwo);
		assertTrue(leapYearThree);
	}
	
	@Test
	void returnFalsWhenIsNotDivisibleBy4(){
		boolean NoleapYearOne = dateUtil.isLeapYear(2017);
		boolean NoleapYearThree = dateUtil.isLeapYear(2019);
		boolean NoleapYearTwo = dateUtil.isLeapYear(2018);
		
		assertFalse(NoleapYearOne);
		assertFalse(NoleapYearTwo);
		assertFalse(NoleapYearThree);
	}
}
