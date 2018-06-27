package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;

public class a
{
  final Resources a;
  final int b;
  final int c;
  final c d;
  org.greenrobot.eventbus.c e;
  boolean f = true;
  String g;
  int h;
  Class<?> i;
  
  public a(Resources paramResources, int paramInt1, int paramInt2)
  {
    this.a = paramResources;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = new c();
  }
  
  org.greenrobot.eventbus.c a()
  {
    if (this.e != null) {
      return this.e;
    }
    return org.greenrobot.eventbus.c.getDefault();
  }
  
  public a addMapping(Class<? extends Throwable> paramClass, int paramInt)
  {
    this.d.addMapping(paramClass, paramInt);
    return this;
  }
  
  public void disableExceptionLogging()
  {
    this.f = false;
  }
  
  public int getMessageIdForThrowable(Throwable paramThrowable)
  {
    Integer localInteger = this.d.mapThrowable(paramThrowable);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    Log.d(org.greenrobot.eventbus.c.a, "No specific message ressource ID found for " + paramThrowable);
    return this.c;
  }
  
  public void setDefaultDialogIconId(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setDefaultEventTypeOnDialogClosed(Class<?> paramClass)
  {
    this.i = paramClass;
  }
  
  public void setEventBus(org.greenrobot.eventbus.c paramc)
  {
    this.e = paramc;
  }
  
  public void setTagForLoggingExceptions(String paramString)
  {
    this.g = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */