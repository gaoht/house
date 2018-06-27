package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class b
  extends com.ziroom.commonlibrary.widget.unifiedziroom.b
  implements View.OnClickListener
{
  private Context a;
  private LinearLayout b;
  private LinearLayout c;
  private CheckBox d;
  private CheckBox e;
  private TextView f;
  private TextView g;
  private final int h = 0;
  private final int i = 1;
  private int j = -1;
  private a k;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131427695);
    this.a = paramContext;
  }
  
  private void a()
  {
    this.b = ((LinearLayout)findViewById(2131690693));
    this.c = ((LinearLayout)findViewById(2131693811));
    this.d = ((CheckBox)findViewById(2131693810));
    this.e = ((CheckBox)findViewById(2131693812));
    this.f = ((TextView)findViewById(2131691363));
    this.g = ((TextView)findViewById(2131690460));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 0;
    this.e.setChecked(paramBoolean);
    CheckBox localCheckBox = this.d;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      localCheckBox.setChecked(bool);
      if (!paramBoolean) {
        break label43;
      }
    }
    for (;;)
    {
      this.j = m;
      return;
      bool = false;
      break;
      label43:
      m = 1;
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690693: 
      a(false);
      return;
    case 2131693811: 
      a(true);
      return;
    case 2131691363: 
      onConfirm();
      return;
    }
    dismiss();
  }
  
  public void onConfirm()
  {
    if ((this.j != 1) && (this.j != 0))
    {
      g.textToast(this.a, "请选择一项发票服务");
      return;
    }
    if (this.k != null) {
      this.k.onTypeSelect(this.j);
    }
    dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903809);
    a();
  }
  
  public void setOnTypeSelectListener(a parama)
  {
    this.k = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onTypeSelect(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */