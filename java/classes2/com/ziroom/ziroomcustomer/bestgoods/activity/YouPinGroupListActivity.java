package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.aa;
import com.ziroom.ziroomcustomer.bestgoods.a.ah;
import com.ziroom.ziroomcustomer.bestgoods.a.ah.b;
import com.ziroom.ziroomcustomer.bestgoods.dialog.d;
import com.ziroom.ziroomcustomer.bestgoods.model.ay;
import com.ziroom.ziroomcustomer.bestgoods.model.u.a;
import com.ziroom.ziroomcustomer.bestgoods.model.u.a.a;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import java.util.ArrayList;
import java.util.List;

public class YouPinGroupListActivity
  extends BaseActivity
{
  private ListView a;
  private ImageView b;
  private YouPinGroupListActivity c;
  private List<aa> d = new ArrayList();
  private String e;
  private String f;
  private List<ay> g = new ArrayList();
  private String r;
  
  private void a()
  {
    this.a = ((ListView)findViewById(2131692742));
    this.b = ((ImageView)findViewById(2131689492));
  }
  
  private void b()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        YouPinGroupListActivity.this.finish();
      }
    });
    this.e = getIntent().getStringExtra("groupCode");
    this.f = getIntent().getStringExtra("productCode");
    this.r = getIntent().getStringExtra("groupTitle");
    e();
  }
  
  private void e()
  {
    n.requestYouPinGroupList(this.c, "", this.f, new com.ziroom.ziroomcustomer.e.a.a(this.c, new m(com.ziroom.ziroomcustomer.bestgoods.model.u.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.bestgoods.model.u paramAnonymousu)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousu);
        com.ziroom.ziroomcustomer.util.u.d("sdfsdfdsfdsjgk", "=====  " + com.alibaba.fastjson.a.toJSONString(paramAnonymousu));
        if (paramAnonymousu != null)
        {
          YouPinGroupListActivity.a(YouPinGroupListActivity.this).clear();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousu.getList().size())
          {
            int i = 0;
            while (i < ((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().size())
            {
              ay localay = new ay();
              localay.setPicUrl(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getSkuImg());
              localay.setTitle(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getSkuName());
              localay.setPrice(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getPrice());
              localay.setAmount(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getAmount());
              YouPinGroupListActivity.a(YouPinGroupListActivity.this).add(localay);
              i += 1;
            }
            YouPinGroupListActivity.c(YouPinGroupListActivity.this).add(new aa(YouPinGroupListActivity.b(YouPinGroupListActivity.this), YouPinGroupListActivity.a(YouPinGroupListActivity.this)));
            paramAnonymousInt += 1;
          }
          paramAnonymousu = new ah(YouPinGroupListActivity.b(YouPinGroupListActivity.this), YouPinGroupListActivity.c(YouPinGroupListActivity.this), paramAnonymousu.getList());
          YouPinGroupListActivity.d(YouPinGroupListActivity.this).setAdapter(paramAnonymousu);
          paramAnonymousu.setOnItemClickListener(new ah.b()
          {
            public void toGroupPay(int paramAnonymous2Int)
            {
              new d(YouPinGroupListActivity.b(YouPinGroupListActivity.this), YouPinGroupListActivity.e(YouPinGroupListActivity.this), YouPinGroupListActivity.f(YouPinGroupListActivity.this)).show();
            }
          });
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903565);
    this.c = this;
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinGroupListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */