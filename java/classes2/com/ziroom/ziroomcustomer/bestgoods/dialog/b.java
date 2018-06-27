package com.ziroom.ziroomcustomer.bestgoods.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.d;
import com.ziroom.ziroomcustomer.bestgoods.a.d.b;
import com.ziroom.ziroomcustomer.bestgoods.model.f;
import java.lang.ref.WeakReference;
import java.util.List;

public class b
  extends Dialog
  implements d.b
{
  private Context a;
  private WeakReference<BaseActivity> b;
  private LayoutInflater c;
  private TextView d;
  private View e;
  private RecyclerView f;
  private d g;
  private List<f> h;
  private a i;
  
  public b(BaseActivity paramBaseActivity, List<f> paramList)
  {
    super(paramBaseActivity, 2131427692);
    this.a = paramBaseActivity;
    this.b = new WeakReference(paramBaseActivity);
    this.h = paramList;
    setDefaultSetting();
  }
  
  private void a()
  {
    this.c = LayoutInflater.from(this.a);
    View localView = this.c.inflate(2130903791, null);
    this.d = ((TextView)localView.findViewById(2131689541));
    this.f = ((RecyclerView)localView.findViewById(2131693765));
    this.f.setLayoutManager(new LinearLayoutManager(this.a, 1, false));
    this.e = localView.findViewById(2131690588);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        b.this.dismiss();
      }
    });
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    this.g = new d((BaseActivity)this.b.get(), this.h);
    this.g.setLoginListener(this);
    this.f.setAdapter(this.g);
  }
  
  public void isLogin(boolean paramBoolean)
  {
    if (this.i != null) {
      this.i.resetCouponData(paramBoolean);
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
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public void setLoginStateListener(a parama)
  {
    this.i = parama;
  }
  
  public static abstract interface a
  {
    public abstract void resetCouponData(boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/dialog/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */