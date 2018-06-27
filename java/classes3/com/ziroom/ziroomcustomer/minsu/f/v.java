package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.text.TextUtils;
import com.ziroom.ziroomcustomer.util.w;

public class v
{
  public static void onClick(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      w.onEvent(paramContext, paramString);
    }
  }
  
  public static void onClick(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      w.onEvent(paramContext, paramString1);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */