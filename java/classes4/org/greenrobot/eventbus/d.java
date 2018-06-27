package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.a.b;

public class d
{
  private static final ExecutorService l = ;
  boolean a = true;
  boolean b = true;
  boolean c = true;
  boolean d = true;
  boolean e;
  boolean f = true;
  boolean g;
  boolean h;
  ExecutorService i = l;
  List<Class<?>> j;
  List<b> k;
  
  public d addIndex(b paramb)
  {
    if (this.k == null) {
      this.k = new ArrayList();
    }
    this.k.add(paramb);
    return this;
  }
  
  public c build()
  {
    return new c(this);
  }
  
  public d eventInheritance(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public d executorService(ExecutorService paramExecutorService)
  {
    this.i = paramExecutorService;
    return this;
  }
  
  public d ignoreGeneratedIndex(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public c installDefaultEventBus()
  {
    try
    {
      if (c.b != null) {
        throw new e("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
      }
    }
    finally {}
    c.b = build();
    c localc = c.b;
    return localc;
  }
  
  public d logNoSubscriberMessages(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public d logSubscriberExceptions(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public d sendNoSubscriberEvent(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public d sendSubscriberExceptionEvent(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public d skipMethodVerificationFor(Class<?> paramClass)
  {
    if (this.j == null) {
      this.j = new ArrayList();
    }
    this.j.add(paramClass);
    return this;
  }
  
  public d strictMethodVerification(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public d throwSubscriberException(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */