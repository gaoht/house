package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignBillItem;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignBillItemTime;
import java.util.List;

public class ZryuSignBillsItemActivity
  extends BaseActivity
{
  private String a;
  private int b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private ListViewForScrollView s;
  private TextView t;
  private LayoutInflater u;
  private c v = new c(this, new f(ZryuSignBillItem.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignBillItem paramAnonymousZryuSignBillItem)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignBillItem);
      if (paramAnonymousZryuSignBillItem != null)
      {
        ZryuSignBillsItemActivity.a(ZryuSignBillsItemActivity.this).setText(paramAnonymousZryuSignBillItem.getContractCode());
        ZryuSignBillsItemActivity.b(ZryuSignBillsItemActivity.this).setText(paramAnonymousZryuSignBillItem.getPeriod());
        ZryuSignBillsItemActivity.c(ZryuSignBillsItemActivity.this).setText(paramAnonymousZryuSignBillItem.getProjectAddress());
        ZryuSignBillsItemActivity.d(ZryuSignBillsItemActivity.this).setText(paramAnonymousZryuSignBillItem.getReceivableAmount());
        ZryuSignBillsItemActivity.e(ZryuSignBillsItemActivity.this).setText(paramAnonymousZryuSignBillItem.getReceivedAmount());
        if (ZryuSignBillsItemActivity.f(ZryuSignBillsItemActivity.this) != null) {
          ZryuSignBillsItemActivity.f(ZryuSignBillsItemActivity.this).setText(paramAnonymousZryuSignBillItem.getReceivedNum());
        }
        if ((paramAnonymousZryuSignBillItem.getList() == null) || (paramAnonymousZryuSignBillItem.getList().size() <= 0)) {
          break label205;
        }
        ZryuSignBillsItemActivity.g(ZryuSignBillsItemActivity.this).setVisibility(0);
        ZryuSignBillsItemActivity.g(ZryuSignBillsItemActivity.this).setAdapter(new ZryuSignBillsItemActivity.a(ZryuSignBillsItemActivity.this, paramAnonymousZryuSignBillItem.getList()));
        ZryuSignBillsItemActivity.g(ZryuSignBillsItemActivity.this).addHeaderView(ZryuSignBillsItemActivity.h(ZryuSignBillsItemActivity.this).inflate(2130904631, null));
      }
      while (TextUtils.isEmpty(paramAnonymousZryuSignBillItem.getTips()))
      {
        ZryuSignBillsItemActivity.i(ZryuSignBillsItemActivity.this).setVisibility(8);
        return;
        label205:
        ZryuSignBillsItemActivity.g(ZryuSignBillsItemActivity.this).setVisibility(8);
      }
      ZryuSignBillsItemActivity.i(ZryuSignBillsItemActivity.this).setVisibility(0);
      ZryuSignBillsItemActivity.i(ZryuSignBillsItemActivity.this).setText(paramAnonymousZryuSignBillItem.getTips());
    }
  };
  
  private void a()
  {
    this.c = ((TextView)findViewById(2131692992));
    this.d = ((TextView)findViewById(2131692993));
    this.e = ((TextView)findViewById(2131692994));
    this.f = ((TextView)findViewById(2131692995));
    this.g = ((TextView)findViewById(2131692996));
    this.r = ((TextView)findViewById(2131692997));
    this.s = ((ListViewForScrollView)findViewById(2131690077));
    this.t = ((TextView)findViewById(2131689835));
    this.u = LayoutInflater.from(this);
  }
  
  private void b()
  {
    this.a = getIntent().getStringExtra("contractId");
    this.b = getIntent().getIntExtra("period", -1);
    e();
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.a)) && (this.b != -1)) {
      j.zryuPaymentDetail(this, this.a, this.b, this.v);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903604);
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
    private List<ZryuSignBillItemTime> b;
    
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
      if (paramView == null)
      {
        paramView = ZryuSignBillsItemActivity.h(ZryuSignBillsItemActivity.this).inflate(2130904630, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131695898));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131694684));
        paramViewGroup.c = ((TextView)paramView.findViewById(2131695899));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131695900));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        ZryuSignBillItemTime localZryuSignBillItemTime = (ZryuSignBillItemTime)getItem(paramInt);
        if (localZryuSignBillItemTime != null)
        {
          paramViewGroup.a.setText(localZryuSignBillItemTime.getPayNum());
          paramViewGroup.b.setText(localZryuSignBillItemTime.getPayAmount());
          paramViewGroup.c.setText(localZryuSignBillItemTime.getPayDate());
          paramViewGroup.d.setText(localZryuSignBillItemTime.getPayStatus());
        }
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      
      private a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignBillsItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */