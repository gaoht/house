package com.superrtc.call;

import java.nio.ByteBuffer;

public class DataChannel
{
  private final long a;
  private long b;
  
  public DataChannel(long paramLong)
  {
    this.a = paramLong;
  }
  
  private native long registerObserverNative(c paramc);
  
  private native boolean sendNative(byte[] paramArrayOfByte, boolean paramBoolean);
  
  private native void unregisterObserverNative(long paramLong);
  
  public native long bufferedAmount();
  
  public native void close();
  
  public native void dispose();
  
  public native String label();
  
  public void registerObserver(c paramc)
  {
    if (this.b != 0L) {
      unregisterObserverNative(this.b);
    }
    this.b = registerObserverNative(paramc);
  }
  
  public boolean send(a parama)
  {
    byte[] arrayOfByte = new byte[parama.a.remaining()];
    parama.a.get(arrayOfByte);
    return sendNative(arrayOfByte, parama.b);
  }
  
  public native d state();
  
  public void unregisterObserver()
  {
    unregisterObserverNative(this.b);
  }
  
  public static class a
  {
    public final ByteBuffer a;
    public final boolean b;
    
    public a(ByteBuffer paramByteBuffer, boolean paramBoolean)
    {
      this.a = paramByteBuffer;
      this.b = paramBoolean;
    }
  }
  
  public static class b
  {
    public boolean a = true;
    public int b = -1;
    public int c = -1;
    public String d = "";
    public boolean e = false;
    public int f = -1;
  }
  
  public static abstract interface c
  {
    public abstract void onBufferedAmountChange(long paramLong);
    
    public abstract void onMessage(DataChannel.a parama);
    
    public abstract void onStateChange();
  }
  
  public static enum d
  {
    private d() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/call/DataChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */