package com.ziroom.commonlibrary.c;

import android.text.TextUtils;

public class a
{
  private String a;
  private String b;
  private String c;
  
  public a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        if (str.startsWith("resultStatus")) {
          this.a = a(str, "resultStatus");
        }
        if (str.startsWith("result")) {
          this.b = a(str, "result");
        }
        if (str.startsWith("memo")) {
          this.c = a(str, "memo");
        }
        i += 1;
      }
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString2 = paramString2 + "={";
    int i = paramString1.indexOf(paramString2);
    return paramString1.substring(paramString2.length() + i, paramString1.lastIndexOf("}"));
  }
  
  public String getMemo()
  {
    return this.c;
  }
  
  public String getResult()
  {
    return this.b;
  }
  
  public String getResultStatus()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "resultStatus={" + this.a + "};memo={" + this.c + "};result={" + this.b + "}";
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */