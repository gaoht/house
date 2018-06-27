package com.g.a;

import android.os.Process;
import java.util.Properties;
import java.util.zip.CRC32;

public class bj
  extends Properties
  implements Comparable
{
  private String a;
  private byte[] b;
  private int c;
  private int d;
  private CRC32 e;
  
  public bj(String paramString)
  {
    this.a = paramString;
  }
  
  private bj(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString);
    this.e = new CRC32();
    writeData(paramArrayOfByte);
  }
  
  public bj(byte[] paramArrayOfByte)
  {
    this(a(), paramArrayOfByte);
  }
  
  public static String a()
  {
    return System.currentTimeMillis() + "_" + Long.toString(Process.myPid());
  }
  
  public int a(bj parambj)
  {
    return b().compareTo(parambj.b());
  }
  
  public int a(String paramString)
  {
    return Integer.valueOf(super.getProperty(paramString)).intValue();
  }
  
  public int a(String paramString, int paramInt)
  {
    paramString = (String)setProperty(paramString, String.valueOf(paramInt));
    if (paramString == null) {
      return 0;
    }
    return Integer.valueOf(paramString).intValue();
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte);
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = (String)setProperty(paramString, a(paramArrayOfByte));
    if (paramString == null) {
      return null;
    }
    return c(paramString);
  }
  
  public String b()
  {
    return this.a;
  }
  
  public byte[] b(String paramString)
  {
    return c(super.getProperty(paramString));
  }
  
  public byte[] c()
  {
    return this.b;
  }
  
  public byte[] c(String paramString)
  {
    byte[] arrayOfByte = null;
    if (paramString != null) {
      arrayOfByte = paramString.getBytes();
    }
    return arrayOfByte;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public void writeData(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
    this.d = paramArrayOfByte.length;
    this.e.reset();
    this.e.update(paramArrayOfByte);
    this.c = ((int)this.e.getValue());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/g/a/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */