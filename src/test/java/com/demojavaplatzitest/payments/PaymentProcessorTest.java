package com.demojavaplatzitest.payments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
class PaymentProcessorTest {

	@Mock
	private PaymentGateway paymentGateway;
	
	@InjectMocks
	private PaymentProcessor paymentProcessor;
	
	@BeforeEach
	public void setUp() {
		paymentProcessor = new PaymentProcessor(paymentGateway);
	}
	
	@Test
	void paymentIsCorrect() {
		when(paymentGateway.requestPayment(any())).thenReturn(
				new PaymentResponse(PaymentResponse.PaymentStatus.OK));
		boolean resultMakePayment = paymentProcessor.makePayment(1000); 
		assertTrue(resultMakePayment);
	}
	
	@Test
	void paymentIsInCorrect() {
		when(paymentGateway.requestPayment(any())).thenReturn(
				new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
		boolean resultMakePayment = paymentProcessor.makePayment(1000); 
		assertFalse(resultMakePayment);
	}
}
