package com.ziroom.ziroomcustomer.newrepair.dialog;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.PopupWindow;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class d
  extends PopupWindow
{
  private Button a;
  private Button b;
  private Button c;
  private View d;
  
  public d(Activity paramActivity, View.OnClickListener paramOnClickListener)
  {
    super(paramActivity);
    this.d = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130905030, null);
    this.a = ((Button)this.d.findViewById(2131692507));
    this.b = ((Button)this.d.findViewById(2131697266));
    this.c = ((Button)this.d.findViewById(2131690460));
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.this.dismiss();
      }
    });
    this.b.setOnClickListener(paramOnClickListener);
    this.a.setOnClickListener(paramOnClickListener);
    setContentView(this.d);
    setWidth(-1);
    setHeight(-1);
    setFocusable(true);
    setBackgroundDrawable(new ColorDrawable(-1342177280));
    this.d.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        int i = d.a(d.this).findViewById(2131696851).getTop();
        int j = (int)paramAnonymousMotionEvent.getY();
        if ((paramAnonymousMotionEvent.getAction() == 1) && (j < i)) {
          d.this.dismiss();
        }
        return true;
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/dialog/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */