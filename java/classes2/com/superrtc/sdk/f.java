package com.superrtc.sdk;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
{
  static long g = 20L;
  String a;
  String b;
  String c;
  String d = null;
  long e = 0L;
  long f = 0L;
  
  public f(String paramString)
  {
    this.a = paramString;
    this.b = (paramString + "a0");
    this.c = (paramString + "v0");
    reset();
  }
  
  static long a()
  {
    long l = Math.abs(new Random().nextLong() % 100000000L);
    return l - l % g;
  }
  
  private String a(String paramString, long paramLong)
  {
    Matcher localMatcher = Pattern.compile("a=ssrc-group:FID(( \\d+)+)").matcher(paramString);
    int i = 0;
    if (localMatcher.find())
    {
      String[] arrayOfString = localMatcher.group(1).trim().split(" ");
      int m = arrayOfString.length;
      int k = 0;
      str = paramString;
      int j = i;
      for (;;)
      {
        i = j;
        paramString = str;
        if (k >= m) {
          break;
        }
        str = str.replaceAll(arrayOfString[k], "" + (j + paramLong));
        k += 1;
        j += 1;
      }
    }
    String str = paramString;
    if (i == 0) {
      str = paramString.replaceAll("a=ssrc:(\\d+)", "a=ssrc:" + paramLong);
    }
    return str;
  }
  
  static String[] a(String paramString)
  {
    int i = 1;
    String[] arrayOfString = paramString.split("\r\nm=");
    if (arrayOfString.length < 2) {
      return new String[] { paramString };
    }
    paramString = new String[arrayOfString.length];
    paramString[0] = (arrayOfString[0] + "\r\n");
    while (i < arrayOfString.length)
    {
      paramString[i] = ("m=" + arrayOfString[i]);
      if (i != arrayOfString.length - 1) {
        paramString[i] = (paramString[i] + "\r\n");
      }
      i += 1;
    }
    return paramString;
  }
  
  public String changeSSRC(String paramString)
  {
    paramString = a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length)
    {
      String str = paramString[i];
      if ((str.startsWith("m=audio")) && (this.e > 0L)) {
        localStringBuilder.append(a(str, this.e));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((str.startsWith("m=video")) && (this.f > 0L)) {
          localStringBuilder.append(a(str, this.f));
        } else {
          localStringBuilder.append(str);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public String processPranswer(String paramString)
  {
    paramString = a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    long l1 = a();
    int i = 0;
    if (i < paramString.length)
    {
      String str = paramString[i];
      this.d = ("cname" + l1);
      long l2;
      if (str.startsWith("m=audio"))
      {
        localStringBuilder.append(str);
        if (str.indexOf("a=ssrc:") < 0)
        {
          l2 = l1 + 0L;
          localStringBuilder.append("a=ssrc:" + l2 + " cname:" + this.d + "\r\n");
          localStringBuilder.append("a=ssrc:" + l2 + " msid:" + this.a + " " + this.b + "\r\n");
          localStringBuilder.append("a=ssrc:" + l2 + " mslabel:" + this.a + "\r\n");
          localStringBuilder.append("a=ssrc:" + l2 + " label:" + this.b + "\r\n");
          this.e = l2;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (str.startsWith("m=video"))
        {
          localStringBuilder.append(str);
          if (str.indexOf("a=ssrc:") < 0)
          {
            l2 = 10L + l1;
            localStringBuilder.append("a=ssrc-group:FID " + (l2 + 0L) + " " + (1L + l2) + "\r\n");
            int j = 0;
            while (j < 2)
            {
              localStringBuilder.append("a=ssrc:" + (j + l2) + " cname:" + this.d + "\r\n");
              localStringBuilder.append("a=ssrc:" + (j + l2) + " msid:" + this.a + " " + this.c + "\r\n");
              localStringBuilder.append("a=ssrc:" + (j + l2) + " mslabel:" + this.a + "\r\n");
              localStringBuilder.append("a=ssrc:" + (j + l2) + " label:" + this.c + "\r\n");
              j += 1;
            }
            this.f = l2;
          }
        }
        else
        {
          localStringBuilder.append(str);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void reset()
  {
    this.d = null;
    this.e = 0L;
    this.f = 0L;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/superrtc/sdk/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */