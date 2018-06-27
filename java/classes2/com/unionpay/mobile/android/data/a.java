package com.unionpay.mobile.android.data;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.unionpay.mobile.android.utils.h;
import java.util.HashMap;

public final class a
{
  public static final HashMap<String, Integer> a = new HashMap();
  
  public static SpannableString a(String paramString1, String paramString2)
  {
    int j = -10066330;
    SpannableString localSpannableString = new SpannableString(paramString1);
    localSpannableString.setSpan(new ForegroundColorSpan(-10066330), 0, paramString1.length(), 33);
    if (paramString2 == null) {
      return localSpannableString;
    }
    paramString2 = paramString2.split(";");
    int m = paramString2.length;
    int i = 0;
    while (i < m)
    {
      String str = paramString2[i];
      if (a(str)) {
        break;
      }
      try
      {
        int k = Color.parseColor("#" + str);
        j = k;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      i += 1;
    }
    localSpannableString.setSpan(new ForegroundColorSpan(j), 0, paramString1.length(), 33);
    return localSpannableString;
  }
  
  public static final boolean a(String paramString)
  {
    if (!h.b(paramString))
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


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */