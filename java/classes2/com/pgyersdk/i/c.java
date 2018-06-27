package com.pgyersdk.i;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class c
{
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F * paramFloat + 0.5F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */