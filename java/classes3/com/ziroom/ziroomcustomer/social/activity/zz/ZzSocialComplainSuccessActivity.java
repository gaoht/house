package com.ziroom.ziroomcustomer.social.activity.zz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class ZzSocialComplainSuccessActivity
  extends BaseActivity
{
  private TextView a;
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131689895));
    final String str = getIntent().getStringExtra("isFrom");
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if ((!TextUtils.isEmpty(str)) && ("isFrom_friendlist".equals(str)))
        {
          ZzSocialComplainSuccessActivity.this.finish();
          return;
        }
        paramAnonymousView = new Intent(ZzSocialComplainSuccessActivity.this, ZzSocialFriendListActivity.class);
        ZzSocialComplainSuccessActivity.this.startActivity(paramAnonymousView);
        ZzSocialComplainSuccessActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903636);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialComplainSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */