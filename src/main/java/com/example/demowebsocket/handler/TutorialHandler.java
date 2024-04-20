package com.example.demowebsocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TutorialHandler implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("conexion abierta {}", session.getId());
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String tutorial = String.valueOf(message.getPayload());
		log.info("Message: {}", tutorial);
		String textMessage = String.format("sesion iniciada: %s, tutorial: %s", session, tutorial);
		session.sendMessage(new TextMessage(textMessage));
		Thread.sleep(1000);
		textMessage = String.format("session completada para el tutorial: %s", tutorial);
		session.sendMessage(new TextMessage(textMessage));
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.error("ha ocurrido un error, sesion: {}, errorMessage: {}", session.getId(), exception.getMessage());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		log.info("conexion cerrada: session: {}, status: {}", session.getId(), closeStatus.getCode());
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
