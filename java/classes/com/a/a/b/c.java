package com.a.a.b;

import java.util.HashMap;
import java.util.Map;

public abstract class c
{
  private int a = 0;
  private Map b = null;
  
  public c() {}
  
  public c(int paramInt)
    throws com.a.a.c
  {
    c(paramInt);
    setOptions(paramInt);
  }
  
  private Map b()
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    return this.b;
  }
  
  private void c(int paramInt)
    throws com.a.a.c
  {
    int i = (a() ^ 0xFFFFFFFF) & paramInt;
    if (i == 0)
    {
      assertConsistency(paramInt);
      return;
    }
    throw new com.a.a.c("The option bit(s) 0x" + Integer.toHexString(i) + " are invalid!", 103);
  }
  
  private String d(int paramInt)
  {
    Map localMap = b();
    Integer localInteger = new Integer(paramInt);
    String str2 = (String)localMap.get(localInteger);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(paramInt);
      if (str1 != null) {
        localMap.put(localInteger, str1);
      }
    }
    else
    {
      return str1;
    }
    return "<option name not defined>";
  }
  
  protected abstract int a();
  
  protected abstract String a(int paramInt);
  
  protected void assertConsistency(int paramInt)
    throws com.a.a.c
  {}
  
  protected boolean b(int paramInt)
  {
    return (this.a & paramInt) != 0;
  }
  
  public void clear()
  {
    this.a = 0;
  }
  
  public boolean containsAllOptions(int paramInt)
  {
    return (getOptions() & paramInt) == paramInt;
  }
  
  public boolean containsOneOf(int paramInt)
  {
    return (getOptions() & paramInt) != 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return getOptions() == ((c)paramObject).getOptions();
  }
  
  public int getOptions()
  {
    return this.a;
  }
  
  public String getOptionsString()
  {
    if (this.a != 0)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int j;
      for (int i = this.a; i != 0; i = j)
      {
        j = i - 1 & i;
        localStringBuffer.append(d(i ^ j));
        if (j != 0) {
          localStringBuffer.append(" | ");
        }
      }
      return localStringBuffer.toString();
    }
    return "<none>";
  }
  
  public int hashCode()
  {
    return getOptions();
  }
  
  public boolean isExactly(int paramInt)
  {
    return getOptions() == paramInt;
  }
  
  public void setOption(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramInt = this.a | paramInt;; paramInt = this.a & (paramInt ^ 0xFFFFFFFF))
    {
      this.a = paramInt;
      return;
    }
  }
  
  public void setOptions(int paramInt)
    throws com.a.a.c
  {
    c(paramInt);
    this.a = paramInt;
  }
  
  public String toString()
  {
    return "0x" + Integer.toHexString(this.a);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/a/a/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */