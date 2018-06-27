package com.b.c.k;

import java.io.Serializable;

public class d
  implements Serializable
{
  private final int a;
  private final int b;
  private final int c;
  
  public d(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public int getComponentId()
  {
    return this.a;
  }
  
  public String getComponentName()
  {
    switch (this.a)
    {
    default: 
      return String.format("Unknown (%s)", new Object[] { Integer.valueOf(this.a) });
    case 1: 
      return "Y";
    case 2: 
      return "Cb";
    case 3: 
      return "Cr";
    case 4: 
      return "I";
    }
    return "Q";
  }
  
  public int getHorizontalSamplingFactor()
  {
    return this.b >> 4 & 0xF;
  }
  
  public int getQuantizationTableNumber()
  {
    return this.c;
  }
  
  public int getVerticalSamplingFactor()
  {
    return this.b & 0xF;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */