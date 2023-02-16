package com.demojavaplatzitest.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.demojavaplatzitest.app.DemojavaplatzitestApplication;

@SpringBootTest(classes = DemojavaplatzitestApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
class PlayerTest {
	
	@Mock
	private Dice dice;

	@InjectMocks
	private Player player;
	
	/*
	 *  la clase Player debe tener un constructor
	 *  que acepte un objeto de la clase Dice como argumento.
	 * */
	@BeforeEach
	public void setUp() {
		player = new Player(dice, 3);
	}
	
	@Test
	void looserWhenDiceNumberIsTooLow() {
		when(dice.roll()).thenReturn(2);
		boolean result = player.play();
		assertFalse(result);
	}
	
	@Test
	void winWhenDiceNumberIsBig() {
		when(dice.roll()).thenReturn(4);
		boolean result = player.play();
		assertTrue(result);
	}
}
