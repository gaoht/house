package cn.testin.analysis;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class dk
{
  private InputStream a;
  private int b;
  
  private int a()
  {
    return c() << 8 | c();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
  }
  
  private void a(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt - this.b];
    this.a.read(arrayOfByte);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    this.b += paramArrayOfByte.length;
    if (this.a.read(paramArrayOfByte) != paramArrayOfByte.length) {
      throw new IOException();
    }
  }
  
  private int b()
  {
    return c() << 24 | c() << 16 | c() << 8 | c();
  }
  
  private void b(int paramInt)
  {
    this.b += paramInt;
    byte[] arrayOfByte = new byte[paramInt];
    this.a.read(arrayOfByte);
  }
  
  private int c()
  {
    this.b += 1;
    return this.a.read() & 0xFF;
  }
  
  public String a(Context paramContext, String paramString)
  {
    label290:
    label297:
    do
    {
      try
      {
        this.a = paramContext.getAssets().open(paramString);
        this.b = 0;
        i = a();
        j = a();
        if ((i != 1) && (j != 0))
        {
          paramString = null;
          paramContext = paramString;
          if (this.a == null) {}
        }
      }
      catch (Exception paramContext)
      {
        do
        {
          int i;
          int j;
          int k;
          paramContext = null;
        } while (this.a == null);
        try
        {
          this.a.close();
          return null;
        }
        catch (IOException paramContext)
        {
          return null;
        }
      }
      finally
      {
        if (this.a != null) {}
        try
        {
          this.a.close();
          throw paramContext;
        }
        catch (IOException paramString)
        {
          for (;;) {}
        }
      }
      try
      {
        this.a.close();
        paramContext = paramString;
        return paramContext;
      }
      catch (IOException paramContext) {}
      k = a();
      b(6);
      i = 0;
      for (;;)
      {
        if (i >= k) {
          break label297;
        }
        paramContext = new byte[4];
        a(paramContext);
        paramContext = new String(paramContext);
        b(4);
        j = b();
        int m = b();
        if ("name".equalsIgnoreCase(paramContext))
        {
          paramContext = new byte[m];
          a(j);
          a(paramContext);
          m = a(paramContext, 2);
          int n = a(paramContext, 4);
          j = 0;
          for (;;)
          {
            if (j >= m) {
              break label290;
            }
            int i1 = 12 * j + 6;
            int i2 = a(paramContext, i1);
            if ((a(paramContext, i1 + 6) == 4) && (i2 == 1))
            {
              i2 = a(paramContext, i1 + 8);
              i1 = a(paramContext, i1 + 10) + n;
              if ((i1 >= 0) && (i1 + i2 < paramContext.length))
              {
                paramString = new String(paramContext, i1, i2);
                paramContext = paramString;
                if (this.a == null) {
                  break;
                }
                try
                {
                  this.a.close();
                  return paramString;
                }
                catch (IOException paramContext)
                {
                  return paramString;
                }
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
      paramContext = null;
    } while (this.a == null);
    try
    {
      this.a.close();
      return null;
    }
    catch (IOException paramContext)
    {
      return null;
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */