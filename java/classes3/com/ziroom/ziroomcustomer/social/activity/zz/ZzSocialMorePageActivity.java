package com.ziroom.ziroomcustomer.social.activity.zz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.util.u;

public class ZzSocialMorePageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ZzSocialMorePageActivity a;
  private ImageView b;
  private RelativeLayout c;
  private RelativeLayout d;
  private RelativeLayout e;
  private String f;
  private TextView g;
  private Boolean r = Boolean.valueOf(true);
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((RelativeLayout)findViewById(2131693099));
    this.d = ((RelativeLayout)findViewById(2131693100));
    this.e = ((RelativeLayout)findViewById(2131693101));
    this.g = ((TextView)findViewById(2131693102));
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void b(final int paramInt)
  {
    n.setSocialZzAble(this.a, paramInt, new com.ziroom.ziroomcustomer.e.a.d(this.a, new f(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        u.d("sjdglkj", "=======  saveSocialZzFilter " + paramAnonymousString);
        if (paramInt == 0)
        {
          paramAnonymousString = new Intent(ZzSocialMorePageActivity.a(ZzSocialMorePageActivity.this), MainActivity.class);
          paramAnonymousString.putExtra("FRAGMENT_TYPE", 7);
          ZzSocialMorePageActivity.this.startActivity(paramAnonymousString);
        }
        while (paramInt != 1) {
          return;
        }
        g.textToast(ZzSocialMorePageActivity.a(ZzSocialMorePageActivity.this), "已开启");
        ZzSocialMorePageActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    this.f = getIntent().getStringExtra("isAble");
    this.r = Boolean.valueOf(getIntent().getBooleanExtra("isCanStart", true));
    if ((!TextUtils.isEmpty(this.f)) && ("yes".equals(this.f)))
    {
      this.g.setText("开启Meeta交友");
      return;
    }
    this.g.setText("停用Meeta交友");
  }
  
  private void f()
  {
    if ((!TextUtils.isEmpty(this.f)) && ("yes".equals(this.f)))
    {
      if (this.r.booleanValue())
      {
        b(1);
        return;
      }
      new com.ziroom.ziroomcustomer.social.view.d(this.a).show();
      return;
    }
    c.newBuilder(this.a).setTitle("停用").setContent("停用该功能，个人信息不可被陌生人看见并搭讪").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          ZzSocialMorePageActivity.a(ZzSocialMorePageActivity.this, 0);
        }
      }
    }).build().show();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131693099: 
      paramView = new Intent(this.a, ZzSocialMySpaceActivity.class);
      paramView.putExtra("isEditer", true);
      startActivity(paramView);
      return;
    case 2131693100: 
      paramView = new Intent(this.a, ZzSocialConditionActivity.class);
      paramView.putExtra("isMorePage", "yes");
      startActivity(paramView);
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903639);
    this.a = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMorePageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */