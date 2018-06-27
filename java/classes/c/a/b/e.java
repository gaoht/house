package c.a.b;

import c.a.b.a.f;
import c.a.b.a.h;
import c.a.b.a.i;
import c.a.b.d.b;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public abstract interface e
{
  public abstract String getFlashPolicy(a parama)
    throws b;
  
  public abstract InetSocketAddress getLocalSocketAddress(a parama);
  
  public abstract InetSocketAddress getRemoteSocketAddress(a parama);
  
  public abstract void onWebsocketClose(a parama, int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onWebsocketCloseInitiated(a parama, int paramInt, String paramString);
  
  public abstract void onWebsocketClosing(a parama, int paramInt, String paramString, boolean paramBoolean);
  
  public abstract void onWebsocketError(a parama, Exception paramException);
  
  public abstract void onWebsocketHandshakeReceivedAsClient(a parama, c.a.b.a.a parama1, h paramh)
    throws b;
  
  public abstract i onWebsocketHandshakeReceivedAsServer(a parama, c.a.b.c.a parama1, c.a.b.a.a parama2)
    throws b;
  
  public abstract void onWebsocketHandshakeSentAsClient(a parama, c.a.b.a.a parama1)
    throws b;
  
  public abstract void onWebsocketMessage(a parama, String paramString);
  
  public abstract void onWebsocketMessage(a parama, ByteBuffer paramByteBuffer);
  
  public abstract void onWebsocketMessageFragment(a parama, c.a.b.e.a parama1);
  
  public abstract void onWebsocketOpen(a parama, f paramf);
  
  public abstract void onWebsocketPing(a parama, c.a.b.e.a parama1);
  
  public abstract void onWebsocketPong(a parama, c.a.b.e.a parama1);
  
  public abstract void onWriteDemand(a parama);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */