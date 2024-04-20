package com.example.demowebsocket.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.example.demowebsocket.handler.TutorialHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(tutorialHandler(), "/tutorial").setAllowedOrigins("*");
	}

	@Bean
	WebSocketHandler tutorialHandler() {
		return new TutorialHandler();
	}

	@Bean
	ServletServerContainerFactoryBean createWebSocketContainer() {
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		container.setMaxSessionIdleTimeout(TimeUnit.MINUTES.toMillis(5));
		container.setAsyncSendTimeout(TimeUnit.MINUTES.toMillis(3));
		return container;
	}
}
