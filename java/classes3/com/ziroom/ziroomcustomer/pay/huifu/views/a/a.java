package com.ziroom.ziroomcustomer.pay.huifu.views.a;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class a
  extends Dialog
  implements View.OnClickListener
{
  Context a;
  public b b = null;
  private Button c;
  private Button d;
  private TextView e;
  private TextView f;
  private TextView g;
  private EditText h;
  private String i;
  private String j;
  private String k;
  private String l;
  private View m;
  private int n = 60;
  private a o;
  private short p;
  
  public a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, paramString4, (short)0);
  }
  
  public a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, short paramShort)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramString3;
    this.l = paramString4;
    this.p = paramShort;
  }
  
  public a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramContext, 2131427591, paramString1, paramString2, paramString3, paramString4, (short)0);
  }
  
  private void a()
  {
    setContentView(2130904033);
    setCanceledOnTouchOutside(false);
    this.d = ((Button)findViewById(2131692249));
    this.d.setText(this.i);
    this.c = ((Button)findViewById(2131690460));
    this.g = ((TextView)findViewById(2131694511));
    this.h = ((EditText)findViewById(2131689989));
    this.m = findViewById(2131694512);
    if (this.j == null)
    {
      this.c.setVisibility(8);
      this.m.setVisibility(8);
    }
    for (;;)
    {
      this.e = ((TextView)findViewById(2131693120));
      this.f = ((TextView)findViewById(2131693119));
      this.f.setText(this.l);
      this.c.setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.g.setOnClickListener(this);
      this.o = new a(60000L, 1000L);
      switch (this.p)
      {
      case 0: 
      default: 
        return;
        this.c.setText(this.j);
      }
    }
    this.d.setTextColor(this.a.getResources().getColor(2131624563));
  }
  
  public void clearMessage()
  {
    this.h.setText("");
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.b != null) {
      this.b.dismiss();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.b == null);
        this.b.BtnGetMessageOnClickListener(paramView);
        this.o.start();
        return;
      } while (this.b == null);
      this.b.BtnCancleOnClickListener(paramView);
      return;
    } while (this.b == null);
    this.b.BtnYesOnClickListener(paramView, VdsAgent.trackEditTextSilent(this.h).toString());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDialogContent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.l = paramString4;
    this.k = paramString3;
    this.i = paramString1;
    this.j = paramString2;
    a();
  }
  
  public void setTipMessage(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void setUpdateOnClickListener(b paramb)
  {
    this.b = paramb;
  }
  
  public void startGetMessage()
  {
    this.o.start();
  }
  
  class a
    extends CountDownTimer
  {
    public a(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    public void onFinish()
    {
      a.a(a.this).setText("重新获取");
      a.b(a.this).setText("");
      a.a(a.this).setClickable(true);
    }
    
    public void onTick(long paramLong)
    {
      a.a(a.this).setClickable(false);
      a.a(a.this).setText(paramLong / 1000L + "s");
    }
  }
  
  public static abstract interface b
  {
    public abstract void BtnCancleOnClickListener(View paramView);
    
    public abstract void BtnGetMessageOnClickListener(View paramView);
    
    public abstract void BtnYesOnClickListener(View paramView, String paramString);
    
    public abstract void dismiss();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/pay/huifu/views/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */