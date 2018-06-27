package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;

public class bg
  implements az
{
  private static bg i = null;
  private boolean a = false;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private float e = 0.0F;
  private float f = 0.0F;
  private String g = null;
  private Context h = null;
  
  private bg(Context paramContext, String paramString, int paramInt)
  {
    this.h = paramContext;
    a(paramString, paramInt);
  }
  
  public static bg a(Context paramContext)
  {
    try
    {
      if (i == null)
      {
        af.a locala = af.a(paramContext).b();
        i = new bg(paramContext, locala.f(null), locala.d(0));
      }
      paramContext = i;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    int k;
    do
    {
      do
      {
        do
        {
          return false;
          paramString = paramString.split("\\|");
        } while (paramString.length != 6);
        if ((paramString[0].startsWith("SIG7")) && (paramString[1].split(",").length == paramString[5].split(",").length)) {
          return true;
        }
      } while (!paramString[0].startsWith("FIXED"));
      j = paramString[5].split(",").length;
      k = Integer.parseInt(paramString[1]);
    } while ((j < k) || (k < 1));
    return true;
  }
  
  private float b(String paramString, int paramInt)
  {
    paramInt *= 2;
    if (paramString == null) {
      return 0.0F;
    }
    return Integer.valueOf(paramString.substring(paramInt, paramInt + 5), 16).intValue() / 1048576.0F;
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String[] arrayOfString = paramString.split("\\|");
    if (arrayOfString[2].equals("SIG13")) {}
    for (float f1 = Float.valueOf(arrayOfString[3]).floatValue();; f1 = 0.0F)
    {
      if (this.e > f1)
      {
        this.a = false;
        return;
      }
      float[] arrayOfFloat = null;
      int j;
      if (arrayOfString[0].equals("SIG7"))
      {
        paramString = arrayOfString[1].split(",");
        arrayOfFloat = new float[paramString.length];
        j = 0;
        while (j < paramString.length)
        {
          arrayOfFloat[j] = Float.valueOf(paramString[j]).floatValue();
          j += 1;
        }
      }
      int[] arrayOfInt = null;
      paramString = null;
      Object localObject;
      if (arrayOfString[4].equals("RPT"))
      {
        this.g = "RPT";
        localObject = arrayOfString[5].split(",");
        paramString = new int[localObject.length];
        j = 0;
        while (j < localObject.length)
        {
          paramString[j] = Integer.valueOf(localObject[j]).intValue();
          j += 1;
        }
        label179:
        f1 = 0.0F;
        j = 0;
        if (j >= arrayOfFloat.length) {
          break label345;
        }
        f1 += arrayOfFloat[j];
        if (this.f >= f1) {
          break label325;
        }
      }
      for (;;)
      {
        if (j != -1)
        {
          this.a = true;
          this.d = (j + 1);
          if (paramString == null) {
            break;
          }
          this.b = paramString[j];
          return;
          if (!arrayOfString[4].equals("DOM")) {
            break label179;
          }
          this.a = true;
          this.g = "DOM";
          localObject = arrayOfInt;
        }
        try
        {
          arrayOfString = arrayOfString[5].split(",");
          localObject = arrayOfInt;
          arrayOfInt = new int[arrayOfString.length];
          j = 0;
          for (;;)
          {
            paramString = arrayOfInt;
            localObject = arrayOfInt;
            if (j >= arrayOfString.length) {
              break;
            }
            localObject = arrayOfInt;
            arrayOfInt[j] = Integer.valueOf(arrayOfString[j]).intValue();
            j += 1;
          }
          label325:
          j += 1;
        }
        catch (Exception paramString)
        {
          paramString = (String)localObject;
        }
        this.a = false;
        return;
        break label179;
        label345:
        j = -1;
      }
    }
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String[] arrayOfString = paramString.split("\\|");
    float f1 = 0.0F;
    if (arrayOfString[2].equals("SIG13")) {
      f1 = Float.valueOf(arrayOfString[3]).floatValue();
    }
    if (this.e > f1)
    {
      this.a = false;
      return;
    }
    if (arrayOfString[0].equals("FIXED")) {}
    for (int j = Integer.valueOf(arrayOfString[1]).intValue();; j = -1)
    {
      int[] arrayOfInt = null;
      paramString = null;
      Object localObject;
      int k;
      if (arrayOfString[4].equals("RPT"))
      {
        this.g = "RPT";
        localObject = arrayOfString[5].split(",");
        paramString = new int[localObject.length];
        k = 0;
        while (k < localObject.length)
        {
          paramString[k] = Integer.valueOf(localObject[k]).intValue();
          k += 1;
        }
      }
      for (;;)
      {
        if (j != -1)
        {
          this.a = true;
          this.d = j;
          if (paramString == null) {
            break;
          }
          this.b = paramString[(j - 1)];
          return;
          if (!arrayOfString[4].equals("DOM")) {
            continue;
          }
          this.g = "DOM";
          this.a = true;
          localObject = arrayOfInt;
        }
        try
        {
          arrayOfString = arrayOfString[5].split(",");
          localObject = arrayOfInt;
          arrayOfInt = new int[arrayOfString.length];
          k = 0;
          for (;;)
          {
            paramString = arrayOfInt;
            localObject = arrayOfInt;
            if (k >= arrayOfString.length) {
              break;
            }
            localObject = arrayOfInt;
            arrayOfInt[k] = Integer.valueOf(arrayOfString[k]).intValue();
            k += 1;
          }
          this.a = false;
          return;
        }
        catch (Exception paramString)
        {
          paramString = (String)localObject;
        }
      }
    }
  }
  
  public void a(af.a parama)
  {
    a(parama.f(null), parama.d(0));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.c = paramInt;
    String str = aa.a(this.h);
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString))) {
      this.a = false;
    }
    do
    {
      return;
      try
      {
        this.e = b(str, 12);
        this.f = b(str, 6);
        if (paramString.startsWith("SIG7"))
        {
          b(paramString);
          return;
        }
      }
      catch (Exception localException)
      {
        this.a = false;
        by.e("v:" + paramString, localException);
        return;
      }
    } while (!paramString.startsWith("FIXED"));
    c(paramString);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String e()
  {
    if (!this.a) {
      return "error";
    }
    return String.valueOf(this.d);
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" p13:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" p07:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" policy:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" interval:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/umeng/analytics/pro/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */