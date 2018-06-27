package com.ziroom.ziroomcustomer.util;

import android.app.Activity;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.GrowingIO;
import com.ziroom.ziroomcustomer.base.b;

public class o
{
  public static void houseDetail(Activity paramActivity, String paramString, int paramInt)
  {
    if (paramActivity == null) {}
    GrowingIO localGrowingIO;
    do
    {
      do
      {
        return;
        localGrowingIO = GrowingIO.getInstance();
        localGrowingIO.setPageGroup(paramActivity, paramActivity.getClass().getSimpleName());
        if (b.d != null) {
          localGrowingIO.setPS3(paramActivity, b.d);
        }
      } while (!ae.notNull(paramString));
      if (paramInt == 1)
      {
        localGrowingIO.setPS1(paramActivity, paramString);
        return;
      }
    } while (paramInt != 2);
    localGrowingIO.setPS2(paramActivity, paramString);
  }
  
  public static void setUserIdCS(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      GrowingIO.getInstance().setCS1("user_id", paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */