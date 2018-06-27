package com.baidu.platform.comapi.a;

import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.mapapi.http.HttpClient.ProtoResultCallback;

class b
  extends HttpClient.ProtoResultCallback
{
  b(a parama, a.a parama1) {}
  
  public void onFailed(HttpClient.HttpStateError paramHttpStateError)
  {
    this.a.a(paramHttpStateError);
  }
  
  public void onSuccess(String paramString)
  {
    this.a.a(a.a(this.b, paramString));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/platform/comapi/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */