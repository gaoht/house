package com.ziroom.ziroomcustomer.minsu.chat.photoview;

import android.os.Build.VERSION;
import android.view.View;

class a
{
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      c.postOnAnimation(paramView, paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/photoview/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */