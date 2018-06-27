package com.ziroom.ziroomcustomer.morepage;

import android.content.Intent;
import android.os.Bundle;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class BaseServerActivity
  extends BaseActivity
{
  private MoreItemView a;
  private String b;
  private boolean c;
  
  private void a()
  {
    if (this.b.equals("租住公约")) {}
    while ((this.b.equals("自如服务承诺")) || (this.b.equals("在线报修-服务指南")) || (this.b.equals("在线预约保洁-服务指南")) || (this.b.equals("电子锁-使用指南")) || (this.b.equals("自如客宽带&保险")) || (this.b.equals("自如客积分")) || (this.b.equals("我的惠卡")) || (this.b.equals("我的积分")) || (!this.b.equals("我的合同"))) {
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904941);
    paramBundle = getIntent();
    this.b = paramBundle.getStringExtra("title");
    String str = paramBundle.getStringExtra("url");
    this.c = paramBundle.getBooleanExtra("isSharedShow", true);
    a();
    this.a = ((MoreItemView)findViewById(2131692134));
    this.a.setTitle(this.b);
    this.a.setSharedIconShow(this.c);
    this.a.setWeb(str);
    this.a.setBack(new MoreItemView.b()
    {
      public void backtoActivity()
      {
        BaseServerActivity.this.finish();
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/morepage/BaseServerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */