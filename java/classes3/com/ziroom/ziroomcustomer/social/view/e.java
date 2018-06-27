package com.ziroom.ziroomcustomer.social.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.social.b.c;
import com.ziroom.ziroomcustomer.social.model.x;
import java.util.List;

public class e
  extends Dialog
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private x f;
  
  public e(Context paramContext, x paramx)
  {
    super(paramContext, 2131427591);
    this.a = paramContext;
    this.f = paramx;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903878, null);
    a(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131693936));
    this.c = ((TextView)paramView.findViewById(2131692740));
    this.d = ((TextView)paramView.findViewById(2131693937));
    this.e = ((ImageView)paramView.findViewById(2131690588));
    b();
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        e.a(e.this);
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        e.this.dismiss();
      }
    });
  }
  
  private void b()
  {
    if (this.f != null)
    {
      if (this.f.getApplyed() != 0) {
        break label83;
      }
      this.b.setText("功能被冻结");
      if ((this.f.getDesc() != null) && (this.f.getDesc().size() > 0)) {
        this.c.setText((CharSequence)this.f.getDesc().get(0));
      }
      this.d.setVisibility(0);
    }
    label83:
    while (this.f.getApplyed() != 1) {
      return;
    }
    this.b.setText("解冻申请审核中");
    if ((this.f.getDesc() != null) && (this.f.getDesc().size() > 1)) {
      this.c.setText((CharSequence)this.f.getDesc().get(1));
    }
    this.d.setVisibility(8);
  }
  
  private void c()
  {
    n.setSocialZzUnFreeze(this.a, new d(this.a, new f(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        e.b(e.this).setText("解冻申请审核中");
        e.c(e.this).setText("你的恢复申请已提交，我们将会尽快核实并短信通知你审核结果。");
        e.d(e.this).setVisibility(8);
        c.showToast(e.e(e.this), "");
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/view/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */