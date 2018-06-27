package com.ziroom.ziroomcustomer.minsu.view.a;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;

public class a
  extends PopupWindow
{
  public a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity);
    setWidth(-1);
    setHeight(-1);
    a(paramActivity, paramInt1, paramInt2);
  }
  
  private void a(final Context paramContext, int paramInt1, int paramInt2)
  {
    final View localView1 = LayoutInflater.from(paramContext).inflate(2130905072, null);
    setContentView(localView1);
    setFocusable(true);
    setOutsideTouchable(true);
    setBackgroundDrawable(ContextCompat.getDrawable(paramContext, 2130839671));
    paramContext = (RelativeLayout.LayoutParams)localView1.findViewById(2131697350).getLayoutParams();
    paramContext.height = paramInt1;
    paramContext.setMargins(0, paramInt2, 0, 0);
    paramContext = localView1.findViewById(2131697349);
    final View localView2 = localView1.findViewById(2131697352);
    localView1 = localView1.findViewById(2131697355);
    paramContext.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramContext.setVisibility(8);
        localView2.setVisibility(0);
        localView1.setVisibility(8);
        return false;
      }
    });
    localView2.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramContext.setVisibility(8);
        localView2.setVisibility(8);
        localView1.setVisibility(0);
        return false;
      }
    });
    localView1.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        a.this.dismiss();
        return false;
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */