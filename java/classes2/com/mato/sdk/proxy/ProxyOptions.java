package com.mato.sdk.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyOptions
{
  private final List<String> a;
  private final Proxy.AccesslogListener b;
  private final boolean c;
  private final boolean d;
  private final String e;
  private final boolean f;
  
  private ProxyOptions(Builder paramBuilder)
  {
    List localList = paramBuilder.processNameBlacklist;
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    this.a = ((List)localObject);
    this.b = paramBuilder.accesslogListener;
    this.c = paramBuilder.crashCollectEnabled;
    this.d = paramBuilder.globalProxyEnabled;
    this.e = paramBuilder.markKey;
    this.f = paramBuilder.supportWebview;
  }
  
  public final List<String> a()
  {
    return this.a;
  }
  
  public final Proxy.AccesslogListener b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final String e()
  {
    return this.e;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public static class Builder
  {
    private Proxy.AccesslogListener accesslogListener;
    private boolean crashCollectEnabled = true;
    private boolean globalProxyEnabled = true;
    private String markKey = "";
    private List<String> processNameBlacklist;
    private boolean supportWebview = true;
    
    public ProxyOptions build()
    {
      return new ProxyOptions(this, (byte)0);
    }
    
    public Builder setAccesslogListener(Proxy.AccesslogListener paramAccesslogListener)
    {
      this.accesslogListener = paramAccesslogListener;
      return this;
    }
    
    public Builder setCrashCollectEnabled(boolean paramBoolean)
    {
      this.crashCollectEnabled = paramBoolean;
      return this;
    }
    
    public Builder setGlobalProxyEnabled(boolean paramBoolean)
    {
      this.globalProxyEnabled = paramBoolean;
      return this;
    }
    
    public Builder setMarkKey(String paramString)
    {
      this.markKey = paramString;
      return this;
    }
    
    public Builder setProcessNameBlacklist(List<String> paramList)
    {
      this.processNameBlacklist = paramList;
      return this;
    }
    
    public Builder setSupportWebview(boolean paramBoolean)
    {
      this.supportWebview = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mato/sdk/proxy/ProxyOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */