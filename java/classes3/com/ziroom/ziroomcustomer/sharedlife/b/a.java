package com.ziroom.ziroomcustomer.sharedlife.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView;
import com.ziroom.commonlibrary.widget.unifiedziroom.b;

public class a
  extends b
{
  private final Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private GridPasswordView e;
  private a f;
  
  public a(Context paramContext)
  {
    super(paramContext, 2131427696);
    this.a = paramContext;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903805, null);
    this.e = ((GridPasswordView)localView.findViewById(2131691708));
    this.e.setPasswordVisibility(true);
    this.b = ((TextView)localView.findViewById(2131689541));
    this.c = ((TextView)localView.findViewById(2131691363));
    this.d = ((TextView)localView.findViewById(2131690460));
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.this.dismiss();
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (a.a(a.this) != null) {
          a.a(a.this).passWord(a.b(a.this).getPassWord());
        }
      }
    });
  }
  
  public GridPasswordView getGridPwdView()
  {
    return this.e;
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
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(17);
  }
  
  public void setOnPassWordListener(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void passWord(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */