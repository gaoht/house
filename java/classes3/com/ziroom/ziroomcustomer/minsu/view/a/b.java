package com.ziroom.ziroomcustomer.minsu.view.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.u;

public class b
  extends PopupWindow
{
  public b(BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    super(paramBaseActivity);
    setWidth(-1);
    setHeight(-1);
    a(paramBaseActivity, paramInt1, paramInt2);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130905073, null);
    Object localObject = (ImageView)localView.findViewById(2131697358);
    setContentView(localView);
    localObject = (FrameLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    i = ac.getStatusHeight(paramContext) + i;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    u.e("error", "top = " + i + " right = " + paramInt1);
    ((FrameLayout.LayoutParams)localObject).setMargins(0, i, paramInt1, 0);
    setFocusable(true);
    setOutsideTouchable(true);
    setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        b.this.dismiss();
        return false;
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */