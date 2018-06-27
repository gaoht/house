package com.xiaomi.smack.packet;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
  extends d
{
  private a c = a.a;
  private final Map<String, String> d = new HashMap();
  
  public b() {}
  
  public b(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.containsKey("ext_iq_type")) {
      this.c = a.a(paramBundle.getString("ext_iq_type"));
    }
  }
  
  public a a()
  {
    return this.c;
  }
  
  public void a(a parama)
  {
    if (parama == null)
    {
      this.c = a.a;
      return;
    }
    this.c = parama;
  }
  
  public void a(Map<String, String> paramMap)
  {
    try
    {
      this.d.putAll(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public Bundle b()
  {
    Bundle localBundle = super.b();
    if (this.c != null) {
      localBundle.putString("ext_iq_type", this.c.toString());
    }
    return localBundle;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<iq ");
    if (k() != null) {
      localStringBuilder.append("id=\"" + k() + "\" ");
    }
    if (m() != null) {
      localStringBuilder.append("to=\"").append(com.xiaomi.smack.util.d.a(m())).append("\" ");
    }
    if (n() != null) {
      localStringBuilder.append("from=\"").append(com.xiaomi.smack.util.d.a(n())).append("\" ");
    }
    if (l() != null) {
      localStringBuilder.append("chid=\"").append(com.xiaomi.smack.util.d.a(l())).append("\" ");
    }
    Object localObject = this.d.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append(com.xiaomi.smack.util.d.a((String)localEntry.getKey())).append("=\"");
      localStringBuilder.append(com.xiaomi.smack.util.d.a((String)localEntry.getValue())).append("\" ");
    }
    if (this.c == null) {
      localStringBuilder.append("type=\"get\">");
    }
    for (;;)
    {
      localObject = d();
      if (localObject != null) {
        localStringBuilder.append((String)localObject);
      }
      localStringBuilder.append(s());
      localObject = p();
      if (localObject != null) {
        localStringBuilder.append(((h)localObject).b());
      }
      localStringBuilder.append("</iq>");
      return localStringBuilder.toString();
      localStringBuilder.append("type=\"").append(a()).append("\">");
    }
  }
  
  public String d()
  {
    return null;
  }
  
  public static class a
  {
    public static final a a = new a("get");
    public static final a b = new a("set");
    public static final a c = new a("result");
    public static final a d = new a("error");
    public static final a e = new a("command");
    private String f;
    
    private a(String paramString)
    {
      this.f = paramString;
    }
    
    public static a a(String paramString)
    {
      if (paramString == null) {}
      do
      {
        return null;
        paramString = paramString.toLowerCase();
        if (a.toString().equals(paramString)) {
          return a;
        }
        if (b.toString().equals(paramString)) {
          return b;
        }
        if (d.toString().equals(paramString)) {
          return d;
        }
        if (c.toString().equals(paramString)) {
          return c;
        }
      } while (!e.toString().equals(paramString));
      return e;
    }
    
    public String toString()
    {
      return this.f;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/packet/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */