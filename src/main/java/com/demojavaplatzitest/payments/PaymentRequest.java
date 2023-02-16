package com.demojavaplatzitest.payments;

public class PaymentRequest {

	private double amout;
	
	public PaymentRequest(double amount) {
		this.amout = amount;
	}

	public double getAmout() {
		return amout;
	}

	public void setAmout(double amout) {
		this.amout = amout;
	}
	
}
