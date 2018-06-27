package com.b.c.o;

import com.b.b.l;
import com.b.c.d;
import java.util.Stack;

public abstract class a
  implements com.b.a.j.b
{
  protected com.b.c.b a;
  protected final d b;
  private final Stack<com.b.c.b> c = new Stack();
  
  protected a(d paramd, Class<? extends com.b.c.b> paramClass)
  {
    this.b = paramd;
    try
    {
      this.a = ((com.b.c.b)paramClass.newInstance());
      this.b.addDirectory(this.a);
      return;
    }
    catch (InstantiationException paramd)
    {
      throw new RuntimeException(paramd);
    }
    catch (IllegalAccessException paramd)
    {
      throw new RuntimeException(paramd);
    }
  }
  
  protected void a(Class<? extends com.b.c.b> paramClass)
  {
    this.c.push(this.a);
    try
    {
      paramClass = (com.b.c.b)paramClass.newInstance();
      paramClass.setParent(this.a);
      this.a = paramClass;
      this.b.addDirectory(this.a);
      return;
    }
    catch (InstantiationException paramClass)
    {
      throw new RuntimeException(paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  public void endingIFD()
  {
    if (this.c.empty()) {}
    for (com.b.c.b localb = null;; localb = (com.b.c.b)this.c.pop())
    {
      this.a = localb;
      return;
    }
  }
  
  public void error(String paramString)
  {
    this.a.addError(paramString);
  }
  
  public void setByteArray(int paramInt, byte[] paramArrayOfByte)
  {
    this.a.setByteArray(paramInt, paramArrayOfByte);
  }
  
  public void setDouble(int paramInt, double paramDouble)
  {
    this.a.setDouble(paramInt, paramDouble);
  }
  
  public void setDoubleArray(int paramInt, double[] paramArrayOfDouble)
  {
    this.a.setDoubleArray(paramInt, paramArrayOfDouble);
  }
  
  public void setFloat(int paramInt, float paramFloat)
  {
    this.a.setFloat(paramInt, paramFloat);
  }
  
  public void setFloatArray(int paramInt, float[] paramArrayOfFloat)
  {
    this.a.setFloatArray(paramInt, paramArrayOfFloat);
  }
  
  public void setInt16s(int paramInt1, int paramInt2)
  {
    this.a.setInt(paramInt1, paramInt2);
  }
  
  public void setInt16sArray(int paramInt, short[] paramArrayOfShort)
  {
    this.a.setObjectArray(paramInt, paramArrayOfShort);
  }
  
  public void setInt16u(int paramInt1, int paramInt2)
  {
    this.a.setInt(paramInt1, paramInt2);
  }
  
  public void setInt16uArray(int paramInt, int[] paramArrayOfInt)
  {
    this.a.setObjectArray(paramInt, paramArrayOfInt);
  }
  
  public void setInt32s(int paramInt1, int paramInt2)
  {
    this.a.setInt(paramInt1, paramInt2);
  }
  
  public void setInt32sArray(int paramInt, int[] paramArrayOfInt)
  {
    this.a.setIntArray(paramInt, paramArrayOfInt);
  }
  
  public void setInt32u(int paramInt, long paramLong)
  {
    this.a.setLong(paramInt, paramLong);
  }
  
  public void setInt32uArray(int paramInt, long[] paramArrayOfLong)
  {
    this.a.setObjectArray(paramInt, paramArrayOfLong);
  }
  
  public void setInt8s(int paramInt, byte paramByte)
  {
    this.a.setInt(paramInt, paramByte);
  }
  
  public void setInt8sArray(int paramInt, byte[] paramArrayOfByte)
  {
    this.a.setByteArray(paramInt, paramArrayOfByte);
  }
  
  public void setInt8u(int paramInt, short paramShort)
  {
    this.a.setInt(paramInt, paramShort);
  }
  
  public void setInt8uArray(int paramInt, short[] paramArrayOfShort)
  {
    this.a.setObjectArray(paramInt, paramArrayOfShort);
  }
  
  public void setRational(int paramInt, l paraml)
  {
    this.a.setRational(paramInt, paraml);
  }
  
  public void setRationalArray(int paramInt, l[] paramArrayOfl)
  {
    this.a.setRationalArray(paramInt, paramArrayOfl);
  }
  
  public void setString(int paramInt, String paramString)
  {
    this.a.setString(paramInt, paramString);
  }
  
  public void warn(String paramString)
  {
    this.a.addError(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/o/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */