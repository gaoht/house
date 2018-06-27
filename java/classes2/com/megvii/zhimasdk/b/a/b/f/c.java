package com.megvii.zhimasdk.b.a.b.f;

import com.megvii.zhimasdk.b.a.e.e.a;
import com.megvii.zhimasdk.b.a.y;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class c
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private String h;
  private String i;
  private String j;
  private List<y> k;
  private String l;
  private String m;
  private String n;
  
  public c()
  {
    this.g = -1;
  }
  
  public c(URI paramURI)
  {
    a(paramURI);
  }
  
  private List<y> a(String paramString, Charset paramCharset)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return e.a(paramString, paramCharset);
    }
    return null;
  }
  
  private void a(URI paramURI)
  {
    this.a = paramURI.getScheme();
    this.b = paramURI.getRawSchemeSpecificPart();
    this.c = paramURI.getRawAuthority();
    this.f = paramURI.getHost();
    this.g = paramURI.getPort();
    this.e = paramURI.getRawUserInfo();
    this.d = paramURI.getUserInfo();
    this.i = paramURI.getRawPath();
    this.h = paramURI.getPath();
    this.j = paramURI.getRawQuery();
    this.k = a(paramURI.getRawQuery(), com.megvii.zhimasdk.b.a.c.a);
    this.n = paramURI.getRawFragment();
    this.m = paramURI.getFragment();
  }
  
  private String b(List<y> paramList)
  {
    return e.a(paramList, com.megvii.zhimasdk.b.a.c.a);
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null) {
      localStringBuilder.append(this.a).append(':');
    }
    if (this.b != null)
    {
      localStringBuilder.append(this.b);
      if (this.n == null) {
        break label345;
      }
      localStringBuilder.append("#").append(this.n);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (this.c != null)
      {
        localStringBuilder.append("//").append(this.c);
        label92:
        if (this.i == null) {
          break label263;
        }
        localStringBuilder.append(i(this.i));
      }
      for (;;)
      {
        if (this.j == null) {
          break label289;
        }
        localStringBuilder.append("?").append(this.j);
        break;
        if (this.f == null) {
          break label92;
        }
        localStringBuilder.append("//");
        if (this.e != null)
        {
          localStringBuilder.append(this.e).append("@");
          label170:
          if (!a.d(this.f)) {
            break label251;
          }
          localStringBuilder.append("[").append(this.f).append("]");
        }
        for (;;)
        {
          if (this.g < 0) {
            break label261;
          }
          localStringBuilder.append(":").append(this.g);
          break;
          if (this.d == null) {
            break label170;
          }
          localStringBuilder.append(f(this.d)).append("@");
          break label170;
          label251:
          localStringBuilder.append(this.f);
        }
        label261:
        break label92;
        label263:
        if (this.h != null) {
          localStringBuilder.append(g(i(this.h)));
        }
      }
      label289:
      if (this.k != null)
      {
        localStringBuilder.append("?").append(b(this.k));
        break;
      }
      if (this.l == null) {
        break;
      }
      localStringBuilder.append("?").append(h(this.l));
      break;
      label345:
      if (this.m != null) {
        localStringBuilder.append("#").append(h(this.m));
      }
    }
  }
  
  private String f(String paramString)
  {
    return e.b(paramString, com.megvii.zhimasdk.b.a.c.a);
  }
  
  private String g(String paramString)
  {
    return e.d(paramString, com.megvii.zhimasdk.b.a.c.a);
  }
  
  private String h(String paramString)
  {
    return e.c(paramString, com.megvii.zhimasdk.b.a.c.a);
  }
  
  private static String i(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = null;
      return str;
    }
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= paramString.length()) || (paramString.charAt(i1) != '/'))
      {
        str = paramString;
        if (i1 <= 1) {
          break;
        }
        return paramString.substring(i1 - 1);
      }
      i1 += 1;
    }
  }
  
  public c a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = -1;
    }
    this.g = i1;
    this.b = null;
    this.c = null;
    return this;
  }
  
  public c a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public c a(List<y> paramList)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    this.k.addAll(paramList);
    this.j = null;
    this.b = null;
    this.l = null;
    return this;
  }
  
  public URI a()
  {
    return new URI(e());
  }
  
  public c b(String paramString)
  {
    this.d = paramString;
    this.b = null;
    this.c = null;
    this.e = null;
    return this;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public c c(String paramString)
  {
    this.f = paramString;
    this.b = null;
    this.c = null;
    return this;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public c d(String paramString)
  {
    this.h = paramString;
    this.b = null;
    this.i = null;
    return this;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public c e(String paramString)
  {
    this.m = paramString;
    this.n = null;
    return this;
  }
  
  public String toString()
  {
    return e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/megvii/zhimasdk/b/a/b/f/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */