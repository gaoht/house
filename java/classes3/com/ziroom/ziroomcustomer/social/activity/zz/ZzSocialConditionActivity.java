package com.ziroom.ziroomcustomer.social.activity.zz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.social.model.w;
import com.ziroom.ziroomcustomer.social.model.w.a;
import com.ziroom.ziroomcustomer.social.model.w.b;
import java.util.Iterator;
import java.util.List;

public class ZzSocialConditionActivity
  extends BaseActivity
  implements View.OnClickListener
{
  String a = "";
  String b = "";
  String c = "";
  private ZzSocialConditionActivity d;
  private ImageView e;
  private LinearLayout f;
  private LinearLayout g;
  private ImageView r;
  private ImageView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private w w;
  private TextView x;
  private TextView y;
  private String z;
  
  private void a()
  {
    this.e = ((ImageView)findViewById(2131690588));
    this.f = ((LinearLayout)findViewById(2131693088));
    this.r = ((ImageView)findViewById(2131693089));
    this.g = ((LinearLayout)findViewById(2131693091));
    this.s = ((ImageView)findViewById(2131693092));
    this.t = ((TextView)findViewById(2131693094));
    this.u = ((TextView)findViewById(2131693095));
    this.x = ((TextView)findViewById(2131693090));
    this.y = ((TextView)findViewById(2131693093));
    this.v = ((TextView)findViewById(2131689956));
  }
  
  private void a(w paramw)
  {
    Object localObject;
    if (paramw.getGender() != null)
    {
      localObject = paramw.getGender().iterator();
      while (((Iterator)localObject).hasNext())
      {
        w.b localb = (w.b)((Iterator)localObject).next();
        if ((localb.getSelected() != null) && (localb.getSelected().intValue() == 1)) {
          if (localb.getValue() == 1) {
            a(true);
          } else if (localb.getValue() == 2) {
            a(false);
          }
        }
      }
    }
    if (paramw.getAge() != null)
    {
      paramw = paramw.getAge().iterator();
      while (paramw.hasNext())
      {
        localObject = (w.a)paramw.next();
        if ((((w.a)localObject).getSelected() != null) && (((w.a)localObject).getSelected().intValue() == 1)) {
          if (((w.a)localObject).getValue() == 1) {
            b(1);
          } else if (((w.a)localObject).getValue() == 2) {
            b(2);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.w == null) || (this.w.getGender() == null) || (this.w.getGender().size() == 0)) {
      return;
    }
    if (paramBoolean)
    {
      this.r.setBackgroundResource(2130840293);
      this.s.setBackgroundResource(2130840303);
      this.x.setTextColor(40960);
      this.y.setTextColor(-6710887);
      this.a = (((w.b)this.w.getGender().get(0)).getValue() + "");
      return;
    }
    this.r.setBackgroundResource(2130840294);
    this.s.setBackgroundResource(2130840302);
    this.x.setTextColor(-6710887);
    this.y.setTextColor(40960);
    this.a = (((w.b)this.w.getGender().get(1)).getValue() + "");
  }
  
  private void b()
  {
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if ((this.w == null) || (this.w.getAge() == null) || (this.w.getAge().size() == 0)) {}
    do
    {
      return;
      if (paramInt == 1)
      {
        this.t.setBackgroundResource(2130840008);
        this.u.setBackgroundResource(2130840007);
        this.t.setTextColor(40960);
        this.u.setTextColor(-6710887);
        this.b = (((w.a)this.w.getAge().get(0)).getValue() + "");
        return;
      }
    } while (paramInt != 2);
    this.t.setBackgroundResource(2130840007);
    this.u.setBackgroundResource(2130840008);
    this.t.setTextColor(-6710887);
    this.u.setTextColor(40960);
    this.b = (((w.a)this.w.getAge().get(1)).getValue() + "");
  }
  
  private void e()
  {
    this.z = getIntent().getStringExtra("isMorePage");
    if ((!TextUtils.isEmpty(this.z)) && ("yes".equals(this.z))) {
      this.v.setText("保存");
    }
    for (;;)
    {
      this.v.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ZzSocialConditionActivity.a(ZzSocialConditionActivity.this);
        }
      });
      n.setSocialZzFilter(this.d, new d(this.d, new f(w.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
        }
        
        public void onSuccess(int paramAnonymousInt, w paramAnonymousw)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousw);
          if (paramAnonymousw != null)
          {
            ZzSocialConditionActivity.a(ZzSocialConditionActivity.this, paramAnonymousw);
            ZzSocialConditionActivity.c(ZzSocialConditionActivity.this).setText(((w.a)ZzSocialConditionActivity.b(ZzSocialConditionActivity.this).getAge().get(0)).getDescription());
            ZzSocialConditionActivity.d(ZzSocialConditionActivity.this).setText(((w.a)ZzSocialConditionActivity.b(ZzSocialConditionActivity.this).getAge().get(1)).getDescription());
            ZzSocialConditionActivity.b(ZzSocialConditionActivity.this, paramAnonymousw);
          }
        }
      });
      return;
      this.v.setText("完成并开启Meeta交友");
    }
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.a))
    {
      g.textToast(this.d, "请先选择性别");
      return;
    }
    if (TextUtils.isEmpty(this.b))
    {
      g.textToast(this.d, "请先选择年龄");
      return;
    }
    n.saveSocialZzFilter(this.d, this.a, this.b, new d(this.d, new f(String.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        if ((!TextUtils.isEmpty(ZzSocialConditionActivity.e(ZzSocialConditionActivity.this))) && ("yes".equals(ZzSocialConditionActivity.e(ZzSocialConditionActivity.this))))
        {
          ZzSocialConditionActivity.this.finish();
          return;
        }
        ZzSocialMatchActivity.startMatchActivity(ZzSocialConditionActivity.f(ZzSocialConditionActivity.this));
        ZzSocialConditionActivity.this.finish();
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
    case 2131690588: 
      finish();
      return;
    case 2131693088: 
      a(true);
      return;
    case 2131693091: 
      a(false);
      return;
    case 2131693094: 
      b(1);
      return;
    }
    b(2);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903637);
    this.d = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialConditionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */