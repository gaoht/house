package com.ziroom.ziroomcustomer.newclean.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class b
  extends Dialog
{
  private Context a;
  private double b;
  private double c;
  private double d;
  
  public b(Context paramContext, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.b = paramDouble1;
    this.c = paramDouble2;
    this.d = paramDouble3;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903498, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131692410);
    TextView localTextView2 = (TextView)localView.findViewById(2131692412);
    TextView localTextView3 = (TextView)localView.findViewById(2131692407);
    Object localObject = (LinearLayout)localView.findViewById(2131692406);
    localObject = (RelativeLayout)localView.findViewById(2131689760);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131690734);
    TextView localTextView4 = (TextView)localView.findViewById(2131692411);
    ImageView localImageView = (ImageView)localView.findViewById(2131690588);
    localTextView1.setText((int)this.b + "元");
    if (this.c > 0.0D)
    {
      localTextView2.setText("-" + (int)this.c + "元");
      ((RelativeLayout)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (this.d > 0.0D)
      {
        localRelativeLayout.setVisibility(0);
        localTextView4.setText((int)this.d + "元");
      }
      double d2 = this.b + this.d - this.c;
      double d1 = d2;
      if (d2 <= 0.0D) {
        d1 = 0.0D;
      }
      localTextView3.setText((int)d1 + "");
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          b.this.dismiss();
        }
      });
      setContentView(localView);
      return;
      localTextView2.setText("0");
      ((RelativeLayout)localObject).setVisibility(8);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(true);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    localWindow.setWindowAnimations(2131427962);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */