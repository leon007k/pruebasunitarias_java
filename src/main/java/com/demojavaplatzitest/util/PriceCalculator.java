package com.demojavaplatzitest.util;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

	private List<Double> prices = new ArrayList<>();
	private double discount;
	
	public double getTotal() {
		double result = 0;
		for (Double total : prices) {
			result += total;
		}
		// * Redondeamos los valores a dos digitos
		result = Math.round(result * 100d)/100d;
		
		// * aplicamos descuento
		result = result * (1 - (discount/100));
		return result;
	}

	public void addPrice(double price) {
		prices.add(price);
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
