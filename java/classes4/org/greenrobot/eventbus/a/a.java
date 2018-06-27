package org.greenrobot.eventbus.a;

import org.greenrobot.eventbus.l;

public abstract interface a
{
  public abstract Class<?> getSubscriberClass();
  
  public abstract l[] getSubscriberMethods();
  
  public abstract a getSuperSubscriberInfo();
  
  public abstract boolean shouldCheckSuperclass();
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */