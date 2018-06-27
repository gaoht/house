package c.a.b;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;

public abstract interface a
{
  public abstract void close();
  
  public abstract void close(int paramInt);
  
  public abstract void close(int paramInt, String paramString);
  
  public abstract void closeConnection(int paramInt, String paramString);
  
  public abstract c.a.b.c.a getDraft();
  
  public abstract InetSocketAddress getLocalSocketAddress();
  
  public abstract a getReadyState();
  
  public abstract InetSocketAddress getRemoteSocketAddress();
  
  public abstract String getResourceDescriptor();
  
  public abstract boolean hasBufferedData();
  
  public abstract boolean isClosed();
  
  public abstract boolean isClosing();
  
  public abstract boolean isConnecting();
  
  public abstract boolean isFlushAndClose();
  
  public abstract boolean isOpen();
  
  public abstract void send(String paramString)
    throws NotYetConnectedException;
  
  public abstract void send(ByteBuffer paramByteBuffer)
    throws IllegalArgumentException, NotYetConnectedException;
  
  public abstract void send(byte[] paramArrayOfByte)
    throws IllegalArgumentException, NotYetConnectedException;
  
  public abstract void sendFragmentedFrame(c.a.b.e.a.a parama, ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public abstract void sendFrame(c.a.b.e.a parama);
  
  public abstract void sendPing()
    throws NotYetConnectedException;
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/c/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */