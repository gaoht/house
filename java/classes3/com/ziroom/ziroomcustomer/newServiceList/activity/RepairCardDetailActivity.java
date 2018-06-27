package com.ziroom.ziroomcustomer.newServiceList.activity;

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
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ChatWebViewActivity;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.c;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCardFollowInfo;
import com.ziroom.ziroomcustomer.newclean.d.w;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairCardDetailActivity
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
  private int t = 10;
  private UserInfo u;
  private RelativeLayout v;
  private int w = -1;
  
  private void a()
  {
    this.r = new c(this.a, this.f);
    this.d.setAdapter(this.r);
    e();
  }
  
  private void b()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131690239));
    this.d = ((XListView)findViewById(2131690240));
    this.v = ((RelativeLayout)findViewById(2131690202));
    this.d.setPullLoadEnable(false);
    this.d.setPullRefreshEnable(true);
    this.d.setXListViewListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.u = ApplicationEx.c.getUser();
  }
  
  private void e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pageSize", Integer.valueOf(this.t));
    localHashMap.put("pageNum", Integer.valueOf(this.s));
    j.getRepairCardDetailInfo(this.a, localHashMap, new a());
  }
  
  private void f()
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
    this.s += 1;
    e();
  }
  
  public void onRefresh()
  {
    this.s = 1;
    this.f.clear();
    e();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
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
    
    public void onSuccess(k paramk)
    {
      int i = 0;
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (CleanCardFollowInfo)paramk.getObject();
        RepairCardDetailActivity.a(RepairCardDetailActivity.this, paramk.getRows());
        RepairCardDetailActivity.a(RepairCardDetailActivity.this, paramk.getTotal());
        if (RepairCardDetailActivity.a(RepairCardDetailActivity.this) > 0)
        {
          RepairCardDetailActivity.b(RepairCardDetailActivity.this).setVisibility(8);
          if ((RepairCardDetailActivity.c(RepairCardDetailActivity.this).size() != 0) || (RepairCardDetailActivity.d(RepairCardDetailActivity.this).size() <= 0)) {
            break label157;
          }
          RepairCardDetailActivity.c(RepairCardDetailActivity.this).addAll(RepairCardDetailActivity.d(RepairCardDetailActivity.this));
          RepairCardDetailActivity.g(RepairCardDetailActivity.this).setPullLoadEnable(true);
          RepairCardDetailActivity.h(RepairCardDetailActivity.this);
          RepairCardDetailActivity.i(RepairCardDetailActivity.this).notifyDataSetChanged();
        }
      }
      label157:
      label172:
      do
      {
        return;
        RepairCardDetailActivity.b(RepairCardDetailActivity.this).setVisibility(0);
        return;
        if (RepairCardDetailActivity.d(RepairCardDetailActivity.this).size() > 0)
        {
          int j;
          if (i < RepairCardDetailActivity.d(RepairCardDetailActivity.this).size()) {
            j = RepairCardDetailActivity.c(RepairCardDetailActivity.this).size() - 1;
          }
          for (;;)
          {
            if ((j < 0) || (((w)RepairCardDetailActivity.c(RepairCardDetailActivity.this).get(j)).getCreateTime().equals(((w)RepairCardDetailActivity.d(RepairCardDetailActivity.this).get(i)).getCreateTime())))
            {
              i += 1;
              break label172;
              break;
            }
            if (j == 0) {
              RepairCardDetailActivity.c(RepairCardDetailActivity.this).add(RepairCardDetailActivity.d(RepairCardDetailActivity.this).get(i));
            }
            j -= 1;
          }
        }
        if (RepairCardDetailActivity.e(RepairCardDetailActivity.this) <= 1) {
          break;
        }
        RepairCardDetailActivity.f(RepairCardDetailActivity.this);
        break;
        RepairCardDetailActivity.b(RepairCardDetailActivity.this).setVisibility(0);
      } while (TextUtils.isEmpty(paramk.getMessage()));
      g.textToast(RepairCardDetailActivity.j(RepairCardDetailActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairCardDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */