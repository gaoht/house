package com.b.a.f;

public enum e
{
  private final int f;
  private final String g;
  private final int[] h;
  
  private e(int paramInt, String paramString, int... paramVarArgs)
  {
    this.f = paramInt;
    this.g = paramString;
    this.h = paramVarArgs;
  }
  
  public static e fromNumericValue(int paramInt)
  {
    e[] arrayOfe = (e[])e.class.getEnumConstants();
    int k = arrayOfe.length;
    int j = 0;
    while (j < k)
    {
      e locale = arrayOfe[j];
      if (locale.getNumericValue() == paramInt) {
        return locale;
      }
      j += 1;
    }
    return null;
  }
  
  public int[] getAllowedBitDepths()
  {
    return this.h;
  }
  
  public String getDescription()
  {
    return this.g;
  }
  
  public int getNumericValue()
  {
    return this.f;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/a/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */