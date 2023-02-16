package com.demojavaplatzitest.payments;

public class PaymentProcessor {

	private PaymentGateway paymentGatway;
	
	public PaymentProcessor() {}
	
	public PaymentProcessor(PaymentGateway paymentGatway) {
		this.paymentGatway = paymentGatway;
	}
	
	public boolean makePayment(double amount) {
		PaymentResponse response = paymentGatway.requestPayment(
				new PaymentRequest(amount)); 
		return response.getStatus() == PaymentResponse.PaymentStatus.OK;
	}
}
