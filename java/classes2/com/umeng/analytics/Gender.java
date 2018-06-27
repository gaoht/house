package com.umeng.analytics;

import com.umeng.analytics.pro.bj;
import java.util.Locale;

public enum Gender
{
  public int value;
  
  private Gender(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static Gender getGender(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Unknown;
    case 1: 
      return Male;
    }
    return Female;
  }
  
  public static bj transGender(Gender paramGender)
  {
    switch (4.a[paramGender.ordinal()])
    {
    default: 
      return bj.c;
    case 1: 
      return bj.a;
    }
    return bj.b;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/Gender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */