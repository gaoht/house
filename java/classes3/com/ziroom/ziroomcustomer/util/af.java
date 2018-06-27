package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import com.freelxl.baselibrary.f.g;

public class af
{
  public static void showToast(Context paramContext, int paramInt)
  {
    showToast(paramContext, paramInt, 0);
  }
  
  public static void showToast(Context paramContext, int paramInt1, int paramInt2)
  {
    g.textToast(paramContext, paramInt1, paramInt2);
  }
  
  public static void showToast(Context paramContext, String paramString)
  {
    showToast(paramContext, paramString, 0);
  }
  
  public static void showToast(Context paramContext, String paramString, int paramInt)
  {
    g.textToast(paramContext, paramString, paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */