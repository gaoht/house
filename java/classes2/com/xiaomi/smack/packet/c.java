package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.text.TextUtils;

public class c
  extends d
{
  private String c = null;
  private String d = null;
  private String e;
  private String f;
  private String g;
  private String h;
  private boolean i = false;
  private String j;
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private boolean o = false;
  
  public c() {}
  
  public c(Bundle paramBundle)
  {
    super(paramBundle);
    this.c = paramBundle.getString("ext_msg_type");
    this.e = paramBundle.getString("ext_msg_lang");
    this.d = paramBundle.getString("ext_msg_thread");
    this.f = paramBundle.getString("ext_msg_sub");
    this.g = paramBundle.getString("ext_msg_body");
    this.h = paramBundle.getString("ext_body_encode");
    this.j = paramBundle.getString("ext_msg_appid");
    this.i = paramBundle.getBoolean("ext_msg_trans", false);
    this.o = paramBundle.getBoolean("ext_msg_encrypt", false);
    this.k = paramBundle.getString("ext_msg_seq");
    this.l = paramBundle.getString("ext_msg_mseq");
    this.m = paramBundle.getString("ext_msg_fseq");
    this.n = paramBundle.getString("ext_msg_status");
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.g = paramString1;
    this.h = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public Bundle b()
  {
    Bundle localBundle = super.b();
    if (!TextUtils.isEmpty(this.c)) {
      localBundle.putString("ext_msg_type", this.c);
    }
    if (this.e != null) {
      localBundle.putString("ext_msg_lang", this.e);
    }
    if (this.f != null) {
      localBundle.putString("ext_msg_sub", this.f);
    }
    if (this.g != null) {
      localBundle.putString("ext_msg_body", this.g);
    }
    if (!TextUtils.isEmpty(this.h)) {
      localBundle.putString("ext_body_encode", this.h);
    }
    if (this.d != null) {
      localBundle.putString("ext_msg_thread", this.d);
    }
    if (this.j != null) {
      localBundle.putString("ext_msg_appid", this.j);
    }
    if (this.i) {
      localBundle.putBoolean("ext_msg_trans", true);
    }
    if (!TextUtils.isEmpty(this.k)) {
      localBundle.putString("ext_msg_seq", this.k);
    }
    if (!TextUtils.isEmpty(this.l)) {
      localBundle.putString("ext_msg_mseq", this.l);
    }
    if (!TextUtils.isEmpty(this.m)) {
      localBundle.putString("ext_msg_fseq", this.m);
    }
    if (this.o) {
      localBundle.putBoolean("ext_msg_encrypt", true);
    }
    if (!TextUtils.isEmpty(this.n)) {
      localBundle.putString("ext_msg_status", this.n);
    }
    return localBundle;
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<message");
    if (t() != null) {
      localStringBuilder.append(" xmlns=\"").append(t()).append("\"");
    }
    if (this.e != null) {
      localStringBuilder.append(" xml:lang=\"").append(i()).append("\"");
    }
    if (k() != null) {
      localStringBuilder.append(" id=\"").append(k()).append("\"");
    }
    if (m() != null) {
      localStringBuilder.append(" to=\"").append(com.xiaomi.smack.util.d.a(m())).append("\"");
    }
    if (!TextUtils.isEmpty(e())) {
      localStringBuilder.append(" seq=\"").append(e()).append("\"");
    }
    if (!TextUtils.isEmpty(f())) {
      localStringBuilder.append(" mseq=\"").append(f()).append("\"");
    }
    if (!TextUtils.isEmpty(g())) {
      localStringBuilder.append(" fseq=\"").append(g()).append("\"");
    }
    if (!TextUtils.isEmpty(h())) {
      localStringBuilder.append(" status=\"").append(h()).append("\"");
    }
    if (n() != null) {
      localStringBuilder.append(" from=\"").append(com.xiaomi.smack.util.d.a(n())).append("\"");
    }
    if (l() != null) {
      localStringBuilder.append(" chid=\"").append(com.xiaomi.smack.util.d.a(l())).append("\"");
    }
    if (this.i) {
      localStringBuilder.append(" transient=\"true\"");
    }
    if (!TextUtils.isEmpty(this.j)) {
      localStringBuilder.append(" appid=\"").append(d()).append("\"");
    }
    if (!TextUtils.isEmpty(this.c)) {
      localStringBuilder.append(" type=\"").append(this.c).append("\"");
    }
    if (this.o) {
      localStringBuilder.append(" s=\"1\"");
    }
    localStringBuilder.append(">");
    if (this.f != null)
    {
      localStringBuilder.append("<subject>").append(com.xiaomi.smack.util.d.a(this.f));
      localStringBuilder.append("</subject>");
    }
    if (this.g != null)
    {
      localStringBuilder.append("<body");
      if (!TextUtils.isEmpty(this.h)) {
        localStringBuilder.append(" encode=\"").append(this.h).append("\"");
      }
      localStringBuilder.append(">").append(com.xiaomi.smack.util.d.a(this.g)).append("</body>");
    }
    if (this.d != null) {
      localStringBuilder.append("<thread>").append(this.d).append("</thread>");
    }
    if ("error".equalsIgnoreCase(this.c))
    {
      h localh = p();
      if (localh != null) {
        localStringBuilder.append(localh.b());
      }
    }
    localStringBuilder.append(s());
    localStringBuilder.append("</message>");
    return localStringBuilder.toString();
  }
  
  public void c(String paramString)
  {
    this.l = paramString;
  }
  
  public String d()
  {
    return this.j;
  }
  
  public void d(String paramString)
  {
    this.m = paramString;
  }
  
  public String e()
  {
    return this.k;
  }
  
  public void e(String paramString)
  {
    this.n = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    label99:
    label123:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool3;
                } while (paramObject == null);
                bool1 = bool3;
              } while (getClass() != paramObject.getClass());
              paramObject = (c)paramObject;
              bool1 = bool3;
            } while (!super.equals(paramObject));
            if (this.g == null) {
              break;
            }
            bool1 = bool3;
          } while (!this.g.equals(((c)paramObject).g));
          if (this.e == null) {
            break label171;
          }
          bool1 = bool3;
        } while (!this.e.equals(((c)paramObject).e));
        if (this.f == null) {
          break label180;
        }
        bool1 = bool3;
      } while (!this.f.equals(((c)paramObject).f));
      if (this.d == null) {
        break label189;
      }
      bool1 = bool3;
    } while (!this.d.equals(((c)paramObject).d));
    label147:
    if (this.c == ((c)paramObject).c) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      if (((c)paramObject).g == null) {
        break;
      }
      return false;
      label171:
      if (((c)paramObject).e == null) {
        break label99;
      }
      return false;
      label180:
      if (((c)paramObject).f == null) {
        break label123;
      }
      return false;
      label189:
      if (((c)paramObject).d == null) {
        break label147;
      }
      return false;
    }
  }
  
  public String f()
  {
    return this.l;
  }
  
  public void f(String paramString)
  {
    this.c = paramString;
  }
  
  public String g()
  {
    return this.m;
  }
  
  public void g(String paramString)
  {
    this.f = paramString;
  }
  
  public String h()
  {
    return this.n;
  }
  
  public void h(String paramString)
  {
    this.g = paramString;
  }
  
  public int hashCode()
  {
    int i5 = 0;
    int i1;
    int i2;
    label33:
    int i3;
    if (this.c != null)
    {
      i1 = this.c.hashCode();
      if (this.g == null) {
        break label109;
      }
      i2 = this.g.hashCode();
      if (this.d == null) {
        break label114;
      }
      i3 = this.d.hashCode();
      label48:
      if (this.e == null) {
        break label119;
      }
    }
    label109:
    label114:
    label119:
    for (int i4 = this.e.hashCode();; i4 = 0)
    {
      if (this.f != null) {
        i5 = this.f.hashCode();
      }
      return (i4 + (i3 + (i2 + i1 * 31) * 31) * 31) * 31 + i5;
      i1 = 0;
      break;
      i2 = 0;
      break label33;
      i3 = 0;
      break label48;
    }
  }
  
  public String i()
  {
    return this.e;
  }
  
  public void i(String paramString)
  {
    this.d = paramString;
  }
  
  public void j(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/smack/packet/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */