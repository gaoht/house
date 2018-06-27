package com.a.a.a;

import com.a.a.b.f;
import com.a.a.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class t
{
  public static void serialize(n paramn, OutputStream paramOutputStream, f paramf)
    throws c
  {
    if (paramf != null) {}
    for (;;)
    {
      if (paramf.getSort()) {
        paramn.sort();
      }
      new u().serialize(paramn, paramOutputStream, paramf);
      return;
      paramf = new f();
    }
  }
  
  public static byte[] serializeToBuffer(n paramn, f paramf)
    throws c
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(2048);
    serialize(paramn, localByteArrayOutputStream, paramf);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static String serializeToString(n paramn, f paramf)
    throws c
  {
    if (paramf != null) {}
    ByteArrayOutputStream localByteArrayOutputStream;
    for (;;)
    {
      paramf.setEncodeUTF16BE(true);
      localByteArrayOutputStream = new ByteArrayOutputStream(2048);
      serialize(paramn, localByteArrayOutputStream, paramf);
      try
      {
        paramn = localByteArrayOutputStream.toString(paramf.getEncoding());
        return paramn;
      }
      catch (UnsupportedEncodingException paramn) {}
      paramf = new f();
    }
    return localByteArrayOutputStream.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */