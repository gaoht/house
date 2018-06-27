package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.a.ae;
import com.ziroom.ziroomcustomer.bestgoods.a.x;
import com.ziroom.ziroomcustomer.bestgoods.model.YouPinCommitOrderGoodsInfoMo;
import java.util.ArrayList;
import java.util.List;

public class YouPinDeliveryModeActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private RelativeLayout a;
  private ImageView b;
  private LinearLayout c;
  private TextView d;
  private RecyclerView e;
  private LinearLayout f;
  private RecyclerView g;
  private List<String> r = new ArrayList();
  private List<String> s = new ArrayList();
  private Context t;
  private View u;
  
  private void a()
  {
    this.t = this;
    this.a = ((RelativeLayout)findViewById(2131689808));
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((LinearLayout)findViewById(2131692709));
    this.d = ((TextView)findViewById(2131692710));
    this.e = ((RecyclerView)findViewById(2131692711));
    this.u = findViewById(2131692712);
    this.f = ((LinearLayout)findViewById(2131692713));
    this.g = ((RecyclerView)findViewById(2131692714));
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
  }
  
  private void e()
  {
    Object localObject = a.parseArray(getIntent().getStringExtra("goodsInfoString"), YouPinCommitOrderGoodsInfoMo.class);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i = 0;
      if (i < ((List)localObject).size())
      {
        if (((YouPinCommitOrderGoodsInfoMo)((List)localObject).get(i)).getDeliveryMode().intValue() == 1) {
          this.r.add(((YouPinCommitOrderGoodsInfoMo)((List)localObject).get(i)).getSkuUrl());
        }
        for (;;)
        {
          i += 1;
          break;
          this.s.add(((YouPinCommitOrderGoodsInfoMo)((List)localObject).get(i)).getSkuUrl());
        }
      }
    }
    localObject = new LinearLayoutManager(this.t);
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.e.setLayoutManager((RecyclerView.h)localObject);
    localObject = new LinearLayoutManager(this.t);
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.g.setLayoutManager((RecyclerView.h)localObject);
    if ((this.s == null) || (this.s.size() == 0))
    {
      this.f.setVisibility(8);
      this.u.setVisibility(8);
      if ((this.r != null) && (this.r.size() != 0)) {
        break label299;
      }
      this.c.setVisibility(8);
    }
    for (;;)
    {
      localObject = new x(this.t, this.r);
      ae localae = new ae(this.t, this.s);
      this.e.setAdapter((RecyclerView.a)localObject);
      this.g.setAdapter(localae);
      return;
      this.f.setVisibility(0);
      this.u.setVisibility(0);
      break;
      label299:
      this.c.setVisibility(0);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903553);
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinDeliveryModeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */