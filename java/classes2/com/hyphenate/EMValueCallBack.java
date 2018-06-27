package com.hyphenate;

public abstract interface EMValueCallBack<T>
{
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onSuccess(T paramT);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/EMValueCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */