package com.ziroom.commonlib.ziroomhttp.b;

import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class a
  extends e
{
  protected RequestBody a;
  
  public a addHeader(String paramString1, String paramString2)
  {
    super.addHeader(paramString1, paramString2);
    return this;
  }
  
  public a addParam(String paramString1, String paramString2)
  {
    super.addParam(paramString1, paramString2);
    return this;
  }
  
  public Call enqueue(Callback paramCallback)
  {
    return a("DELETE", paramCallback);
  }
  
  public Response execute()
    throws IOException
  {
    return a("DELETE");
  }
  
  public a headers(Map<String, String> paramMap)
  {
    super.headers(paramMap);
    return this;
  }
  
  public a params(Map<String, String> paramMap)
  {
    super.params(paramMap);
    return this;
  }
  
  public a setBodyString(String paramString)
  {
    return setBodyString("text/plain", paramString);
  }
  
  public a setBodyString(String paramString1, String paramString2)
  {
    this.a = RequestBody.create(MediaType.parse(paramString1), paramString2);
    return this;
  }
  
  public a tag(Object paramObject)
  {
    super.tag(paramObject);
    return this;
  }
  
  public a url(String paramString)
  {
    super.url(paramString);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlib/ziroomhttp/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */