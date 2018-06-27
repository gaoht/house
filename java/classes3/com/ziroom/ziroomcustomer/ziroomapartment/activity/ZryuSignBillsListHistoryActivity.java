package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignBillListHistory;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignBillLiving;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignKvItem;
import java.util.Iterator;
import java.util.List;

public class ZryuSignBillsListHistoryActivity
  extends BaseActivity
{
  private String a;
  private ListView b;
  private LinearLayout c;
  private a d;
  private c e = new c(this, new f(ZryuSignBillListHistory.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, ZryuSignBillListHistory paramAnonymousZryuSignBillListHistory)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignBillListHistory);
      if ((paramAnonymousZryuSignBillListHistory != null) && (paramAnonymousZryuSignBillListHistory.getLiftList() != null))
      {
        ZryuSignBillsListHistoryActivity.a(ZryuSignBillsListHistoryActivity.this, new ZryuSignBillsListHistoryActivity.a(ZryuSignBillsListHistoryActivity.this, paramAnonymousZryuSignBillListHistory.getLiftList()));
        ZryuSignBillsListHistoryActivity.b(ZryuSignBillsListHistoryActivity.this).setAdapter(ZryuSignBillsListHistoryActivity.a(ZryuSignBillsListHistoryActivity.this));
      }
      ZryuSignBillsListHistoryActivity.b(ZryuSignBillsListHistoryActivity.this).setEmptyView(ZryuSignBillsListHistoryActivity.c(ZryuSignBillsListHistoryActivity.this));
    }
  };
  
  private void a()
  {
    this.b = ((ListView)findViewById(2131689817));
    this.c = ((LinearLayout)findViewById(2131689818));
  }
  
  private void b()
  {
    this.a = getIntent().getStringExtra("contractId");
    if (!TextUtils.isEmpty(this.a)) {
      j.zryuPaymentItemsHistory(this, this.a, this.e);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903606);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  private class a
    extends BaseAdapter
  {
    private List<ZryuSignBillLiving> b;
    private LayoutInflater c;
    private int d;
    private int e;
    
    public a()
    {
      List localList;
      this.b = localList;
      this.c = LayoutInflater.from(ZryuSignBillsListHistoryActivity.this);
      this.d = ((int)(ZryuSignBillsListHistoryActivity.this.getResources().getDisplayMetrics().density * 12.0F));
      this.e = Color.parseColor("#999999");
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
      if (paramView == null)
      {
        paramView = this.c.inflate(2130904633, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((CheckBox)paramView.findViewById(2131692109));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
        paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131689775));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131691107));
        paramView.setTag(paramViewGroup);
      }
      ZryuSignBillLiving localZryuSignBillLiving;
      for (;;)
      {
        localZryuSignBillLiving = (ZryuSignBillLiving)getItem(paramInt);
        paramViewGroup.b.setText(localZryuSignBillLiving.getName());
        paramViewGroup.c.removeAllViews();
        if ((localZryuSignBillLiving.getList() == null) || (localZryuSignBillLiving.getList().size() <= 0)) {
          break;
        }
        paramViewGroup.c.setVisibility(0);
        Iterator localIterator = localZryuSignBillLiving.getList().iterator();
        while (localIterator.hasNext())
        {
          ZryuSignKvItem localZryuSignKvItem = (ZryuSignKvItem)localIterator.next();
          TextView localTextView = new TextView(ZryuSignBillsListHistoryActivity.this);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.setMargins(0, 0, 0, this.d);
          localTextView.setLayoutParams(localLayoutParams);
          localTextView.setLines(1);
          localTextView.setTextSize(2, 12.0F);
          localTextView.setTextColor(this.e);
          localTextView.setText(localZryuSignKvItem.getName() + "：" + localZryuSignKvItem.getValue());
          paramViewGroup.c.addView(localTextView);
        }
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.d.setText(localZryuSignBillLiving.getValue());
      return paramView;
    }
    
    private class a
    {
      CheckBox a;
      TextView b;
      LinearLayout c;
      TextView d;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignBillsListHistoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */