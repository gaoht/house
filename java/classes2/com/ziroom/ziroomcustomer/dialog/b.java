package com.ziroom.ziroomcustomer.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.a;

public class b
  extends a
  implements View.OnClickListener
{
  private Activity a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private int f;
  private a g;
  
  public b(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity;
  }
  
  public b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1);
    this.a = paramActivity;
    this.f = paramInt2;
  }
  
  private void a()
  {
    this.b = ((TextView)findViewById(2131693865));
    this.c = ((TextView)findViewById(2131689530));
    this.d = ((TextView)findViewById(2131693866));
    this.e = ((TextView)findViewById(2131693867));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    if (this.f == 1) {
      this.c.setVisibility(8);
    }
    while (this.f != 2) {
      return;
    }
    this.c.setVisibility(0);
  }
  
  private void a(int paramInt)
  {
    this.g.onCerSelectListener(paramInt);
    dismiss();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693865: 
      a(1);
      return;
    case 2131689530: 
      a(2);
      return;
    case 2131693866: 
      a(13);
      return;
    }
    a(6);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903843);
    a();
  }
  
  public void setOnCerSelectListener(a parama)
  {
    this.g = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCerSelectListener(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */