package com.ziroom.ziroomcustomer.newrepair.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class c
  extends Dialog
{
  private Context a;
  
  public c(Context paramContext)
  {
    super(paramContext, 2131427596);
    this.a = paramContext;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.a).inflate(2130903649, null);
    setContentView(paramBundle);
    ((RelativeLayout)paramBundle.findViewById(2131693114)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.this.dismiss();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/dialog/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */