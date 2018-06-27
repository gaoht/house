package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sd.FeeBillDetail;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignKvItem;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ZryuSdWaterBillsListActivity
  extends BaseActivity
{
  private String a;
  private ListView b;
  private LinearLayout c;
  private a d;
  private FeeBillDetail e;
  private b f;
  private c g = new c(this, new e(FeeBillDetail.class))
  {
    public void onFailure(Throwable paramAnonymousThrowable)
    {
      super.onFailure(paramAnonymousThrowable);
    }
    
    public void onSuccess(int paramAnonymousInt, List<FeeBillDetail> paramAnonymousList)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousList);
      if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
      {
        ZryuSdWaterBillsListActivity.a(ZryuSdWaterBillsListActivity.this, new ZryuSdWaterBillsListActivity.a(ZryuSdWaterBillsListActivity.this, ZryuSdWaterBillsListActivity.this, paramAnonymousList));
        ZryuSdWaterBillsListActivity.b(ZryuSdWaterBillsListActivity.this).setAdapter(ZryuSdWaterBillsListActivity.a(ZryuSdWaterBillsListActivity.this));
      }
      ZryuSdWaterBillsListActivity.b(ZryuSdWaterBillsListActivity.this).setEmptyView(ZryuSdWaterBillsListActivity.c(ZryuSdWaterBillsListActivity.this));
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
      j.zryuSdWaterBillList(this, this.a, this.g);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903601);
    this.f = new b(null);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.ziroomcustomer.payresult");
    registerReceiver(this.f, paramBundle);
    a();
    b();
  }
  
  protected void onDestroy()
  {
    unregisterReceiver(this.f);
    super.onDestroy();
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
    private List<FeeBillDetail> b;
    private Context c;
    private LayoutInflater d;
    private Set<String> e;
    private int f;
    private int g;
    private DecimalFormat h = new DecimalFormat("0.00");
    
    public a(List<FeeBillDetail> paramList)
    {
      FeeBillDetail localFeeBillDetail;
      this.b = localFeeBillDetail;
      this.d = LayoutInflater.from(paramList);
      this.c = paramList;
      this.e = new HashSet();
      if ((localFeeBillDetail != null) && (localFeeBillDetail.size() > 0))
      {
        paramList = localFeeBillDetail.iterator();
        while (paramList.hasNext())
        {
          localFeeBillDetail = (FeeBillDetail)paramList.next();
          if (!TextUtils.isEmpty(localFeeBillDetail.getBillNum())) {
            this.e.add(localFeeBillDetail.getBillNum());
          }
        }
      }
      this.f = ((int)(ZryuSdWaterBillsListActivity.this.getResources().getDisplayMetrics().density * 12.0F));
      this.g = Color.parseColor("#999999");
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
        paramView = this.d.inflate(2130904628, paramViewGroup, false);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131689541));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689822));
        paramViewGroup.c = ((LinearLayout)paramView.findViewById(2131689775));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131691107));
        paramViewGroup.e = ((Button)paramView.findViewById(2131690043));
        paramView.setTag(paramViewGroup);
      }
      final FeeBillDetail localFeeBillDetail;
      for (;;)
      {
        localFeeBillDetail = (FeeBillDetail)getItem(paramInt);
        paramViewGroup.a.setText(localFeeBillDetail.getBillTitle());
        paramViewGroup.c.removeAllViews();
        if ((localFeeBillDetail.getItemList() == null) || (localFeeBillDetail.getItemList().size() <= 0)) {
          break;
        }
        paramViewGroup.c.setVisibility(0);
        localObject = localFeeBillDetail.getItemList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ZryuSignKvItem localZryuSignKvItem = (ZryuSignKvItem)((Iterator)localObject).next();
          TextView localTextView = new TextView(this.c);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.setMargins(0, 0, 0, this.f);
          localTextView.setLayoutParams(localLayoutParams);
          localTextView.setLines(1);
          localTextView.setTextSize(2, 12.0F);
          localTextView.setTextColor(this.g);
          localTextView.setText(localZryuSignKvItem.getName() + ":" + localZryuSignKvItem.getValue());
          paramViewGroup.c.addView(localTextView);
        }
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.c.setVisibility(8);
      Object localObject = "";
      if (localFeeBillDetail.getOughtAmount() != null) {
        localObject = "¥" + this.h.format(localFeeBillDetail.getOughtAmount().intValue() / 100.0F);
      }
      paramViewGroup.d.setText((CharSequence)localObject);
      if ((!TextUtils.isEmpty(localFeeBillDetail.getOperation())) && (localFeeBillDetail.getOperationCode() != null))
      {
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.e.setText(localFeeBillDetail.getOperation());
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (localFeeBillDetail.getOperationCode().intValue() == 1)
            {
              ZryuSdWaterBillsListActivity.a(ZryuSdWaterBillsListActivity.this, localFeeBillDetail);
              paramAnonymousView = ZryuSdWaterBillsListActivity.this;
              if (localFeeBillDetail.getOughtAmount() != null) {
                break label81;
              }
            }
            label81:
            for (int i = 0;; i = localFeeBillDetail.getOughtAmount().intValue())
            {
              com.ziroom.ziroomcustomer.payment.a.startPayActivty(paramAnonymousView, i, localFeeBillDetail.getBillType(), localFeeBillDetail.getBillNum(), localFeeBillDetail.getSystemId());
              return;
            }
          }
        });
        return paramView;
      }
      paramViewGroup.e.setVisibility(8);
      return paramView;
    }
    
    private class a
    {
      TextView a;
      TextView b;
      LinearLayout c;
      TextView d;
      Button e;
      
      private a() {}
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = paramIntent.getIntExtra("code", -1);
      paramContext = paramIntent.getStringExtra("message");
      ZryuSdWaterBillsListActivity.this.showToast(paramContext);
      if ((i == 1) && (ZryuSdWaterBillsListActivity.d(ZryuSdWaterBillsListActivity.this) != null))
      {
        paramContext = new Intent(ZryuSdWaterBillsListActivity.this, ZryuSignPaySuccessActivity.class);
        paramContext.putExtra("contractId", ZryuSdWaterBillsListActivity.e(ZryuSdWaterBillsListActivity.this));
        paramContext.putExtra("contractCode", "");
        paramContext.putExtra("period", "0");
        paramContext.putExtra("type", ZryuSdWaterBillsListActivity.d(ZryuSdWaterBillsListActivity.this).getBillType());
        paramContext.putExtra("isPaySuccess", true);
        paramIntent = new DecimalFormat("0.00");
        if (ZryuSdWaterBillsListActivity.d(ZryuSdWaterBillsListActivity.this).getOughtAmount() != null) {
          break label160;
        }
      }
      label160:
      for (i = 0;; i = ZryuSdWaterBillsListActivity.d(ZryuSdWaterBillsListActivity.this).getOughtAmount().intValue())
      {
        paramContext.putExtra("money", paramIntent.format(i / 100.0F));
        ZryuSdWaterBillsListActivity.this.startActivityAndFinish(paramContext);
        return;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSdWaterBillsListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */