package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.q;
import com.ziroom.ziroomcustomer.bestgoods.model.af;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ExpandableListViewForScrollView;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;

public class YouPinBackChangeGoodsInfoActivity
  extends BaseActivity
{
  private Context a;
  private ImageView b;
  private ObservableScrollView c;
  private TextView d;
  private ExpandableListViewForScrollView e;
  private View f;
  
  private void a()
  {
    this.a = this;
    this.b = ((ImageView)findViewById(2131689492));
    this.f = findViewById(2131689863);
    this.c = ((ObservableScrollView)findViewById(2131689506));
    this.d = ((TextView)findViewById(2131689541));
    this.e = ((ExpandableListViewForScrollView)findViewById(2131692667));
    this.e.setGroupIndicator(null);
  }
  
  private void b()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        YouPinBackChangeGoodsInfoActivity.this.finish();
      }
    });
    this.c.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        YouPinBackChangeGoodsInfoActivity.a(YouPinBackChangeGoodsInfoActivity.this).setAlpha(f);
      }
    });
  }
  
  private void e()
  {
    n.getYouBackChangeGoodsInfo(this.a, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(af.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, af paramAnonymousaf)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousaf);
        u.d("===", "======" + com.alibaba.fastjson.a.toJSONString(paramAnonymousaf));
        if (paramAnonymousaf != null)
        {
          paramAnonymousaf = paramAnonymousaf.getList();
          paramAnonymousaf = new q(YouPinBackChangeGoodsInfoActivity.b(YouPinBackChangeGoodsInfoActivity.this), paramAnonymousaf);
          YouPinBackChangeGoodsInfoActivity.c(YouPinBackChangeGoodsInfoActivity.this).setAdapter(paramAnonymousaf);
          int i = YouPinBackChangeGoodsInfoActivity.c(YouPinBackChangeGoodsInfoActivity.this).getCount();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < i)
          {
            YouPinBackChangeGoodsInfoActivity.c(YouPinBackChangeGoodsInfoActivity.this).expandGroup(paramAnonymousInt);
            paramAnonymousInt += 1;
          }
          YouPinBackChangeGoodsInfoActivity.c(YouPinBackChangeGoodsInfoActivity.this).setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
          {
            @Instrumented
            public boolean onGroupClick(ExpandableListView paramAnonymous2ExpandableListView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              VdsAgent.onGroupClick(this, paramAnonymous2ExpandableListView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
              VdsAgent.handleClickResult(new Boolean(true));
              return true;
            }
          });
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903549);
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinBackChangeGoodsInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */