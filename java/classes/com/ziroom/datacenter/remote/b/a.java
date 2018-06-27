package com.ziroom.datacenter.remote.b;

public abstract class a<T>
{
  public abstract void onFailure(Throwable paramThrowable);
  
  public boolean onHandleMessage(Throwable paramThrowable, String paramString)
  {
    return false;
  }
  
  public void onStart() {}
  
  public abstract void onSuccess(int paramInt, T paramT);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/datacenter/remote/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */