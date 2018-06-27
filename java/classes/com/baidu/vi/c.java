package com.baidu.vi;

import android.net.NetworkInfo;

public class c
{
  public String a;
  public int b;
  public int c;
  
  public c(NetworkInfo paramNetworkInfo)
  {
    this.a = paramNetworkInfo.getTypeName();
    this.b = paramNetworkInfo.getType();
    switch (1.a[paramNetworkInfo.getState().ordinal()])
    {
    default: 
      this.c = 0;
      return;
    case 1: 
      this.c = 2;
      return;
    }
    this.c = 1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/baidu/vi/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */