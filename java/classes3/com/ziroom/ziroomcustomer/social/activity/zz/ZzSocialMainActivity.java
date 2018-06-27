package com.ziroom.ziroomcustomer.social.activity.zz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.signed.o;
import com.ziroom.ziroomcustomer.social.model.s;
import com.ziroom.ziroomcustomer.social.model.s.a;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class ZzSocialMainActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ZzSocialMainActivity a;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  private SimpleDraweeView e;
  private TextView f;
  private Intent g;
  private TextView r;
  private TextView s;
  private TextView t;
  private RelativeLayout u;
  private EMMessageListener v;
  private int w = 0;
  
  private void a()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.b = ((ImageView)findViewById(2131690023));
    this.u = ((RelativeLayout)findViewById(2131691813));
    this.d = ((ImageView)findViewById(2131692492));
    this.e = ((SimpleDraweeView)findViewById(2131690941));
    this.r = ((TextView)findViewById(2131692493));
    this.s = ((TextView)findViewById(2131692494));
    this.f = ((TextView)findViewById(2131692495));
    this.t = ((TextView)findViewById(2131690394));
  }
  
  private void a(int paramInt, boolean paramBoolean, final String paramString)
  {
    if (paramInt == 0) {
      e.newBuilder(this.a).setTitle("提示").setContent(paramString).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
        }
      }).build().show();
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        if (paramBoolean)
        {
          this.g = new Intent(this.a, ZzSocialMorePageActivity.class);
          startActivity(this.g);
          return;
        }
        ZzSocialMatchActivity.startMatchActivity(this.a);
        return;
      }
      if (paramInt == 10)
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("去开启").setContent(paramString).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = new Intent(ZzSocialMainActivity.a(ZzSocialMainActivity.this), ZzSocialBaseMessageActivity.class);
              ZzSocialMainActivity.this.startActivity(paramAnonymousView);
            }
          }
        }).build().show();
        return;
      }
      if (paramInt == 15)
      {
        if (paramBoolean)
        {
          this.g = new Intent(this.a, ZzSocialMorePageActivity.class);
          startActivity(this.g);
          return;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setBtnCancelText("去开启").setBtnConfirmText("完善个人信息").setContent(paramString).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = new Intent(ZzSocialMainActivity.a(ZzSocialMainActivity.this), ZzSocialMySpaceActivity.class);
              paramAnonymousView.putExtra("isEditer", true);
              ZzSocialMainActivity.a(ZzSocialMainActivity.this).startActivity(paramAnonymousView);
              return;
            }
            ZzSocialMatchActivity.startMatchActivity(ZzSocialMainActivity.a(ZzSocialMainActivity.this));
          }
        }).build().show();
        return;
      }
      if (paramInt == 20)
      {
        e.newBuilder(this.a).setTitle("提示").setContent(paramString).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
      if (paramInt == 25)
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("去实名认证").setContent(paramString).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean) {
              o.toCertificate(ZzSocialMainActivity.a(ZzSocialMainActivity.this), null);
            }
          }
        }).build().show();
        return;
      }
      if (paramInt == 30)
      {
        e.newBuilder(this.a).setTitle("提示").setButtonText("关闭").setContent(paramString).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
      if (paramInt == 35)
      {
        if (paramBoolean)
        {
          paramString = new Intent(this.a, ZzSocialMorePageActivity.class);
          paramString.putExtra("isAble", "yes");
          paramString.putExtra("isCanStart", false);
          startActivity(paramString);
          return;
        }
        new com.ziroom.ziroomcustomer.social.view.d(this.a).show();
        return;
      }
      if (paramInt == 40)
      {
        g.textToast(this.a, paramString);
        return;
      }
      if (paramInt == 45)
      {
        if (paramBoolean)
        {
          paramString = new Intent(this.a, ZzSocialMorePageActivity.class);
          paramString.putExtra("isAble", "yes");
          startActivity(paramString);
          return;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setBtnCancelText("取消").setBtnConfirmText("去开启").setContent(paramString).setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = new Intent(ZzSocialMainActivity.a(ZzSocialMainActivity.this), ZzSocialMorePageActivity.class);
              paramAnonymousView.putExtra("isAble", "yes");
              ZzSocialMainActivity.this.startActivity(paramAnonymousView);
            }
          }
        }).build().show();
        return;
      }
      if (paramInt == 50)
      {
        e.newBuilder(this.a).setTitle("提示").setContent(paramString).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
          }
        }).build().show();
        return;
      }
    } while (paramInt != 55);
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent(paramString).setBtnConfirmText("更换照片").setBtnCancelText("退出").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          paramAnonymousView = new Intent(ZzSocialMainActivity.a(ZzSocialMainActivity.this), ZzSocialChangeBaseMessageActivity.class);
          paramAnonymousView.putExtra("title", paramString);
          paramAnonymousView.putExtra("isReset", true);
          paramAnonymousView.putExtra("des", "一段走心的自我介绍能让自如客感受你的诚意噢");
          ZzSocialMainActivity.a(ZzSocialMainActivity.this).startActivity(paramAnonymousView);
          return;
        }
        ZzSocialMainActivity.a(ZzSocialMainActivity.this).finish();
      }
    }).build().show();
  }
  
  private void a(s params)
  {
    final int i = params.getStatus();
    this.w = params.getStatus();
    final String str1 = params.getMsg();
    this.u.setVisibility(0);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZzSocialMainActivity.a(ZzSocialMainActivity.this, i, true, str1);
      }
    });
    String str2 = ((s.a)params.getBanner().get(0)).getImg();
    if (this.e.getTag() == null)
    {
      this.e.setTag(str2);
      this.e.setController(com.freelxl.baselibrary.f.c.frescoController(str2));
    }
    for (;;)
    {
      this.r.setText(params.getTitle());
      this.s.setText(params.getDescription());
      this.f.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ZzSocialMainActivity.a(ZzSocialMainActivity.this, i, false, str1);
        }
      });
      if (i == 55) {
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent(str1).setBtnConfirmText("更换照片").setBtnCancelText("退出").setOnConfirmClickListener(new c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = new Intent(ZzSocialMainActivity.a(ZzSocialMainActivity.this), ZzSocialChangeBaseMessageActivity.class);
              paramAnonymousView.putExtra("title", str1);
              paramAnonymousView.putExtra("isReset", true);
              paramAnonymousView.putExtra("des", "一段走心的自我介绍能让自如客感受你的诚意噢");
              ZzSocialMainActivity.a(ZzSocialMainActivity.this).startActivity(paramAnonymousView);
              return;
            }
            ZzSocialMainActivity.a(ZzSocialMainActivity.this).finish();
          }
        }).build().show();
      }
      return;
      if (!this.e.getTag().equals(str2))
      {
        this.e.setTag(str2);
        this.e.setController(com.freelxl.baselibrary.f.c.frescoController(str2));
      }
    }
  }
  
  private void b()
  {
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  private void e()
  {
    if (com.ziroom.ziroomcustomer.social.b.d.getZzSocialUnReadMsgSize() > 0)
    {
      this.b.setImageResource(2130840304);
      this.t.setVisibility(0);
    }
    for (;;)
    {
      f();
      return;
      this.b.setImageResource(2130840309);
      this.t.setVisibility(8);
    }
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.e.n.getSocialZzIndexData(this.a, new com.ziroom.ziroomcustomer.e.a.d(this.a, new f(s.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        if ((paramAnonymousThrowable instanceof com.ziroom.ziroomcustomer.e.b.a))
        {
          if ("40005".equals(((com.ziroom.ziroomcustomer.e.b.a)paramAnonymousThrowable).getCode())) {
            com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(ZzSocialMainActivity.a(ZzSocialMainActivity.this)).setTitle("提示").setBtnCancelText("去个人中心").setBtnConfirmText("去登录").setContent("登录态已失效").setOnConfirmClickListener(new c.b()
            {
              public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
              {
                if (paramAnonymous2Boolean)
                {
                  com.ziroom.commonlibrary.login.a.startLoginActivity(ZzSocialMainActivity.a(ZzSocialMainActivity.this));
                  return;
                }
                paramAnonymous2View = new Intent(ZzSocialMainActivity.a(ZzSocialMainActivity.this), MainActivity.class);
                paramAnonymous2View.putExtra("FRAGMENT_TYPE", 7);
                ZzSocialMainActivity.this.startActivity(paramAnonymous2View);
              }
            }).build().show();
          }
          return;
        }
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, s paramAnonymouss)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouss);
        if (paramAnonymouss != null) {
          ZzSocialMainActivity.a(ZzSocialMainActivity.this, paramAnonymouss);
        }
      }
    });
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
    }
    if (this.w == 35)
    {
      new com.ziroom.ziroomcustomer.social.view.d(this.a).show();
      return;
    }
    this.g = new Intent(this.a, ZzSocialFriendListActivity.class);
    startActivity(this.g);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903509);
    this.a = this;
    a();
    b();
    e();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    f();
    if (com.ziroom.ziroomcustomer.social.b.d.getZzSocialUnReadMsgSize() > 0)
    {
      this.b.setImageResource(2130840304);
      this.t.setVisibility(0);
      return;
    }
    this.b.setImageResource(2130840309);
    this.t.setVisibility(8);
  }
  
  protected void onResume()
  {
    super.onResume();
    int j = ac.getScreenHeight(this.a);
    int k = ac.getStatusHeight(this.a);
    int i = j.getDisplayWidth(this.a);
    j = (j - k - i - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 56.0F) - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 60.0F) - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 48.0F)) / 3;
    Object localObject = this.e.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    u.d("jsdklgjdfgj", "======= " + com.ziroom.ziroomcustomer.util.n.px2dip(this.a, j));
    localObject = (LinearLayout.LayoutParams)this.r.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = j;
    this.r.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.f.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = j;
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      if (this.v == null) {
        this.v = new a();
      }
      EMClient.getInstance().chatManager().addMessageListener(this.v);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.v != null) {
      EMClient.getInstance().chatManager().removeMessageListener(this.v);
    }
  }
  
  class a
    implements EMMessageListener
  {
    a() {}
    
    public void onCmdMessageReceived(List<EMMessage> paramList)
    {
      u.e("接收到的消息", "=======  onCmdMessageReceived" + com.alibaba.fastjson.a.toJSONString(paramList));
    }
    
    public void onMessageChanged(EMMessage paramEMMessage, Object paramObject)
    {
      u.e("接收到的消息", "=======  onMessageChanged" + com.alibaba.fastjson.a.toJSONString(paramEMMessage));
    }
    
    public void onMessageDelivered(List<EMMessage> paramList)
    {
      u.e("接收到的消息", "=======  onMessageDelivered" + com.alibaba.fastjson.a.toJSONString(paramList));
    }
    
    public void onMessageRead(List<EMMessage> paramList)
    {
      u.e("接收到的消息", "=======  onMessageRead" + com.alibaba.fastjson.a.toJSONString(paramList));
    }
    
    public void onMessageRecalled(List<EMMessage> paramList) {}
    
    public void onMessageReceived(List<EMMessage> paramList)
    {
      u.e("接收到的消息", "=======  onMessageReceived" + com.alibaba.fastjson.a.toJSONString(paramList));
      final int i = com.ziroom.ziroomcustomer.social.b.d.getZzSocialUnReadMsgSize();
      u.d("接收到的消息", "======== " + i);
      ZzSocialMainActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (i > 0)
          {
            ZzSocialMainActivity.b(ZzSocialMainActivity.this).setImageResource(2130840304);
            ZzSocialMainActivity.c(ZzSocialMainActivity.this).setVisibility(0);
            return;
          }
          ZzSocialMainActivity.b(ZzSocialMainActivity.this).setImageResource(2130840309);
          ZzSocialMainActivity.c(ZzSocialMainActivity.this).setVisibility(8);
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */