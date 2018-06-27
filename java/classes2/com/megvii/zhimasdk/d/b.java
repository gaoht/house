package com.megvii.zhimasdk.d;

import android.content.Context;
import android.content.res.Resources;
import android.util.Base64;
import com.megvii.zhimasdk.R.raw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class b
{
  public static double a(Collection<Double> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    for (double d = 0.0D; paramCollection.hasNext(); d = ((Double)paramCollection.next()).doubleValue() + d) {}
    return d;
  }
  
  public static final String a(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        for (paramArrayOfByte = Integer.toHexString(localObject[i] & 0xFF); paramArrayOfByte.length() < 2; paramArrayOfByte = "0" + paramArrayOfByte) {}
        localStringBuilder.append(paramArrayOfByte);
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return "";
  }
  
  public static byte[] a(Context paramContext)
  {
    localObject = null;
    Context localContext = null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    try
    {
      paramContext = paramContext.getResources().openRawResource(R.raw.livenessmodel);
      for (;;)
      {
        localContext = paramContext;
        localObject = paramContext;
        int i = paramContext.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localContext = paramContext;
        localObject = paramContext;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      try
      {
        ((InputStream)localObject).close();
        throw paramContext;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    catch (IOException paramContext)
    {
      localObject = localContext;
      paramContext.printStackTrace();
      if (localContext != null) {}
      try
      {
        localContext.close();
        for (;;)
        {
          return localByteArrayOutputStream.toByteArray();
          localContext = paramContext;
          localObject = paramContext;
          localByteArrayOutputStream.close();
          if (paramContext != null) {
            try
            {
              paramContext.close();
            }
            catch (IOException paramContext)
            {
              paramContext.printStackTrace();
            }
          }
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject == null) {}
    }
  }
  
  public static String b(Context paramContext)
  {
    n localn = new n(paramContext);
    String str = localn.a("key_uuid");
    if (str != null) {
      return str;
    }
    if (str != null)
    {
      paramContext = str;
      if (str.trim().length() != 0) {}
    }
    else
    {
      paramContext = Base64.encodeToString(UUID.randomUUID().toString().getBytes(), 0);
    }
    localn.a("key_uuid", paramContext);
    return paramContext;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */