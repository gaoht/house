package cn.jiguang.net;

import cn.jiguang.f.h;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse
{
  private static final String[] z;
  private String a;
  private String b;
  private Map<String, Object> c;
  private int d;
  private long e;
  private boolean f;
  private boolean g;
  private int h = -1;
  
  static
  {
    String[] arrayOfString = new String[6];
    int j = 0;
    Object localObject2 = "K&|\033)\027i`\r?$ij\033g";
    int i = -1;
    Object localObject1 = arrayOfString;
    char[] arrayOfChar = ((String)localObject2).toCharArray();
    int k = arrayOfChar.length;
    int i1 = 0;
    int m = 0;
    int i3 = i;
    localObject2 = arrayOfChar;
    int i4 = j;
    Object localObject3 = localObject1;
    int n = k;
    Object localObject4;
    int i2;
    if (k <= 1)
    {
      localObject4 = localObject1;
      localObject1 = arrayOfChar;
      i2 = i;
      label68:
      n = m;
      label71:
      localObject2 = localObject1;
      i1 = localObject2[m];
      switch (n % 5)
      {
      default: 
        i = 90;
      }
    }
    for (;;)
    {
      localObject2[m] = ((char)(i ^ i1));
      n += 1;
      if (k == 0)
      {
        m = k;
        break label71;
      }
      i1 = n;
      n = k;
      localObject3 = localObject4;
      i4 = j;
      localObject2 = localObject1;
      i3 = i2;
      i2 = i3;
      localObject1 = localObject2;
      j = i4;
      localObject4 = localObject3;
      k = n;
      m = i1;
      if (n > i1) {
        break label68;
      }
      localObject1 = new String((char[])localObject2).intern();
      switch (i3)
      {
      default: 
        localObject3[i4] = localObject1;
        j = 1;
        localObject2 = "/rz\016\b\002u~\0214\024cu\f?\024va\020)\002Da\032#Z!";
        i = 0;
        localObject1 = arrayOfString;
        break;
      case 0: 
        localObject3[i4] = localObject1;
        j = 2;
        localObject2 = "\002~~\027(\002u";
        i = 1;
        localObject1 = arrayOfString;
        break;
      case 1: 
        localObject3[i4] = localObject1;
        j = 3;
        localObject2 = "3nk^.\036vk^5\001&F\n.\027Tk\r*\bh}\033z\004g`\0205\023&l\033z\024ko\0226\002t.\n2\006h.Nt";
        i = 2;
        localObject1 = arrayOfString;
        break;
      case 2: 
        localObject3[i4] = localObject1;
        j = 4;
        localObject2 = "\ngvS;\000c3";
        i = 3;
        localObject1 = arrayOfString;
        break;
      case 3: 
        localObject3[i4] = localObject1;
        j = 5;
        localObject2 = "\004gm\026?Jea\020.\025ib";
        i = 4;
        localObject1 = arrayOfString;
        break;
      case 4: 
        localObject3[i4] = localObject1;
        z = arrayOfString;
        return;
        i = 103;
        continue;
        i = 6;
        continue;
        i = 14;
        continue;
        i = 126;
      }
    }
  }
  
  public HttpResponse()
  {
    this.c = new HashMap();
  }
  
  public HttpResponse(String paramString)
  {
    this.a = paramString;
    this.d = 0;
    this.f = false;
    this.g = false;
    this.c = new HashMap();
  }
  
  private int a()
  {
    try
    {
      String str = (String)this.c.get(z[5]);
      if (!h.a(str))
      {
        int i = str.indexOf(z[4]);
        if (i != -1)
        {
          int j = str.indexOf(",", i);
          if (j != -1) {}
          for (str = str.substring(i + 8, j);; str = str.substring(i + 8)) {
            return Integer.parseInt(str);
          }
        }
      }
      return -1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public long getExpiredTime()
  {
    if (this.g) {
      return this.e;
    }
    this.g = true;
    int i = a();
    long l;
    if (i != -1)
    {
      l = System.currentTimeMillis();
      l = i * 1000 + l;
    }
    for (;;)
    {
      this.e = l;
      return l;
      if (!h.a(getExpiresHeader())) {
        l = HttpUtils.parseGmtTime(getExpiresHeader());
      } else {
        l = -1L;
      }
    }
  }
  
  public String getExpiresHeader()
  {
    try
    {
      if (this.c == null) {
        return null;
      }
      String str = (String)this.c.get(z[2]);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public String getResponseBody()
  {
    return this.b;
  }
  
  public int getResponseCode()
  {
    return this.h;
  }
  
  public int getType()
  {
    return this.d;
  }
  
  public String getUrl()
  {
    return this.a;
  }
  
  public boolean isExpired()
  {
    return System.currentTimeMillis() > this.e;
  }
  
  public boolean isInCache()
  {
    return this.f;
  }
  
  public void setExpiredTime(long paramLong)
  {
    this.g = true;
    this.e = paramLong;
  }
  
  public HttpResponse setInCache(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public void setResponseBody(String paramString)
  {
    this.b = paramString;
  }
  
  public void setResponseCode(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setResponseHeader(String paramString1, String paramString2)
  {
    if (this.c != null) {
      this.c.put(paramString1, paramString2);
    }
  }
  
  public void setResponseHeaders(Map<String, Object> paramMap)
  {
    this.c = paramMap;
  }
  
  public void setType(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException(z[3]);
    }
    this.d = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    return z[1] + this.b + '\'' + z[0] + this.h + '}';
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/jiguang/net/HttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */