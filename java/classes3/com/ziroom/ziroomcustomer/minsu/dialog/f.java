package com.ziroom.ziroomcustomer.minsu.dialog;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class f
  extends PopupWindow
  implements View.OnClickListener
{
  private View a;
  private Activity b;
  private View.OnClickListener c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g = null;
  private boolean h = false;
  
  public f(Activity paramActivity, View.OnClickListener paramOnClickListener)
  {
    super(paramActivity);
    this.b = paramActivity;
    this.c = paramOnClickListener;
    this.a = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130905057, null);
    this.d = ((TextView)this.a.findViewById(2131691407));
    this.e = ((TextView)this.a.findViewById(2131691408));
    this.f = ((TextView)this.a.findViewById(2131691410));
    this.g = ((TextView)this.a.findViewById(2131691406));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.a.setOnClickListener(this);
    setWidth(-1);
    setHeight(-1);
    setContentView(this.a);
    setFocusable(true);
    setAnimationStyle(2131427508);
    setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
    setOutsideTouchable(true);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    dismiss();
    this.c.onClick(paramView);
  }
  
  public void setCity(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void setClearShow(boolean paramBoolean)
  {
    this.h = paramBoolean;
    TextView localTextView = this.g;
    if (this.h) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void setCount(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void setDate(String paramString)
  {
    this.e.setText(paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */