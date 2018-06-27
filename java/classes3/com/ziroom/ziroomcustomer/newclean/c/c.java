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

public class c
  extends Dialog
{
  private Context a;
  private int b;
  private int c;
  private int d;
  
  public c(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
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
    ImageView localImageView = (ImageView)localView.findViewById(2131690588);
    localTextView1.setText(this.b + "元");
    if (this.c > 0)
    {
      localTextView2.setText("-" + this.c + "元");
      ((RelativeLayout)localObject).setVisibility(0);
    }
    for (;;)
    {
      localTextView3.setText(this.d + "");
      localImageView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.this.dismiss();
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
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */