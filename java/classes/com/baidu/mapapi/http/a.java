package com.baidu.mapapi.http;

class a
  implements Runnable
{
  a(AsyncHttpClient paramAsyncHttpClient, HttpClient.ProtoResultCallback paramProtoResultCallback, String paramString) {}
  
  public void run()
  {
    HttpClient localHttpClient = new HttpClient(this.c.a, "GET", this.a);
    localHttpClient.setMaxTimeOut(AsyncHttpClient.a(this.c));
    localHttpClient.setReadTimeOut(AsyncHttpClient.b(this.c));
    localHttpClient.request(this.b);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/mapapi/http/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */