package com.freelxl.baselibrary.d.b;

import com.freelxl.baselibrary.d.c.b;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class c
  extends e
{
  public c addFormDataPart(String paramString1, String paramString2)
  {
    if (this.b == null) {
      this.b = new MultipartBody.Builder().setType(MultipartBody.FORM);
    }
    this.b.addFormDataPart(paramString1, paramString2);
    return this;
  }
  
  public c addFormDataPart(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.b == null) {
      this.b = new MultipartBody.Builder().setType(MultipartBody.FORM);
    }
    this.b.addFormDataPart(paramString1, paramString2, RequestBody.create(MediaType.parse(paramString3), new File(paramString4)));
    return this;
  }
  
  public c addHeader(String paramString1, String paramString2)
  {
    super.addHeader(paramString1, paramString2);
    return this;
  }
  
  public c addParam(String paramString1, String paramString2)
  {
    super.addParam(paramString1, paramString2);
    return this;
  }
  
  public c addReqProgressCallback(b paramb)
  {
    this.d = paramb;
    return this;
  }
  
  public Call enqueue(Callback paramCallback)
  {
    return a("POST", paramCallback);
  }
  
  public Response execute()
    throws IOException
  {
    return a("POST");
  }
  
  public c headers(Map<String, String> paramMap)
  {
    super.headers(paramMap);
    return this;
  }
  
  public c params(Map<String, String> paramMap)
  {
    super.params(paramMap);
    return this;
  }
  
  public c setBodyBytes(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = MediaType.parse(paramString))
    {
      this.c = RequestBody.create(paramString, paramArrayOfByte);
      return this;
    }
  }
  
  public c setBodyBytes(byte[] paramArrayOfByte)
  {
    return setBodyBytes(null, paramArrayOfByte);
  }
  
  public c setBodyFile(File paramFile)
  {
    return setBodyFile(null, paramFile);
  }
  
  public c setBodyFile(String paramString, File paramFile)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = MediaType.parse(paramString))
    {
      this.c = RequestBody.create(paramString, paramFile);
      return this;
    }
  }
  
  public c setBodyString(String paramString)
  {
    return setBodyString("text/plain", paramString);
  }
  
  public c setBodyString(String paramString1, String paramString2)
  {
    this.c = RequestBody.create(MediaType.parse(paramString1), paramString2);
    return this;
  }
  
  public c setReadTimeOut(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public c setWriteTimeOut(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public c tag(Object paramObject)
  {
    super.tag(paramObject);
    return this;
  }
  
  public c url(String paramString)
  {
    super.url(paramString);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/d/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */