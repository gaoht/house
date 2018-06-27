package com.growingio.android.sdk.collection;

import android.app.Application;

public class Configuration
{
  Application a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  double h = 1.0D;
  boolean i = false;
  boolean j = false;
  boolean k = false;
  boolean l = true;
  boolean m = false;
  boolean n = false;
  boolean o = false;
  boolean p = true;
  boolean q = true;
  boolean r = false;
  boolean s = false;
  int t = 300;
  long u = 30000L;
  long v = 30000L;
  long w = 3145728L;
  ActivityLifecycleCallbacksRegistrar x;
  boolean y = false;
  
  public Configuration() {}
  
  public Configuration(String paramString)
  {
    this.b = paramString;
  }
  
  public Configuration disableCellularImp()
  {
    this.s = true;
    return this;
  }
  
  public Configuration setActivityLifecycleCallbacksRegistrar(ActivityLifecycleCallbacksRegistrar paramActivityLifecycleCallbacksRegistrar)
  {
    this.x = paramActivityLifecycleCallbacksRegistrar;
    return this;
  }
  
  public Configuration setApp(Application paramApplication)
  {
    this.a = paramApplication;
    return this;
  }
  
  public Configuration setBulkSize(int paramInt)
  {
    this.t = paramInt;
    return this;
  }
  
  public Configuration setCellularDataLimit(long paramLong)
  {
    this.w = paramLong;
    return this;
  }
  
  public Configuration setChannel(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public Configuration setContext(Application paramApplication)
  {
    this.a = paramApplication;
    return this;
  }
  
  public Configuration setDebugMode(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }
  
  public Configuration setDeviceId(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Configuration setDiagnose(boolean paramBoolean)
  {
    this.p = paramBoolean;
    return this;
  }
  
  public Configuration setDisableImpression(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public Configuration setDisabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public Configuration setFlushInterval(long paramLong)
  {
    this.v = paramLong;
    return this;
  }
  
  public Configuration setHashTagEnable(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }
  
  public Configuration setMutiprocess(boolean paramBoolean)
  {
    this.y = paramBoolean;
    return this;
  }
  
  public Configuration setProjectId(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public Configuration setSampling(double paramDouble)
  {
    this.h = paramDouble;
    return this;
  }
  
  public Configuration setSessionInterval(long paramLong)
  {
    this.u = paramLong;
    return this;
  }
  
  public Configuration setTestMode(boolean paramBoolean)
  {
    this.o = paramBoolean;
    return this;
  }
  
  public Configuration setThrottle(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public Configuration setTrackWebView(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public Configuration setTrackerHost(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Configuration setURLScheme(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Configuration setZone(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public Configuration trackAllFragments()
  {
    this.r = true;
    return this;
  }
  
  public Configuration useID()
  {
    this.q = true;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/growingio/android/sdk/collection/Configuration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */