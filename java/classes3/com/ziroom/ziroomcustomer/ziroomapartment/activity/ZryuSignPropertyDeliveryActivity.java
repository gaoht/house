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
import android.widget.ListAdapter;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignDelivery;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignDeliveryItem;
import java.util.List;

public class ZryuSignPropertyDeliveryActivity
  extends BaseActivity
{
  private LayoutInflater a;
  private ImageView b;
  private ListViewForScrollView c;
  private TextView d;
  private Button e;
  private String f;
  private Integer g;
  private c r = new c(this, new f(ZryuSignDelivery.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignDelivery paramAnonymousZryuSignDelivery)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignDelivery);
      if (paramAnonymousZryuSignDelivery != null)
      {
        ZryuSignPropertyDeliveryActivity.a(ZryuSignPropertyDeliveryActivity.this, paramAnonymousZryuSignDelivery.getHasSharer());
        Object localObject = paramAnonymousZryuSignDelivery.getList();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = new ZryuSignPropertyDeliveryActivity.a(ZryuSignPropertyDeliveryActivity.this, (List)localObject);
          ZryuSignPropertyDeliveryActivity.a(ZryuSignPropertyDeliveryActivity.this).setAdapter((ListAdapter)localObject);
        }
        if (!TextUtils.isEmpty(paramAnonymousZryuSignDelivery.getTipMsg())) {
          break label116;
        }
        ZryuSignPropertyDeliveryActivity.b(ZryuSignPropertyDeliveryActivity.this).setVisibility(8);
      }
      while ((paramAnonymousZryuSignDelivery.getIsPay() != null) && (paramAnonymousZryuSignDelivery.getIsPay().intValue() == 1))
      {
        ZryuSignPropertyDeliveryActivity.c(ZryuSignPropertyDeliveryActivity.this).setEnabled(true);
        return;
        label116:
        ZryuSignPropertyDeliveryActivity.b(ZryuSignPropertyDeliveryActivity.this).setVisibility(0);
        ZryuSignPropertyDeliveryActivity.b(ZryuSignPropertyDeliveryActivity.this).setText(paramAnonymousZryuSignDelivery.getTipMsg());
      }
      ZryuSignPropertyDeliveryActivity.c(ZryuSignPropertyDeliveryActivity.this).setEnabled(false);
    }
  };
  private c s = new c(this, new f(String.class))
  {
    public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousString);
      ZryuSignPropertyDeliveryActivity.this.finish();
    }
  };
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ListViewForScrollView)findViewById(2131690077));
    this.d = ((TextView)findViewById(2131690073));
    this.e = ((Button)findViewById(2131690043));
    this.a = LayoutInflater.from(this);
  }
  
  private void b()
  {
    this.f = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.f)) {
      j.zryuItemDeliveryPanle(this, this.f, this.r);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903618);
    a();
    b();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!TextUtils.isEmpty(this.f)) {
      j.zryuItemDeliveryPanle(this, this.f, this.r);
    }
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    }
    j.zryuItemDeliveryConfirmDelivery(this, this.f, this.s);
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ZryuSignDeliveryItem> b;
    
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
      ZryuSignDeliveryItem localZryuSignDeliveryItem;
      if (paramView == null)
      {
        paramView = ZryuSignPropertyDeliveryActivity.d(ZryuSignPropertyDeliveryActivity.this).inflate(2130904638, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131690073));
        paramView.setTag(paramViewGroup);
        localZryuSignDeliveryItem = (ZryuSignDeliveryItem)getItem(paramInt);
        if (localZryuSignDeliveryItem != null)
        {
          paramViewGroup.a.setText(localZryuSignDeliveryItem.getName());
          paramViewGroup.b.setText(localZryuSignDeliveryItem.getDesc());
          if (localZryuSignDeliveryItem.getCode() != null)
          {
            if (localZryuSignDeliveryItem.getCode().intValue() != 1) {
              break label167;
            }
            paramView.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                paramAnonymousView = new Intent(ZryuSignPropertyDeliveryActivity.this, ZryuSignConfigureActivity.class);
                paramAnonymousView.putExtra("contractId", ZryuSignPropertyDeliveryActivity.e(ZryuSignPropertyDeliveryActivity.this));
                ZryuSignPropertyDeliveryActivity.this.startActivity(paramAnonymousView);
              }
            });
          }
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localZryuSignDeliveryItem.getColor())) {
          break label229;
        }
        paramViewGroup.b.setTextColor(Color.parseColor("#999999"));
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label167:
        if (localZryuSignDeliveryItem.getCode().intValue() == 2) {
          paramView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = new Intent(ZryuSignPropertyDeliveryActivity.this, ZryuSignLivingExpensesActivity.class);
              paramAnonymousView.putExtra("contractId", ZryuSignPropertyDeliveryActivity.e(ZryuSignPropertyDeliveryActivity.this));
              ZryuSignPropertyDeliveryActivity.this.startActivity(paramAnonymousView);
            }
          });
        } else if (localZryuSignDeliveryItem.getCode().intValue() == 3) {
          paramView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if ((ZryuSignPropertyDeliveryActivity.f(ZryuSignPropertyDeliveryActivity.this) != null) && (ZryuSignPropertyDeliveryActivity.f(ZryuSignPropertyDeliveryActivity.this).intValue() == 0))
              {
                paramAnonymousView = new Intent(ZryuSignPropertyDeliveryActivity.this, ZryuSignAddCotenantActivity.class);
                paramAnonymousView.putExtra("contractId", ZryuSignPropertyDeliveryActivity.e(ZryuSignPropertyDeliveryActivity.this));
                ZryuSignPropertyDeliveryActivity.this.startActivity(paramAnonymousView);
                return;
              }
              paramAnonymousView = new Intent(ZryuSignPropertyDeliveryActivity.this, ZryuSignCotenantActivity.class);
              paramAnonymousView.putExtra("contractId", ZryuSignPropertyDeliveryActivity.e(ZryuSignPropertyDeliveryActivity.this));
              ZryuSignPropertyDeliveryActivity.this.startActivity(paramAnonymousView);
            }
          });
        } else {
          paramView.setOnClickListener(null);
        }
      }
      label229:
      paramViewGroup.b.setTextColor(Color.parseColor(localZryuSignDeliveryItem.getColor()));
      return paramView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignPropertyDeliveryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */