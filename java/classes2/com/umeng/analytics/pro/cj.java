package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class cj
{
  private final df a;
  private final ds b = new ds();
  
  public cj()
  {
    this(new cz.a());
  }
  
  public cj(dh paramdh)
  {
    this.a = paramdh.a(this.b);
  }
  
  private Object a(byte paramByte, byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    try
    {
      paramArrayOfByte = j(paramArrayOfByte, paramcn, paramVarArgs);
      if (paramArrayOfByte != null) {
        switch (paramByte)
        {
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return null;
                    } while (paramArrayOfByte.b != 2);
                    boolean bool = this.a.t();
                    return Boolean.valueOf(bool);
                  } while (paramArrayOfByte.b != 3);
                  byte b1 = this.a.u();
                  return Byte.valueOf(b1);
                } while (paramArrayOfByte.b != 4);
                double d = this.a.y();
                return Double.valueOf(d);
              } while (paramArrayOfByte.b != 6);
              short s = this.a.v();
              return Short.valueOf(s);
            } while (paramArrayOfByte.b != 8);
            paramByte = this.a.w();
            return Integer.valueOf(paramByte);
          } while (paramArrayOfByte.b != 10);
          long l = this.a.x();
          return Long.valueOf(l);
        } while (paramArrayOfByte.b != 11);
        paramArrayOfByte = this.a.z();
        return paramArrayOfByte;
      } while (paramArrayOfByte.b != 11);
      paramArrayOfByte = this.a.A();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new cm(paramArrayOfByte);
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
  }
  
  private da j(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    int j = 0;
    this.b.a(paramArrayOfByte);
    cn[] arrayOfcn = new cn[paramVarArgs.length + 1];
    arrayOfcn[0] = paramcn;
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfcn[(i + 1)] = paramVarArgs[i];
      i += 1;
    }
    this.a.j();
    paramArrayOfByte = null;
    i = j;
    while (i < arrayOfcn.length)
    {
      paramcn = this.a.l();
      if ((paramcn.b == 0) || (paramcn.c > arrayOfcn[i].a())) {
        return null;
      }
      if (paramcn.c != arrayOfcn[i].a())
      {
        di.a(this.a, paramcn.b);
        this.a.m();
        paramArrayOfByte = paramcn;
      }
      else
      {
        j = i + 1;
        paramArrayOfByte = paramcn;
        i = j;
        if (j < arrayOfcn.length)
        {
          this.a.j();
          paramArrayOfByte = paramcn;
          i = j;
        }
      }
    }
    return paramArrayOfByte;
  }
  
  public Boolean a(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (Boolean)a((byte)2, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public void a(cg paramcg, String paramString)
    throws cm
  {
    a(paramcg, paramString.getBytes());
  }
  
  public void a(cg paramcg, String paramString1, String paramString2)
    throws cm
  {
    try
    {
      a(paramcg, paramString1.getBytes(paramString2));
      return;
    }
    catch (UnsupportedEncodingException paramcg)
    {
      throw new cm("JVM DOES NOT SUPPORT ENCODING: " + paramString2);
    }
    finally
    {
      this.a.B();
    }
  }
  
  public void a(cg paramcg, byte[] paramArrayOfByte)
    throws cm
  {
    try
    {
      this.b.a(paramArrayOfByte);
      paramcg.a(this.a);
      return;
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
  }
  
  public void a(cg paramcg, byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    try
    {
      if (j(paramArrayOfByte, paramcn, paramVarArgs) != null) {
        paramcg.a(this.a);
      }
      return;
    }
    catch (Exception paramcg)
    {
      throw new cm(paramcg);
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
  }
  
  public Byte b(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (Byte)a((byte)3, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public Double c(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (Double)a((byte)4, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public Short d(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (Short)a((byte)6, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public Integer e(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (Integer)a((byte)8, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public Long f(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (Long)a((byte)10, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public String g(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (String)a((byte)11, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public ByteBuffer h(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    return (ByteBuffer)a((byte)100, paramArrayOfByte, paramcn, paramVarArgs);
  }
  
  public Short i(byte[] paramArrayOfByte, cn paramcn, cn... paramVarArgs)
    throws cm
  {
    try
    {
      if (j(paramArrayOfByte, paramcn, paramVarArgs) != null)
      {
        this.a.j();
        short s = this.a.l().c;
        return Short.valueOf(s);
      }
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new cm(paramArrayOfByte);
    }
    finally
    {
      this.b.e();
      this.a.B();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */