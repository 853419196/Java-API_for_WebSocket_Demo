import client.*;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import javax.websocket.*;
public class Main
{
    private static Scanner in=new Scanner(System.in);
    public static void main(String...args) throws DeploymentException,IOException
    {
        WebSocketContainer iWebSocketContainer=ContainerProvider.getWebSocketContainer();
        try(Session iSession=
            iWebSocketContainer.connectToServer(WebSocketClient.class,URI.create("ws://localhost:8080/Main/websocket")))
        {
            while(in.hasNextLine())
            {
                sendText(iSession,true,in.nextLine());
            }
        }
    }
    public static void sendText(Session session,boolean async,String string) throws IOException
    {
        if(session.isOpen())
        {
            if(async) session.getAsyncRemote().sendText(string);
            else session.getBasicRemote().sendText(string);
        }
        else System.out.println("Session is closed");
    }
}