package com.example.demowebsocket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class DemoWebsocketApplicationTests {

	@Test
	void contextLoads() {
		long millis = TimeUnit.MINUTES.toMillis(3);
		assertEquals(180000, millis);
	}

}
