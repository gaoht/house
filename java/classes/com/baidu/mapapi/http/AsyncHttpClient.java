package com.baidu.mapapi.http;

import android.content.Context;
import android.os.Build.VERSION;

public class AsyncHttpClient
{
  Context a;
  private int b = 4000;
  private int c = 4000;
  
  static
  {
    if (Build.VERSION.SDK_INT <= 8) {
      System.setProperty("http.keepAlive", "false");
    }
  }
  
  public AsyncHttpClient(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context cannot be null");
    }
    this.a = paramContext;
  }
  
  public void get(String paramString, HttpClient.ProtoResultCallback paramProtoResultCallback)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("URI cannot be null");
    }
    new Thread(new a(this, paramProtoResultCallback, paramString)).start();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/http/AsyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */