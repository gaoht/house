package com.ziroom.ziroomcustomer.morepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.Server;
import com.ziroom.ziroomcustomer.model.ServerDetail;
import java.util.Iterator;
import java.util.List;

public class OtherServerActivity
  extends BaseActivity
{
  private MoreItemView a;
  private String b;
  private ImageView c;
  private Handler d = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      OtherServerActivity.this.dismissProgress();
      final Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (((l)localObject).getSuccess().booleanValue())
      {
        paramAnonymousMessage = ((Server)((l)localObject).getObject()).getList().iterator();
        while (paramAnonymousMessage.hasNext())
        {
          localObject = (ServerDetail)paramAnonymousMessage.next();
          if (((ServerDetail)localObject).getTitle().equals(OtherServerActivity.a(OtherServerActivity.this))) {
            OtherServerActivity.c(OtherServerActivity.this).post(new Runnable()
            {
              public void run()
              {
                OtherServerActivity.b(OtherServerActivity.this).setWeb(localObject.getUrl());
              }
            });
          }
        }
      }
      OtherServerActivity.this.showToast(((l)localObject).getMessage());
      OtherServerActivity.this.dismissProgress();
    }
  };
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904941);
    this.b = getIntent().getStringExtra("title");
    this.a = ((MoreItemView)findViewById(2131692134));
    this.c = ((ImageView)findViewById(2131691042));
    this.c.setVisibility(8);
    this.a.setTitle(this.b);
    this.a.setBack(new MoreItemView.b()
    {
      public void backtoActivity()
      {
        OtherServerActivity.this.finish();
      }
    });
    if (!checkNet(getApplicationContext()))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 1);
      return;
    }
    o.getGuideList(this, this.d);
    showProgress("正在加载");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/morepage/OtherServerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */