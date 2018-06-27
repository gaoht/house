package com.ziroom.ziroomcustomer.minsu.f;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.Arrays;

public class y
{
  public static void checkPermis(Activity paramActivity, String... paramVarArgs)
  {
    int j;
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      String str;
      if (i < j)
      {
        str = paramVarArgs[i];
        if (ContextCompat.checkSelfPermission(paramActivity, str) != 0) {
          ActivityCompat.requestPermissions(paramActivity, paramVarArgs, 16842960);
        }
      }
      else
      {
        return;
      }
      Log.i("info check per", "have permiss = " + str + "  | " + Arrays.asList(paramVarArgs).toString());
      i += 1;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */