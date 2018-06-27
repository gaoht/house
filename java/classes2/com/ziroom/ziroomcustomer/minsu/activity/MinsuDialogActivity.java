package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.n;

public class MinsuDialogActivity
  extends BaseActivity
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private String e;
  private String f;
  private CommonTitle g;
  
  private void a()
  {
    this.d = ((TextView)findViewById(2131691289));
    this.c = ((TextView)findViewById(2131691288));
    this.b = ((TextView)findViewById(2131691287));
    this.a = ((TextView)findViewById(2131689921));
    this.b.setText(this.e);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuDialogActivity.this.setResult(0);
        MinsuDialogActivity.this.finish();
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuDialogActivity.this.setResult(-1);
        MinsuDialogActivity.this.finish();
      }
    });
  }
  
  public void initTitle()
  {
    this.g = ((CommonTitle)findViewById(2131691272));
    this.g.setLeftButtonType(0);
    this.g.setMiddleText(this.f);
    this.g.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuDialogActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903271);
    this.e = getIntent().getStringExtra("content");
    this.f = getIntent().getStringExtra("title");
    initTitle();
    a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      setResult(0);
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setCancleVisible()
  {
    this.c.setVisibility(8);
    this.d.setWidth(n.dip2px(this, 200.0F));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */