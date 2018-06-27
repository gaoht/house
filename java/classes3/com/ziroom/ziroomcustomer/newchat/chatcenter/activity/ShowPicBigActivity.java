package com.ziroom.ziroomcustomer.newchat.chatcenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.newServiceList.view.ZoomableDraweeView;

public class ShowPicBigActivity
  extends BaseActivity
{
  private Context a;
  private ZoomableDraweeView b;
  
  private void a()
  {
    String str = getIntent().getStringExtra("imageUrl");
    this.b = ((ZoomableDraweeView)findViewById(2131692409));
    this.b.setController(c.frescoController(str));
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ShowPicBigActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903497);
    this.a = this;
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/activity/ShowPicBigActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */