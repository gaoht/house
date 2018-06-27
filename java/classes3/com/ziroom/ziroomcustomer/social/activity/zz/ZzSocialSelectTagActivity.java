package com.ziroom.ziroomcustomer.social.activity.zz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.social.model.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZzSocialSelectTagActivity
  extends BaseActivity
{
  List<String> a = new ArrayList();
  List<String> b = new ArrayList();
  private FlowLayout c;
  private TextView d;
  private ImageView e;
  private String f;
  private ZzSocialSelectTagActivity g;
  private List<y> r = new ArrayList();
  private List<y> s = new ArrayList();
  
  private void a()
  {
    this.e = ((ImageView)findViewById(2131690588));
    this.c = ((FlowLayout)findViewById(2131693067));
    this.d = ((TextView)findViewById(2131689956));
  }
  
  private void a(Button paramButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramButton.setBackgroundResource(2130840445);
      paramButton.setTextColor(38430);
      return;
    }
    paramButton.setBackgroundResource(2130840444);
    paramButton.setTextColor(-12303292);
  }
  
  private void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        Button localButton = new Button(this);
        localButton.setText((CharSequence)localObject);
        localButton.setTag(Boolean.valueOf(false));
        localButton.setTextColor(-12303292);
        localButton.setTextSize(14.0F);
        localButton.setPadding(com.ziroom.ziroomcustomer.util.n.dip2px(this.g, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.g, 5.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.g, 8.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.g, 5.0F));
        localButton.setBackgroundResource(2130840444);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, com.ziroom.ziroomcustomer.util.n.dip2px(this.g, 12.0F), com.ziroom.ziroomcustomer.util.n.dip2px(this.g, 12.0F));
        localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = (Button)paramAnonymousView;
            String str = paramAnonymousView.getText().toString();
            if (ZzSocialSelectTagActivity.this.a.size() > 0)
            {
              int i = 0;
              int j = 0;
              while (i < ZzSocialSelectTagActivity.this.a.size())
              {
                if (str.equals(ZzSocialSelectTagActivity.this.a.get(i))) {
                  j = 1;
                }
                i += 1;
              }
              if (j != 0)
              {
                ZzSocialSelectTagActivity.this.a.remove(str);
                ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this, paramAnonymousView, false);
                return;
              }
              ZzSocialSelectTagActivity.this.a.add(str);
              ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this, paramAnonymousView, true);
              return;
            }
            ZzSocialSelectTagActivity.this.a.add(str);
            ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this, paramAnonymousView, true);
          }
        });
        this.c.addView(localButton);
      }
    }
  }
  
  private void b()
  {
    String str = getIntent().getStringExtra("selectTagList");
    if (!TextUtils.isEmpty(str)) {
      this.b = com.alibaba.fastjson.e.parseArray(str, String.class);
    }
    int i = getIntent().getIntExtra("gender", 0);
    str = "";
    if (i == 1) {
      str = "男";
    }
    for (;;)
    {
      com.ziroom.ziroomcustomer.e.n.getPersonInfoTag(this, str, i, new d(this, new com.ziroom.ziroomcustomer.e.c.e(y.class))
      {
        public void onSuccess(int paramAnonymousInt, List<y> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
          {
            ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this).clear();
            ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this).addAll(paramAnonymousList);
            ArrayList localArrayList = new ArrayList();
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousList.size())
            {
              localArrayList.add(((y)paramAnonymousList.get(paramAnonymousInt)).getName());
              paramAnonymousInt += 1;
            }
            ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this, localArrayList);
            ZzSocialSelectTagActivity.b(ZzSocialSelectTagActivity.this);
          }
        }
      });
      return;
      if (i == 2) {
        str = "女";
      }
    }
  }
  
  private void e()
  {
    if ((this.b == null) || (this.b.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.c.getChildCount())
      {
        Button localButton = (Button)this.c.getChildAt(i);
        int j = 0;
        while (j < this.b.size())
        {
          if (((String)this.b.get(j)).equals(localButton.getText()))
          {
            this.a.add(this.b.get(j));
            localButton.setBackgroundResource(2130840445);
            localButton.setTextColor(38430);
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private void f()
  {
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZzSocialSelectTagActivity.this.finish();
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (ZzSocialSelectTagActivity.this.a.size() == 0)
        {
          g.textToast(ZzSocialSelectTagActivity.c(ZzSocialSelectTagActivity.this), "请先选择标签");
          return;
        }
        int i = 0;
        while (i < ZzSocialSelectTagActivity.this.a.size())
        {
          int j = 0;
          while (j < ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this).size())
          {
            if (((String)ZzSocialSelectTagActivity.this.a.get(i)).equals(((y)ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this).get(j)).getName())) {
              ZzSocialSelectTagActivity.d(ZzSocialSelectTagActivity.this).add(ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this).get(j));
            }
            j += 1;
          }
          i += 1;
        }
        i = 0;
        if (i < ZzSocialSelectTagActivity.d(ZzSocialSelectTagActivity.this).size())
        {
          if (TextUtils.isEmpty(ZzSocialSelectTagActivity.e(ZzSocialSelectTagActivity.this))) {
            ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this, ((y)ZzSocialSelectTagActivity.d(ZzSocialSelectTagActivity.this).get(0)).getId() + "");
          }
          for (;;)
          {
            i += 1;
            break;
            if (i > 0) {
              ZzSocialSelectTagActivity.a(ZzSocialSelectTagActivity.this, ZzSocialSelectTagActivity.e(ZzSocialSelectTagActivity.this) + "," + ((y)ZzSocialSelectTagActivity.d(ZzSocialSelectTagActivity.this).get(i)).getId());
            }
          }
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("tags", ZzSocialSelectTagActivity.e(ZzSocialSelectTagActivity.this));
        paramAnonymousView.putExtra("tagList", com.alibaba.fastjson.a.toJSONString(ZzSocialSelectTagActivity.this.a));
        ZzSocialSelectTagActivity.this.setResult(-1, paramAnonymousView);
        ZzSocialSelectTagActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903634);
    this.g = this;
    a();
    b();
    f();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialSelectTagActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */