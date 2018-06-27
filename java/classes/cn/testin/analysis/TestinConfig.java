package cn.testin.analysis;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import javax.net.ssl.SSLSocketFactory;

public class TestinConfig
{
  private String a;
  private String b;
  private String c;
  private Boolean d;
  private Boolean e;
  private Boolean f;
  private Boolean g;
  private Boolean h;
  private SSLSocketFactory i;
  private SSLSocketFactory j;
  private HashMap<String, Object> k = new HashMap();
  
  protected void a(Context paramContext)
  {
    if (!TextUtils.isEmpty(this.a)) {
      al.a(paramContext, this.a);
    }
    if (!TextUtils.isEmpty(this.b)) {
      a.b = this.b;
    }
    if (!TextUtils.isEmpty(this.c)) {
      a.c = this.c;
    }
    if (this.d != null) {
      a.k = this.d.booleanValue();
    }
    if (this.f != null) {
      a.l = this.f.booleanValue();
    }
    if (this.e != null) {
      a.j = this.e.booleanValue();
    }
    if (this.g != null) {
      a.n = this.g.booleanValue();
    }
    if (this.i != null) {
      a.q = this.i;
    }
    if (this.j != null) {
      a.r = this.j;
    }
    if (this.h != null) {
      a.p = this.h.booleanValue();
    }
    if ((this.k != null) && (!this.k.isEmpty())) {
      u.a(paramContext, this.k, false);
    }
  }
  
  public TestinConfig addCustomLable(String paramString, Number paramNumber)
  {
    this.k.put(paramString, paramNumber);
    return this;
  }
  
  public TestinConfig addCustomLable(String paramString1, String paramString2)
  {
    this.k.put(paramString1, paramString2);
    return this;
  }
  
  public TestinConfig addCustomLable(String paramString, boolean paramBoolean)
  {
    this.k.put(paramString, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public TestinConfig enableEditor()
  {
    this.h = Boolean.valueOf(true);
    return this;
  }
  
  public TestinConfig multiprocessAvailable()
  {
    this.g = Boolean.valueOf(true);
    return this;
  }
  
  public TestinConfig onlyWifiUpload()
  {
    this.e = Boolean.valueOf(true);
    return this;
  }
  
  public TestinConfig setApiHost(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public TestinConfig setApiHost(String paramString, SSLSocketFactory paramSSLSocketFactory)
  {
    this.b = paramString;
    this.i = paramSSLSocketFactory;
    return this;
  }
  
  public TestinConfig setCheckMac(boolean paramBoolean)
  {
    this.d = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public TestinConfig setClientId(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public TestinConfig setEditorHost(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public TestinConfig setEditorHost(String paramString, SSLSocketFactory paramSSLSocketFactory)
  {
    this.c = paramString;
    this.j = paramSSLSocketFactory;
    return this;
  }
  
  public TestinConfig setReportError(Boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/TestinConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */