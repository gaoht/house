package com.growingio.android.sdk.circle;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

public class k
  extends View
{
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(Rect paramRect)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.leftMargin = paramRect.left;
    localLayoutParams.topMargin = paramRect.top;
    localLayoutParams.width = paramRect.width();
    localLayoutParams.height = paramRect.height();
    setLayoutParams(localLayoutParams);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */