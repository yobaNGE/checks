package org.chiches.checks;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ServerWebSocketHandler implements WebSocketHandler {
    Set<WebSocketSession> sessions = new HashSet<>();
    private final static Gson gson = new Gson();
    private final ServiceMain serviceMain;


    public ServerWebSocketHandler(ServiceMain serviceMain) {
        this.serviceMain = serviceMain;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        log.info("New connection: " + session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //log.info("Message received: " + message.getPayload());
        //index value
        String[] parts = message.getPayload().toString().replaceAll("\"", "").split(" ");
        if (parts.length == 2){
            int index = Integer.parseInt(parts[0]);
            boolean value = Boolean.parseBoolean(parts[1]);
            ArrayOfBools.setBool(index, value);
            sendToAllIgnore(message.getPayload().toString(), session);
        }else if (parts.length == 3){
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);     
            boolean value = Boolean.parseBoolean(parts[2]);
            serviceMain.setTwoDimBools(x, y, value);
            sendToAllIgnore(message.getPayload().toString(), session);
        }

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        sessions.remove(session);
        log.info("Connection closed: " + session.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendToAllIgnore(String message, WebSocketSession nesession) {
        sessions.forEach(session -> {
            if (!session.getId().equals(nesession.getId())) {
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}