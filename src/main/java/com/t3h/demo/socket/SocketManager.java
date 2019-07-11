package com.t3h.demo.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
//import io.socket.client.IO;
//import io.socket.client.Socket;
//import io.socket.emitter.Emitter;

@Component
public class SocketManager {
    private SocketIOServer socketIOServer;
    private Map<String, SocketIOClient> ioClientMap = new HashMap<>();

    @PostConstruct
    public void inits() {
        System.out.println("inits..............");
        Configuration config = new Configuration();
        config.setHostname("10.255.145.74");
        config.setPort(9092);
        socketIOServer = new SocketIOServer(config);
        socketIOServer.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                System.out.println("onConnect Test connect..........");
            }
        });
        socketIOServer.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient socketIOClient) {
                System.out.println("onDisconnect Test connect..........");
                for (String s : ioClientMap.keySet()) {
                    if (ioClientMap.get(s) == socketIOClient){
                        ioClientMap.remove(s);
                    }
                }
            }
        });
        socketIOServer.addEventListener("connected", String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient socketIOClient, String s, AckRequest ackRequest) throws Exception {
                System.out.println("onData Test connect.........."+s);
                ioClientMap.put(s, socketIOClient);
            }
        });

        socketIOServer.addEventListener("Message", String.class, new DataListener<String>() {
            @Override
            public void onData(SocketIOClient socketIOClient, String s, AckRequest ackRequest) throws Exception {
                System.out.println("onData Test connect.........."+s);
                String receriId = "dd";
                ioClientMap.put(s, socketIOClient);
            }
        });
        socketIOServer.start();
    }
}
