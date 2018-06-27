package com.megvii.zhimasdk.b.a.i.c;

import com.megvii.zhimasdk.b.a.h.b;
import com.megvii.zhimasdk.b.a.o.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class r
{
  public b a;
  private final String b;
  
  public r(b paramb)
  {
    this(paramb, "");
  }
  
  public r(b paramb, String paramString)
  {
    this.a = paramb;
    this.b = paramString;
  }
  
  private void a(String paramString, InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramInputStream.read();
      if (i == -1) {
        break;
      }
      if (i == 13)
      {
        localStringBuilder.append("[\\r]");
      }
      else if (i == 10)
      {
        localStringBuilder.append("[\\n]\"");
        localStringBuilder.insert(0, "\"");
        localStringBuilder.insert(0, paramString);
        this.a.a(this.b + " " + localStringBuilder.toString());
        localStringBuilder.setLength(0);
      }
      else if ((i < 32) || (i > 127))
      {
        localStringBuilder.append("[0x");
        localStringBuilder.append(Integer.toHexString(i));
        localStringBuilder.append("]");
      }
      else
      {
        localStringBuilder.append((char)i);
      }
    }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.append('"');
      localStringBuilder.insert(0, '"');
      localStringBuilder.insert(0, paramString);
      this.a.a(this.b + " " + localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    a(new byte[] { (byte)paramInt });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a.a(paramArrayOfByte, "Output");
    a(">> ", new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.a(paramArrayOfByte, "Output");
    a(">> ", new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public void b(int paramInt)
  {
    b(new byte[] { (byte)paramInt });
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    a.a(paramArrayOfByte, "Input");
    a("<< ", new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a.a(paramArrayOfByte, "Input");
    a("<< ", new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/i/c/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */