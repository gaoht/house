package c.a.b;

import c.a.b.d.b;
import c.a.b.d.d;
import java.net.InetSocketAddress;

public abstract class c
  implements e
{
  public String getFlashPolicy(a parama)
    throws b
  {
    parama = parama.getLocalSocketAddress();
    if (parama == null) {
      throw new d("socket not bound");
    }
    return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + parama.getPort() + "\" /></cross-domain-policy>\000";
  }
  
  public void onWebsocketHandshakeReceivedAsClient(a parama, c.a.b.a.a parama1, c.a.b.a.h paramh)
    throws b
  {}
  
  public c.a.b.a.i onWebsocketHandshakeReceivedAsServer(a parama, c.a.b.c.a parama1, c.a.b.a.a parama2)
    throws b
  {
    return new c.a.b.a.e();
  }
  
  public void onWebsocketHandshakeSentAsClient(a parama, c.a.b.a.a parama1)
    throws b
  {}
  
  public void onWebsocketMessageFragment(a parama, c.a.b.e.a parama1) {}
  
  public void onWebsocketPing(a parama, c.a.b.e.a parama1)
  {
    parama.sendFrame(new c.a.b.e.i((c.a.b.e.h)parama1));
  }
  
  public void onWebsocketPong(a parama, c.a.b.e.a parama1) {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */