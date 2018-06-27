package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.a.aa;
import com.ziroom.ziroomcustomer.bestgoods.a.ac;
import com.ziroom.ziroomcustomer.bestgoods.a.ah;
import com.ziroom.ziroomcustomer.bestgoods.a.ah.b;
import com.ziroom.ziroomcustomer.bestgoods.dialog.d;
import com.ziroom.ziroomcustomer.bestgoods.model.ay;
import com.ziroom.ziroomcustomer.bestgoods.model.u;
import com.ziroom.ziroomcustomer.bestgoods.model.u.a;
import com.ziroom.ziroomcustomer.bestgoods.model.u.a.a;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import java.util.ArrayList;
import java.util.List;

public class YouPinGroupListActivity_New
  extends AppCompatActivity
{
  private ExpandableListView a;
  private ImageView b;
  private YouPinGroupListActivity_New c;
  private List<aa> d = new ArrayList();
  private String e;
  private String f;
  private List<ay> g = new ArrayList();
  private String h;
  
  private void a()
  {
    this.a = ((ExpandableListView)findViewById(2131692725));
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
        YouPinGroupListActivity_New.this.finish();
      }
    });
    this.e = getIntent().getStringExtra("groupCode");
    this.f = getIntent().getStringExtra("productCode");
    this.h = getIntent().getStringExtra("groupTitle");
    c();
  }
  
  private void c()
  {
    n.requestYouPinGroupList(this.c, "", this.f, new com.ziroom.ziroomcustomer.e.a.a(this.c, new m(u.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, u paramAnonymousu)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousu);
        if (paramAnonymousu != null)
        {
          Object localObject = paramAnonymousu.getList();
          localObject = new ac(YouPinGroupListActivity_New.a(YouPinGroupListActivity_New.this), (List)localObject);
          YouPinGroupListActivity_New.b(YouPinGroupListActivity_New.this).setAdapter((ExpandableListAdapter)localObject);
          YouPinGroupListActivity_New.b(YouPinGroupListActivity_New.this).setGroupIndicator(null);
          int i = YouPinGroupListActivity_New.b(YouPinGroupListActivity_New.this).getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            YouPinGroupListActivity_New.b(YouPinGroupListActivity_New.this).expandGroup(paramAnonymousInt);
            paramAnonymousInt += 1;
          }
          YouPinGroupListActivity_New.b(YouPinGroupListActivity_New.this).setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
          {
            @Instrumented
            public boolean onGroupClick(ExpandableListView paramAnonymous2ExpandableListView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              VdsAgent.onGroupClick(this, paramAnonymous2ExpandableListView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
              VdsAgent.handleClickResult(new Boolean(true));
              return true;
            }
          });
          YouPinGroupListActivity_New.c(YouPinGroupListActivity_New.this).clear();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < paramAnonymousu.getList().size())
          {
            i = 0;
            while (i < ((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().size())
            {
              localObject = new ay();
              ((ay)localObject).setPicUrl(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getSkuImg());
              ((ay)localObject).setTitle(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getSkuName());
              ((ay)localObject).setPrice(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getPrice());
              ((ay)localObject).setAmount(((u.a.a)((u.a)paramAnonymousu.getList().get(paramAnonymousInt)).getGroupDetail().get(i)).getAmount());
              YouPinGroupListActivity_New.c(YouPinGroupListActivity_New.this).add(localObject);
              i += 1;
            }
            YouPinGroupListActivity_New.d(YouPinGroupListActivity_New.this).add(new aa(YouPinGroupListActivity_New.a(YouPinGroupListActivity_New.this), YouPinGroupListActivity_New.c(YouPinGroupListActivity_New.this)));
            paramAnonymousInt += 1;
          }
          new ah(YouPinGroupListActivity_New.a(YouPinGroupListActivity_New.this), YouPinGroupListActivity_New.d(YouPinGroupListActivity_New.this), paramAnonymousu.getList()).setOnItemClickListener(new ah.b()
          {
            public void toGroupPay(int paramAnonymous2Int)
            {
              new d(YouPinGroupListActivity_New.a(YouPinGroupListActivity_New.this), YouPinGroupListActivity_New.e(YouPinGroupListActivity_New.this), YouPinGroupListActivity_New.f(YouPinGroupListActivity_New.this)).show();
            }
          });
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903555);
    this.c = this;
    a();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinGroupListActivity_New.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */