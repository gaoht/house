package com.b.b;

public class f
{
  private static int[] a = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  
  public static boolean isValidDate(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((paramInt1 < 1) || (paramInt1 > 9999) || (paramInt2 < 0) || (paramInt2 > 11))
    {
      bool = false;
      return bool;
    }
    int j = a[paramInt2];
    int i = j;
    if (paramInt2 == 1) {
      if ((paramInt1 % 4 != 0) || ((paramInt1 % 100 == 0) && (paramInt1 % 400 != 0))) {
        break label93;
      }
    }
    label93:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      i = j;
      if (paramInt1 != 0) {
        i = j + 1;
      }
      if ((paramInt3 >= 1) && (paramInt3 <= i)) {
        break;
      }
      return false;
    }
  }
  
  public static boolean isValidTime(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= 0) && (paramInt1 < 24) && (paramInt2 >= 0) && (paramInt2 < 60) && (paramInt3 >= 0) && (paramInt3 < 60);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */