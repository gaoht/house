package com.facebook.common.internal;

import com.android.internal.util.Predicate;

public class AndroidPredicates
{
  public static <T> Predicate<T> False()
  {
    new Predicate()
    {
      public boolean apply(T paramAnonymousT)
      {
        return false;
      }
    };
  }
  
  public static <T> Predicate<T> True()
  {
    new Predicate()
    {
      public boolean apply(T paramAnonymousT)
      {
        return true;
      }
    };
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/internal/AndroidPredicates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */