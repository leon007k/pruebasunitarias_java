package com.demojavaplatzitest.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;



@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
class StringUtilTest {
	
	@InjectMocks
	private StringUtil stringUtil;
	
	@Test
	 void repeatString() {
		String result = stringUtil.repeat("hola", 3);
		
		assertEquals("holaholahola", result);
	}
	
	@Test
	void repeatStringNegativeTimes() {
		
		Exception exception = assertThrows(IllegalArgumentException.class, ()->{
			stringUtil.repeat("hola", -1);
		});
		
		assertEquals("negative times not allowed", exception.getMessage());
	}
	
	@Test
	void stringIsNotEmpty() {
		boolean verifyString = stringUtil.isEmpty("Hola esto es una prueba");
		
		assertFalse(verifyString);
	}
	
	@Test
	void stringIsNull() {
		boolean verifyString = stringUtil.isEmpty(null);
		
		assertTrue(verifyString);
	}
	
	@Test
	void stringIsEmpty() {
		boolean verifyString = stringUtil.isEmpty("");
		
		assertTrue(verifyString);
	}
	
	@Test
	void stringIsEmptyWithSpace() {
		boolean verifyString = stringUtil.isEmpty("  ");
		
		assertTrue(verifyString);
	}
	
	@Test
	void stringIsNoyEmptyWithSpace() {
		boolean verifyString = stringUtil.isEmpty(" Hola mundo ");
		
		assertFalse(verifyString);
	}
}
