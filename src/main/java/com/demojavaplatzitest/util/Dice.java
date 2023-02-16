package com.demojavaplatzitest.util;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Logger;

public class Dice {

	private int sides;
	private Random rand;
	
	public Dice(int sides) {
		this.sides = sides;
	}
	
	public int roll() {
		try {
			rand = SecureRandom.getInstanceStrong();
		}catch(NoSuchAlgorithmException e) {
		Logger.getLogger("Error al inicializar SecureRandom: " + e.getMessage());
			rand = new Random();
		}
		return this.rand.nextInt(sides) + 1;
	}
}
