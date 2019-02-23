package client;
import javax.websocket.*;
@ClientEndpoint public class WebSocketClient
{
    @OnClose public void onClose()
    {
        System.out.println("WebSocket Client: onClose()");
    }
    @OnError public void onError(Throwable throwable)
    {
        System.out.println("WebSocket Client: onError()");
        throwable.printStackTrace();
    }
    @OnMessage public void onMessage(String string)
    {
        System.out.println("WebSocket Client: onMessage()");
        System.out.println("WebSocket Server: "+string);
    }
    @OnOpen public void onOpen()
    {
        System.out.println("WebSocket Client: onOpen()");
    }
}
