package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest
{
  private static final String[] z;
  private String a;
  private int b;
  private int c;
  private Map<String, String> d;
  private Map<String, String> e;
  private Object f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j = true;
  
  static
  {
    String[] arrayOfString = new String[2];
    Object localObject2 = "8\034U5|9\001\0303r\"UV?gl\027]p})\022Y$z:\020";
    int n = -1;
    int i1 = 0;
    Object localObject1 = arrayOfString;
    localObject2 = ((String)localObject2).toCharArray();
    int m = localObject2.length;
    int k;
    Object localObject3;
    int i2;
    int i3;
    label50:
    int i4;
    label99:
    label121:
    Object localObject4;
    int i5;
    if (m <= 1)
    {
      k = 0;
      localObject3 = localObject1;
      i2 = i1;
      localObject1 = localObject2;
      i3 = n;
      i1 = k;
      for (n = k;; n = m)
      {
        localObject2 = localObject1;
        i4 = localObject2[n];
        switch (i1 % 5)
        {
        default: 
          k = 19;
          localObject2[n] = ((char)(k ^ i4));
          i1 += 1;
          if (m != 0) {
            break label121;
          }
        }
      }
      n = m;
      localObject4 = localObject3;
      i5 = i2;
      localObject2 = localObject1;
      i4 = i3;
    }
    for (;;)
    {
      i3 = i4;
      localObject1 = localObject2;
      i2 = i5;
      localObject3 = localObject4;
      m = n;
      k = i1;
      if (n > i1) {
        break label50;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i4)
      {
      default: 
        localObject4[i5] = localObject1;
        localObject2 = "\031\006]\">\r\022]>g";
        i1 = 1;
        n = 0;
        break;
      case 0: 
        localObject4[i5] = localObject1;
        z = arrayOfString;
        return;
        k = 76;
        break label99;
        k = 117;
        break label99;
        k = 56;
        break label99;
        k = 80;
        break label99;
        k = 0;
        i4 = n;
        i5 = i1;
        localObject4 = localObject1;
        n = m;
        i1 = k;
      }
    }
  }
  
  public HttpRequest(String paramString)
  {
    this.a = paramString;
    this.b = -1;
    this.c = -1;
    this.e = new HashMap();
  }
  
  public HttpRequest(String paramString, Map<String, String> paramMap)
  {
    this.a = paramString;
    this.d = paramMap;
    this.b = -1;
    this.c = -1;
    this.e = new HashMap();
  }
  
  public Object getBody()
  {
    return this.f;
  }
  
  public int getConnectTimeout()
  {
    return this.b;
  }
  
  public byte[] getParas()
  {
    if (this.f != null) {
      if ((this.f instanceof String))
      {
        if (!TextUtils.isEmpty((CharSequence)this.f)) {
          return ((String)this.f).getBytes();
        }
      }
      else if ((this.f instanceof byte[])) {
        return (byte[])this.f;
      }
    }
    String str = HttpUtils.joinParasWithEncodedValue(this.d);
    if (!TextUtils.isEmpty(str)) {
      return str.getBytes();
    }
    return null;
  }
  
  public Map<String, String> getParasMap()
  {
    return this.d;
  }
  
  public int getReadTimeout()
  {
    return this.c;
  }
  
  public Map<String, String> getRequestProperties()
  {
    return this.e;
  }
  
  public String getRequestProperty(String paramString)
  {
    return (String)this.e.get(paramString);
  }
  
  public String getUrl()
  {
    return this.a;
  }
  
  public boolean isDoInPut()
  {
    return this.h;
  }
  
  public boolean isDoOutPut()
  {
    return this.g;
  }
  
  public boolean isHaveRspData()
  {
    return this.j;
  }
  
  public boolean isUseCaches()
  {
    return this.i;
  }
  
  public void setBody(Object paramObject)
  {
    this.f = paramObject;
  }
  
  public void setConnectTimeout(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException(z[0]);
    }
    this.b = paramInt;
  }
  
  public void setDoInPut(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setDoOutPut(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setHaveRspData(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setParasMap(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public void setReadTimeout(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException(z[0]);
    }
    this.c = paramInt;
  }
  
  public void setRequestProperties(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    this.e.put(paramString1, paramString2);
  }
  
  public void setUrl(String paramString)
  {
    this.a = paramString;
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setUserAgent(String paramString)
  {
    this.e.put(z[1], paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/net/HttpRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */