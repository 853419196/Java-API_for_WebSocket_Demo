package server;
import java.io.*;
import javax.websocket.*;
import javax.websocket.server.*;
@ServerEndpoint("/websocket") public class WebSocketServer
{
    @OnClose public void onClose(Session session,CloseReason closeReason)
    {
        System.out.println("WebSocket Server: onClose()");
        System.out.println(closeReason);
    }
    @OnError public void onError(Session session,Throwable throwable)
    {
        System.out.println("WebSocket Server: onError()");
        throwable.printStackTrace();
    }
    @OnMessage public void onMessage(String string,Session session)
    {
        System.out.println("WebSocket Server: onMessage()");
        System.out.println("WebSocket Client: "+string);
        try
        {
            sendText(session,true,string+"? OK!");
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
    @OnOpen public void onOpen(Session session,EndpointConfig endpointConfig)
    {
        System.out.println("WebSocket Server: onOpen()");
    }
    private void sendText(Session session,boolean async,String string) throws IOException
    {
        if(async) session.getAsyncRemote().sendText(string);
        else session.getBasicRemote().sendText(string);
    }
}
