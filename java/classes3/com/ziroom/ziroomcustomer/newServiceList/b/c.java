package com.ziroom.ziroomcustomer.newServiceList.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newclean.d.bd;
import com.ziroom.ziroomcustomer.newclean.periodclean.activity.PeriodCleanerSelectActivity;
import com.ziroom.ziroomcustomer.util.ac;

public class c
  extends Dialog
{
  private Context a;
  private View b;
  private View c;
  private SimpleDraweeView d;
  private ImageView e;
  private TextView f;
  private RelativeLayout g;
  private bd h;
  
  public c(Context paramContext, bd parambd)
  {
    super(paramContext, 2131427591);
    this.a = paramContext;
    this.h = parambd;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903847, null);
    this.g = ((RelativeLayout)localView.findViewById(2131693875));
    this.d = ((SimpleDraweeView)localView.findViewById(2131693871));
    this.e = ((ImageView)localView.findViewById(2131690588));
    this.f = ((TextView)localView.findViewById(2131690048));
    this.b = localView.findViewById(2131690379);
    this.c = localView.findViewById(2131692133);
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    int i = ac.getScreenHeight(this.a);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.height = (i * 94 / 667);
    this.c.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.height = (i * 94 / 667);
    this.b.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.g.getLayoutParams();
    localLayoutParams.height = (i * 410 / 667);
    this.g.setLayoutParams(localLayoutParams);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.this.dismiss();
      }
    });
    if (!TextUtils.isEmpty(this.h.getImage())) {
      this.d.setController(com.freelxl.baselibrary.f.c.frescoController(this.h.getImage()));
    }
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.this.dismiss();
        PeriodCleanerSelectActivity.StartPeriodCleanActivity((Activity)c.a(c.this));
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(false);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    ac.getScreenWidth(this.a);
    ac.getScreenHeight(this.a);
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(48);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */