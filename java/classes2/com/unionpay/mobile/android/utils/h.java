package com.unionpay.mobile.android.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h
{
  public static SpannableString a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject2 = "";
    if (!b(paramString1)) {
      localObject2 = "" + paramString1;
    }
    Object localObject1 = localObject2;
    if (!b(paramString3)) {
      localObject1 = (String)localObject2 + paramString3;
    }
    localObject2 = localObject1;
    if (!b(paramString4)) {
      localObject2 = (String)localObject1 + paramString4;
    }
    paramString4 = new SpannableString((CharSequence)localObject2);
    int i;
    int j;
    if (b(paramString1))
    {
      i = 0;
      if (!b(paramString3)) {
        break label205;
      }
      j = 0;
      label126:
      paramString4.setSpan(new ForegroundColorSpan(-16777216), 0, ((String)localObject2).length(), 33);
      if (!b(paramString2)) {
        if ((paramString2.length() == 6) || (!d(paramString2))) {
          break label214;
        }
      }
    }
    for (;;)
    {
      paramString4.setSpan(new ForegroundColorSpan(Color.parseColor(paramString2)), i, j + i, 33);
      return paramString4;
      i = paramString1.length();
      break;
      label205:
      j = paramString3.length();
      break label126;
      label214:
      paramString2 = "#" + paramString2;
    }
  }
  
  public static final String a(String paramString)
  {
    String str = "";
    if ((paramString != null) || (paramString.length() > 2)) {
      str = paramString.substring(1, paramString.length() - 1);
    }
    return str;
  }
  
  public static final boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static final boolean c(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private static final boolean d(String paramString)
  {
    if (!b(paramString))
    {
      String[] arrayOfString = new String[11];
      arrayOfString[0] = "black";
      arrayOfString[1] = "darkgray";
      arrayOfString[2] = "gray";
      arrayOfString[3] = "lightgray";
      arrayOfString[4] = "white";
      arrayOfString[5] = "red";
      arrayOfString[6] = "green";
      arrayOfString[7] = "blue";
      arrayOfString[8] = "yellow";
      arrayOfString[9] = "cyan";
      arrayOfString[10] = "magenta";
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/utils/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */