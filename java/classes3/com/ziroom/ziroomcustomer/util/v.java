package com.ziroom.ziroomcustomer.util;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;

public class v
  implements View.OnFocusChangeListener
{
  Context a;
  String b;
  
  public v(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      w.onEvent(this.a, this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/util/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */