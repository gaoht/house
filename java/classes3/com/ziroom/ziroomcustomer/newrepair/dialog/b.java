package com.ziroom.ziroomcustomer.newrepair.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public class b
  extends Dialog
{
  private Context a;
  private int b;
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, 2131427591);
    this.a = paramContext;
    this.b = paramInt;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.a).inflate(2130903648, null);
    setContentView(paramBundle);
    TextView localTextView1 = (TextView)paramBundle.findViewById(2131691289);
    TextView localTextView2 = (TextView)paramBundle.findViewById(2131691288);
    ((TextView)paramBundle.findViewById(2131693113)).setText("确定删除该报修项？");
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        b.this.dismiss();
      }
    });
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        b.this.dismiss();
        paramAnonymousView = new Intent();
        paramAnonymousView.setAction("repair_delete");
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", b.a(b.this));
        paramAnonymousView.putExtras(localBundle);
        ApplicationEx.c.sendBroadcast(paramAnonymousView);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/dialog/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */