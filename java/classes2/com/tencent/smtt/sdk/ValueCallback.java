package com.tencent.smtt.sdk;

public abstract interface ValueCallback<T>
  extends android.webkit.ValueCallback<T>
{
  public abstract void onReceiveValue(T paramT);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/ValueCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */