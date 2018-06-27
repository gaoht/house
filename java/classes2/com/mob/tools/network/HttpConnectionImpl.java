package com.mob.tools.network;

import android.os.Build.VERSION;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ReflectHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpConnectionImpl
  implements HttpConnection
{
  private Object response;
  
  static
  {
    try
    {
      ReflectHelper.importClass("org.apache.http.HttpResponse");
      ReflectHelper.importClass("org.apache.http.Header");
      return;
    }
    catch (Throwable localThrowable)
    {
      MobLog.getInstance().w(localThrowable);
    }
  }
  
  public HttpConnectionImpl(Object paramObject)
  {
    this.response = paramObject;
  }
  
  public InputStream getErrorStream()
    throws IOException
  {
    return getInputStream();
  }
  
  public Map<String, List<String>> getHeaderFields()
    throws IOException
  {
    try
    {
      HashMap localHashMap = new HashMap();
      Object localObject = ReflectHelper.invokeInstanceMethod(this.response, "getAllHeaders", new Object[0]);
      if (localObject != null)
      {
        Object[] arrayOfObject = new Object[((Integer)ReflectHelper.getInstanceField(localObject, "length")).intValue()];
        System.arraycopy(localObject, 0, arrayOfObject, 0, arrayOfObject.length);
        int j = arrayOfObject.length;
        int i = 0;
        while (i < j)
        {
          localObject = arrayOfObject[i];
          String str2 = (String)ReflectHelper.invokeInstanceMethod(localObject, "getName", new Object[0]);
          String str1 = (String)ReflectHelper.invokeInstanceMethod(localObject, "getValue", new Object[0]);
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          localHashMap.put(str2, Arrays.asList(((String)localObject).split(",")));
          i += 1;
        }
      }
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      if (Build.VERSION.SDK_INT < 9) {
        throw new IOException(localThrowable.getMessage());
      }
      throw new IOException(localThrowable);
    }
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    try
    {
      InputStream localInputStream = (InputStream)ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.response, "getEntity", new Object[0]), "getContent", new Object[0]);
      return localInputStream;
    }
    catch (Throwable localThrowable)
    {
      if (Build.VERSION.SDK_INT < 9) {
        throw new IOException(localThrowable.getMessage());
      }
      throw new IOException(localThrowable);
    }
  }
  
  public int getResponseCode()
    throws IOException
  {
    try
    {
      int i = ((Integer)ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.response, "getStatusLine", new Object[0]), "getStatusCode", new Object[0])).intValue();
      return i;
    }
    catch (Throwable localThrowable)
    {
      if (Build.VERSION.SDK_INT < 9) {
        throw new IOException(localThrowable.getMessage());
      }
      throw new IOException(localThrowable);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/network/HttpConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */