package com.unionpay.mobile.android.pboctransaction.nfc;

import android.nfc.tech.IsoDep;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class b
{
  public static final byte[] a = { 0 };
  protected byte[] b;
  
  protected b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = a;
    }
    this.b = arrayOfByte;
  }
  
  public byte[] a()
  {
    return this.b;
  }
  
  public String toString()
  {
    return c.a(this.b, this.b.length);
  }
  
  public static final class a
    extends b
  {
    public static final byte[] c = new byte[0];
    public static final byte[] d = { 111, 0 };
    
    public a(byte[] paramArrayOfByte)
    {
      super();
    }
    
    public final byte[] a()
    {
      if (b()) {
        return Arrays.copyOfRange(this.b, 0, this.b.length - 2);
      }
      return c;
    }
    
    public final boolean b()
    {
      byte[] arrayOfByte = this.b;
      int i = arrayOfByte.length;
      int j = arrayOfByte[(i - 2)];
      return (short)(arrayOfByte[(i - 1)] & 0xFF | j << 8) == 36864;
    }
  }
  
  public static final class b
  {
    private final IsoDep a;
    
    public b(IsoDep paramIsoDep)
    {
      this.a = paramIsoDep;
    }
    
    public static String c(byte[] paramArrayOfByte)
    {
      String str1 = "";
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        String str3 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        String str2 = str3;
        if (str3.length() == 1) {
          str2 = "0" + str3;
        }
        str1 = str1 + str2.toUpperCase() + " ";
        i += 1;
      }
      return str1;
    }
    
    public final b.a a(byte... paramVarArgs)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramVarArgs.length + 6);
      localByteBuffer.put((byte)0).put((byte)-92).put((byte)4).put((byte)0).put((byte)paramVarArgs.length).put(paramVarArgs).put((byte)0);
      Log.e("PBOC Transceive", c(localByteBuffer.array()));
      paramVarArgs = new b.a(b(localByteBuffer.array()));
      Log.e("PBOC receive", c(paramVarArgs.a()));
      return paramVarArgs;
    }
    
    public final void a()
    {
      try
      {
        this.a.connect();
        return;
      }
      catch (Exception localException) {}
    }
    
    public final byte[] b(byte[] paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = this.a.transceive(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte) {}
      return b.a.d;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/pboctransaction/nfc/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */