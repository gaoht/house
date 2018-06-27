package org.greenrobot.eventbus.util;

public class d
{
  protected final Throwable a;
  protected final boolean b;
  private Object c;
  
  public d(Throwable paramThrowable)
  {
    this.a = paramThrowable;
    this.b = false;
  }
  
  public d(Throwable paramThrowable, boolean paramBoolean)
  {
    this.a = paramThrowable;
    this.b = paramBoolean;
  }
  
  public Object getExecutionScope()
  {
    return this.c;
  }
  
  public Throwable getThrowable()
  {
    return this.a;
  }
  
  public boolean isSuppressErrorUi()
  {
    return this.b;
  }
  
  public void setExecutionScope(Object paramObject)
  {
    this.c = paramObject;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/util/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */