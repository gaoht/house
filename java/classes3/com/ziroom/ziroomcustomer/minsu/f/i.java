package com.ziroom.ziroomcustomer.minsu.f;

import android.app.Activity;
import com.growingio.android.sdk.collection.GrowingIO;
import com.ziroom.ziroomcustomer.minsu.b.c;

public class i
{
  public static void StationHouseDetail(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    GrowingIO localGrowingIO = GrowingIO.getInstance();
    localGrowingIO.setPageGroup(paramActivity, paramActivity.getClass().getSimpleName());
    localGrowingIO.setPS1(paramActivity, paramString + "");
  }
  
  public static void houseDetail(Activity paramActivity, String paramString, int paramInt)
  {
    if (paramActivity == null) {}
    GrowingIO localGrowingIO;
    do
    {
      return;
      localGrowingIO = GrowingIO.getInstance();
      localGrowingIO.setPageGroup(paramActivity, paramActivity.getClass().getSimpleName());
      localGrowingIO.setPS7(paramActivity, paramInt + "");
      if (c.a != null) {
        localGrowingIO.setPS8(paramActivity, c.a);
      }
      if (paramInt == 1)
      {
        localGrowingIO.setPS9(paramActivity, paramString);
        return;
      }
    } while (paramInt != 0);
    localGrowingIO.setPS10(paramActivity, paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */