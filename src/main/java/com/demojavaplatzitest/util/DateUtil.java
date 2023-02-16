package com.demojavaplatzitest.util;

public class DateUtil {

	public boolean isLeapYear(int year) {	
		return ((year % 400 == 0) ||  (year % 4 == 0 && year % 100 != 0));
	}
}
