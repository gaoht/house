package com.ziroom.ziroomcustomer.util;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import java.util.HashMap;
import java.util.Map;

public class x
{
  public static int a;
  private static int b = 100;
  private static int[] c = { 256, 360, 480, 540, 640, 720, 960, 1080, 1242, 1440, 1536 };
  private static Map<String, String> d = new HashMap();
  private static Map<String, Integer> e = new HashMap();
  
  public static void init(Map<String, String> paramMap, int paramInt)
  {
    d = paramMap;
    setReductionRatio(paramInt);
    if (a == 0) {
      a = ApplicationEx.c.getResources().getDisplayMetrics().widthPixels;
    }
    if ((e == null) || (e.size() == 0))
    {
      int i = 1;
      if (i <= 10)
      {
        int k = (int)(a * i / 10.0F);
        paramMap = c;
        int m = paramMap.length;
        int j = 0;
        paramInt = 0;
        for (;;)
        {
          if (j < m)
          {
            paramInt = paramMap[j];
            if (paramInt < k) {}
          }
          else
          {
            e.put("" + i, Integer.valueOf(paramInt));
            i += 1;
            break;
          }
          j += 1;
        }
      }
    }
  }
  
  public static String makeUrl(String paramString)
  {
    return makeUrl(paramString, 1.0F);
  }
  
  public static String makeUrl(String paramString, float paramFloat)
  {
    Object localObject;
    String str2;
    if ((!d.isEmpty()) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("http://"))) && (paramString.length() > 8))
    {
      localObject = Uri.parse(paramString);
      if (localObject == null) {
        break label408;
      }
      str2 = ((Uri)localObject).getQueryParameter("mona_switch");
      if ((!TextUtils.isEmpty(str2)) && ("off".equals(str2))) {
        return paramString;
      }
      localObject = ((Uri)localObject).getQueryParameter("mona_compression_ratio");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label408;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localObject);
        localObject = paramString.substring(0, paramString.indexOf("/", 8));
        str2 = (String)d.get(localObject);
        if (!TextUtils.isEmpty(str2))
        {
          localObject = paramString.replaceFirst((String)localObject, str2);
          if (a == 0) {
            a = ApplicationEx.c.getResources().getDisplayMetrics().widthPixels;
          }
          float f;
          if (paramFloat <= 1.0F)
          {
            f = paramFloat;
            if (paramFloat >= 0.0F) {}
          }
          else
          {
            f = 1.0F;
          }
          j = (int)Math.ceil(10.0F * f);
          j = ((Integer)e.get(j + "")).intValue();
          if (j >= (int)(a * f)) {
            if ((i > 0) && (i <= 100)) {
              return (String)localObject + "_W_" + j + "_100000_Q" + i + ".webp";
            }
          }
        }
      }
      catch (Exception localException)
      {
        int j;
        i = 0;
        continue;
        return localException + "_W_" + j + "_100000_Q" + b + ".webp";
      }
      for (;;)
      {
        u.d("monaUtil", "===old=" + paramString);
        u.d("monaUtil", "===new=" + localException);
        return paramString;
        String str1 = paramString;
      }
      label408:
      int i = 0;
    }
  }
  
  public static void setReductionRatio(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 100)) {
      return;
    }
    b = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */