package com.ziroom.ziroomcustomer.my;

import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public abstract class OwnerBaseActivity
  extends BaseActivity
{
  public Handler c = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      OwnerBaseActivity.this.a();
    }
  };
  
  abstract void a();
  
  public void closeError(View paramView, ViewStub paramViewStub)
  {
    if ((paramView != null) && (paramViewStub != null))
    {
      paramView.setVisibility(0);
      paramViewStub.setVisibility(8);
    }
  }
  
  abstract void initData();
  
  public void showError(View paramView, ViewStub paramViewStub, String paramString)
  {
    if ((paramView != null) && (paramViewStub != null))
    {
      paramView.setVisibility(8);
      paramViewStub.setVisibility(0);
      ((TextView)findViewById(2131690822)).setText(paramString);
      paramView = (TextView)findViewById(2131694446);
      paramView.getPaint().setFlags(8);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          OwnerBaseActivity.this.initData();
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/OwnerBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */