package org.github.omnbmh.hprose.examples.server;

import hprose.server.HproseWebSocketService;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by chendezhi on 2016/10/24.
 */
@ServerEndpoint("/wshello")
public class WebSocketServer {
    private final HproseWebSocketService service = new HproseWebSocketService();
    public WebSocketServer() {
        service.add(new Hello());
    }
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        service.setConfig(config);
    }

    @OnMessage
    public void onMessage(ByteBuffer buf, Session session) throws IOException {
        service.handle(buf, session);
    }
    @OnError
    public void onError(Session session, Throwable error) {
        service.handleError(session, error);
    }
}
