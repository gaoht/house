package com.ziroom.ziroomcustomer.minsu.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ae;

public class a
  extends Dialog
{
  private Context a;
  private String b;
  private String c;
  private a d;
  private Bundle e;
  private boolean f = false;
  private String g;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramContext.getResources().getString(2131297346);
    this.c = paramContext.getResources().getString(paramInt);
    setCanceledOnTouchOutside(true);
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramContext.getResources().getString(paramInt1);
    this.c = paramContext.getResources().getString(paramInt2);
    setCanceledOnTouchOutside(true);
  }
  
  public a(Context paramContext, int paramInt1, int paramInt2, Bundle paramBundle, a parama, boolean paramBoolean, String paramString)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramContext.getResources().getString(paramInt1);
    this.c = paramContext.getResources().getString(paramInt2);
    this.d = parama;
    this.e = paramBundle;
    this.f = paramBoolean;
    setCanceledOnTouchOutside(true);
    this.g = paramString;
  }
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramContext.getResources().getString(2131297346);
    this.c = paramString;
    setCanceledOnTouchOutside(true);
  }
  
  public a(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    setCanceledOnTouchOutside(true);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, a parama, boolean paramBoolean)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = parama;
    this.e = paramBundle;
    this.f = paramBoolean;
    setCanceledOnTouchOutside(true);
  }
  
  public void onCancel(View paramView)
  {
    dismiss();
    if (this.d != null) {
      this.d.onResult(false, this.e);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130904886);
    paramBundle = (Button)findViewById(2131690460);
    Button localButton = (Button)findViewById(2131692249);
    TextView localTextView = (TextView)findViewById(2131689533);
    setTitle(this.b);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (paramAnonymousView.getId() == 2131692249) {
          a.this.onOk(paramAnonymousView);
        }
        while (paramAnonymousView.getId() != 2131690460) {
          return;
        }
        a.this.onCancel(paramAnonymousView);
      }
    };
    paramBundle.setOnClickListener(local1);
    localButton.setOnClickListener(local1);
    if (this.b != null) {
      localTextView.setText(this.b);
    }
    if (this.f) {
      paramBundle.setVisibility(0);
    }
    if (ae.notNull(this.g)) {
      localButton.setText(this.g);
    }
    if (this.c != null)
    {
      paramBundle = (TextView)findViewById(2131693117);
      paramBundle.setMovementMethod(ScrollingMovementMethod.getInstance());
      paramBundle.setText(this.c);
    }
  }
  
  public void onOk(View paramView)
  {
    dismiss();
    if (this.d != null) {
      this.d.onResult(true, this.e);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean, Bundle paramBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */