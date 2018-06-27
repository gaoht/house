package com.b.c.d;

import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  private String a()
  {
    Long localLong = ((b)this.a).getLongObject(2);
    if (localLong == null) {
      return null;
    }
    return Long.toString(localLong.longValue()) + " bytes";
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    }
    return a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */