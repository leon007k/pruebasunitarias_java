package com.demojavaplatzitest.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
class PasswordUtilTest {

	@InjectMocks
	PasswordUtil passwordUtil;
	
	@Test
	void weakWhenHasLessThan8Letters() {
		assertEquals(PasswordUtil.SecurityLevel.WEAK, passwordUtil.assessPassword("1234567"));
	}
	
	@Test
	void weakWhenHasOnlyLetters() {
		assertEquals(PasswordUtil.SecurityLevel.WEAK, passwordUtil.assessPassword("abcdef"));
	}
	
	@Test
	void mediumWhenHasLettersAndNumbers() {
		assertEquals(PasswordUtil.SecurityLevel.MEDIUM, passwordUtil.assessPassword("abcd1234"));
	}
	
	@Test
	void strongWhenHasLettersAndNumbers() {
		assertEquals(PasswordUtil.SecurityLevel.STRONG, passwordUtil.assessPassword("abcd1234!"));
	}
	
}
