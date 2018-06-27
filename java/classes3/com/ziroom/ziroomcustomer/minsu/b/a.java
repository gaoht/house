package com.ziroom.ziroomcustomer.minsu.b;

import android.content.Context;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public enum a
{
  private int f;
  private int g;
  
  private a(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  private static boolean a(a parama, String paramString)
  {
    return ApplicationEx.c.getBaseContext().getString(parama.getValue()).equals(paramString);
  }
  
  public static a getCerType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return a;
    case 2: 
      return b;
    case 13: 
      return d;
    case 6: 
      return e;
    }
    return c;
  }
  
  public static a getCerType(String paramString)
  {
    if (a(a, paramString)) {
      return a;
    }
    if (a(b, paramString)) {
      return b;
    }
    if (a(d, paramString)) {
      return d;
    }
    if (a(e, paramString)) {
      return e;
    }
    if (a(c, paramString)) {
      return c;
    }
    return null;
  }
  
  public static String getTypeString(Context paramContext, int paramInt)
  {
    a locala = getCerType(paramInt);
    if (locala != null) {
      return paramContext.getString(locala.getValue());
    }
    return paramContext.getString(a.getValue());
  }
  
  public int getKey()
  {
    return this.f;
  }
  
  public int getValue()
  {
    return this.g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */