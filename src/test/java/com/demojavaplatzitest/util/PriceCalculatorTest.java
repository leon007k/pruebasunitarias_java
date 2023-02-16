package com.demojavaplatzitest.util;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
public class PriceCalculatorTest {

	@InjectMocks
	PriceCalculator priceCalculator;
	
	@Test
	void totalZeroWhenThereArePrices() {
		double total = priceCalculator.getTotal();
		
		assertEquals(0.0, total, 0);
	}
	
	@Test
	void totalIsTheSumOfPrices() {
		priceCalculator.addPrice(10.15);
		priceCalculator.addPrice(20.05);
		double total = priceCalculator.getTotal();
		
		assertEquals(30.20, total, 0);
	}
	
	@Test
	void applyDiscount() {
		priceCalculator.addPrice(12.50);
		priceCalculator.addPrice(17.50);
		priceCalculator.setDiscount(50);
		double total = priceCalculator.getTotal();
		
		assertEquals(15.00, total, 0);
	}
}
