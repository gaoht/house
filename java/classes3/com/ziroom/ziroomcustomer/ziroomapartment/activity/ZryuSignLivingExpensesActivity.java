package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.b;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignDeliveryLifeFeeItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignDeliveryLifeFeeItems;
import java.text.DecimalFormat;
import java.util.List;

public class ZryuSignLivingExpensesActivity
  extends BaseActivity
{
  private LayoutInflater a;
  private ImageView b;
  private ListViewForScrollView c;
  private Button d;
  private String e;
  private Integer f;
  private Integer g;
  private DecimalFormat r;
  private int s;
  private int t;
  private int u;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ListViewForScrollView)findViewById(2131690077));
    this.d = ((Button)findViewById(2131690043));
    this.a = LayoutInflater.from(this);
    this.s = Color.parseColor("#444444");
    this.t = Color.parseColor("#666666");
    this.u = Color.parseColor("#999999");
  }
  
  private void b()
  {
    this.e = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.e)) {
      j.zryuItemDeliveryLifeFeeItems(this, this.e, new c(this, new f(ZryuSignDeliveryLifeFeeItems.class))
      {
        public void onSuccess(int paramAnonymousInt, ZryuSignDeliveryLifeFeeItems paramAnonymousZryuSignDeliveryLifeFeeItems)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignDeliveryLifeFeeItems);
          ZryuSignLivingExpensesActivity.a(ZryuSignLivingExpensesActivity.this, paramAnonymousZryuSignDeliveryLifeFeeItems.getPayMoney());
          if ((ZryuSignLivingExpensesActivity.a(ZryuSignLivingExpensesActivity.this) != null) && (ZryuSignLivingExpensesActivity.a(ZryuSignLivingExpensesActivity.this).intValue() > 0)) {
            ZryuSignLivingExpensesActivity.c(ZryuSignLivingExpensesActivity.this).setText("支付¥" + ZryuSignLivingExpensesActivity.b(ZryuSignLivingExpensesActivity.this).format(ZryuSignLivingExpensesActivity.a(ZryuSignLivingExpensesActivity.this).intValue() / 100.0F));
          }
          if (paramAnonymousZryuSignDeliveryLifeFeeItems.getIsPay() != null)
          {
            ZryuSignLivingExpensesActivity.b(ZryuSignLivingExpensesActivity.this, paramAnonymousZryuSignDeliveryLifeFeeItems.getIsPay());
            if (ZryuSignLivingExpensesActivity.d(ZryuSignLivingExpensesActivity.this).intValue() != 0) {
              break label178;
            }
            ZryuSignLivingExpensesActivity.c(ZryuSignLivingExpensesActivity.this).setVisibility(0);
          }
          for (;;)
          {
            ZryuSignLivingExpensesActivity.e(ZryuSignLivingExpensesActivity.this).setAdapter(new ZryuSignLivingExpensesActivity.a(ZryuSignLivingExpensesActivity.this, paramAnonymousZryuSignDeliveryLifeFeeItems.getFeeList()));
            return;
            ZryuSignLivingExpensesActivity.b(ZryuSignLivingExpensesActivity.this, Integer.valueOf(0));
            break;
            label178:
            ZryuSignLivingExpensesActivity.c(ZryuSignLivingExpensesActivity.this).setVisibility(8);
          }
        }
      });
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903614);
    this.r = new DecimalFormat("0.00");
    a();
    b();
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
    } while (this.f == null);
    b.toBillsInfo(this, this.e, "", "1001", "0");
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ZryuSignDeliveryLifeFeeItem> b;
    
    public a()
    {
      List localList;
      this.b = localList;
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final ZryuSignDeliveryLifeFeeItem localZryuSignDeliveryLifeFeeItem;
      if (paramView == null)
      {
        paramView = ZryuSignLivingExpensesActivity.f(ZryuSignLivingExpensesActivity.this).inflate(2130904640, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131691546));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131689840));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131695189));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131695905));
        paramViewGroup.f = ((TextView)paramView.findViewById(2131695904));
        paramView.setTag(paramViewGroup);
        localZryuSignDeliveryLifeFeeItem = (ZryuSignDeliveryLifeFeeItem)getItem(paramInt);
        paramViewGroup.a.setText(localZryuSignDeliveryLifeFeeItem.getName());
        paramViewGroup.b.setText(localZryuSignDeliveryLifeFeeItem.getValue());
        if (!TextUtils.isEmpty(localZryuSignDeliveryLifeFeeItem.getUnit())) {
          break label275;
        }
        paramViewGroup.c.setVisibility(8);
        label166:
        if (!TextUtils.isEmpty(localZryuSignDeliveryLifeFeeItem.getNumber())) {
          break label298;
        }
        paramViewGroup.d.setVisibility(8);
        label186:
        if (!TextUtils.isEmpty(localZryuSignDeliveryLifeFeeItem.getPicUrl())) {
          break label321;
        }
        paramViewGroup.e.setVisibility(8);
      }
      for (;;)
      {
        if ((localZryuSignDeliveryLifeFeeItem.getIsPay() == null) || (localZryuSignDeliveryLifeFeeItem.getIsPay().intValue() != 1)) {
          break label349;
        }
        paramViewGroup.a.setTextColor(ZryuSignLivingExpensesActivity.g(ZryuSignLivingExpensesActivity.this));
        paramViewGroup.b.setTextColor(ZryuSignLivingExpensesActivity.g(ZryuSignLivingExpensesActivity.this));
        paramViewGroup.f.setVisibility(0);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label275:
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(localZryuSignDeliveryLifeFeeItem.getUnit());
        break label166;
        label298:
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(localZryuSignDeliveryLifeFeeItem.getNumber());
        break label186;
        label321:
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (!TextUtils.isEmpty(localZryuSignDeliveryLifeFeeItem.getPicUrl()))
            {
              paramAnonymousView = new Intent(ZryuSignLivingExpensesActivity.this, ZryuSignImgActivity.class);
              paramAnonymousView.putExtra("imgUrl", localZryuSignDeliveryLifeFeeItem.getPicUrl());
              ZryuSignLivingExpensesActivity.this.startActivity(paramAnonymousView);
            }
          }
        });
      }
      label349:
      paramViewGroup.a.setTextColor(ZryuSignLivingExpensesActivity.h(ZryuSignLivingExpensesActivity.this));
      paramViewGroup.b.setTextColor(ZryuSignLivingExpensesActivity.i(ZryuSignLivingExpensesActivity.this));
      paramViewGroup.f.setVisibility(8);
      return paramView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      TextView f;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignLivingExpensesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */