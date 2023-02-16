package com.demojavaplatzitest.payments;

public interface PaymentGateway {

	PaymentResponse requestPayment(PaymentRequest request);
}
