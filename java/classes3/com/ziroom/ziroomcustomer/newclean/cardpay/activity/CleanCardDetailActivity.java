package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.c;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCardFollowInfo;
import com.ziroom.ziroomcustomer.newclean.d.w;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CleanCardDetailActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private Context a;
  private ImageView b;
  private TextView c;
  private XListView d;
  private boolean e;
  private List<w> f = new ArrayList();
  private List<w> g = new ArrayList();
  private c r;
  private int s = 1;
  private UserInfo t;
  private RelativeLayout u;
  private int v = -1;
  
  private void a()
  {
    this.r = new c(this.a, this.f);
    this.d.setAdapter(this.r);
    if (this.t != null) {
      n.getCleanCardFollowInfo(this.a, this.t.getUid(), 1, 10, new a(), false);
    }
  }
  
  private void b()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131690239));
    this.d = ((XListView)findViewById(2131690240));
    this.u = ((RelativeLayout)findViewById(2131690202));
    this.d.setPullLoadEnable(false);
    this.d.setPullRefreshEnable(true);
    this.d.setXListViewListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.t = ApplicationEx.c.getUser();
  }
  
  private void e()
  {
    this.d.stopRefresh();
    this.d.stopLoadMore();
    this.d.setRefreshTime("刚刚");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    this.e = ApplicationEx.c.isLoginState();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    startActivity(new Intent(this, ChatWebViewActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = this;
    setContentView(2130903139);
    b();
    a();
  }
  
  public void onLoadMore()
  {
    if (this.t != null)
    {
      Context localContext = this.a;
      String str = this.t.getUid();
      int i = this.s + 1;
      this.s = i;
      n.getCleanCardFollowInfo(localContext, str, i, 10, new a(), false);
    }
  }
  
  public void onRefresh()
  {
    this.s = 1;
    this.f.clear();
    if (this.t != null)
    {
      if (this.v != -1) {}
      n.getCleanCardFollowInfo(this.a, this.t.getUid(), 1, 10, new a(), false);
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      u.e("dsgdsgh:", com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      paramString = a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject((CleanCardFollowInfo)a.parseObject(paramString.get("data").toString(), CleanCardFollowInfo.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (CleanCardFollowInfo)paramk.getObject();
        CleanCardDetailActivity.a(CleanCardDetailActivity.this, paramk.getRows());
        CleanCardDetailActivity.a(CleanCardDetailActivity.this, paramk.getTotal());
        if (CleanCardDetailActivity.a(CleanCardDetailActivity.this).size() == 0)
        {
          CleanCardDetailActivity.a(CleanCardDetailActivity.this).addAll(CleanCardDetailActivity.b(CleanCardDetailActivity.this));
          CleanCardDetailActivity.c(CleanCardDetailActivity.this).setPullLoadEnable(true);
          CleanCardDetailActivity.d(CleanCardDetailActivity.this);
          CleanCardDetailActivity.e(CleanCardDetailActivity.this).notifyDataSetChanged();
          if (CleanCardDetailActivity.f(CleanCardDetailActivity.this) != 0) {
            break label265;
          }
          CleanCardDetailActivity.g(CleanCardDetailActivity.this).setVisibility(0);
        }
      }
      label129:
      label265:
      do
      {
        do
        {
          return;
          int i = 0;
          int j;
          if (i < CleanCardDetailActivity.b(CleanCardDetailActivity.this).size()) {
            j = CleanCardDetailActivity.a(CleanCardDetailActivity.this).size() - 1;
          }
          for (;;)
          {
            if ((j < 0) || (((w)CleanCardDetailActivity.a(CleanCardDetailActivity.this).get(j)).getCreateTime().equals(((w)CleanCardDetailActivity.b(CleanCardDetailActivity.this).get(i)).getCreateTime())))
            {
              i += 1;
              break label129;
              break;
            }
            if (j == 0)
            {
              paramk = (w)a.parseObject(a.toJSONString(CleanCardDetailActivity.b(CleanCardDetailActivity.this).get(i)), w.class);
              CleanCardDetailActivity.a(CleanCardDetailActivity.this).add(paramk);
            }
            j -= 1;
          }
        } while (CleanCardDetailActivity.f(CleanCardDetailActivity.this) <= 0);
        CleanCardDetailActivity.g(CleanCardDetailActivity.this).setVisibility(8);
        return;
        CleanCardDetailActivity.g(CleanCardDetailActivity.this).setVisibility(0);
      } while (TextUtils.isEmpty(paramk.getMessage()));
      g.textToast(CleanCardDetailActivity.h(CleanCardDetailActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanCardDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */