package com.ziroom.ziroomcustomer.payment.views.a;

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
  private TextView c;
  private TextView d;
  private EditText e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j = 60;
  private a k;
  private short l;
  
  public a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramContext, paramInt, paramString1, paramString2, paramString3, paramString4, (short)0);
  }
  
  public a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, short paramShort)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramString4;
    this.l = paramShort;
  }
  
  public a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramContext, 2131427591, paramString1, paramString2, paramString3, paramString4, (short)0);
  }
  
  private void a()
  {
    setContentView(2130904033);
    setCanceledOnTouchOutside(false);
    Button localButton1 = (Button)findViewById(2131692249);
    localButton1.setText(this.f);
    Button localButton2 = (Button)findViewById(2131690460);
    this.d = ((TextView)findViewById(2131694511));
    this.e = ((EditText)findViewById(2131689989));
    View localView = findViewById(2131694512);
    if (this.g == null)
    {
      localButton2.setVisibility(8);
      localView.setVisibility(8);
    }
    for (;;)
    {
      this.c = ((TextView)findViewById(2131693120));
      ((TextView)findViewById(2131693119)).setText(this.i);
      localButton2.setOnClickListener(this);
      localButton1.setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.k = new a(60000L, 1000L);
      switch (this.l)
      {
      case 0: 
      default: 
        return;
        localButton2.setText(this.g);
      }
    }
    localButton1.setTextColor(this.a.getResources().getColor(2131624563));
  }
  
  public void clearMessage()
  {
    this.e.setText("");
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
        this.k.start();
        return;
      } while (this.b == null);
      this.b.BtnCancleOnClickListener(paramView);
      return;
    } while (this.b == null);
    this.b.BtnYesOnClickListener(paramView, VdsAgent.trackEditTextSilent(this.e).toString());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDialogContent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.i = paramString4;
    this.h = paramString3;
    this.f = paramString1;
    this.g = paramString2;
    a();
  }
  
  public void setTipMessage(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void setUpdateOnClickListener(b paramb)
  {
    this.b = paramb;
  }
  
  public void startGetMessage()
  {
    this.k.start();
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/views/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */