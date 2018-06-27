package com.ziroom.ziroomcustomer.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.d.f.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.f.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.LeaseListEntity;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.ziroomapartment.activity.ZryuLeaseInfoActivity;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuContactList;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuContractItem;
import java.util.ArrayList;
import java.util.List;

public class LeaseInvalidActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private List<LeaseListEntity> a = new ArrayList();
  private ListView b;
  private com.ziroom.ziroomcustomer.adapter.f c;
  private Context d;
  private ImageView e;
  private ImageView f;
  private TextView g;
  private ZryuContactList r;
  private Handler s = new Handler()
  {
    @SuppressLint({"InlinedApi"})
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        LeaseInvalidActivity.a(LeaseInvalidActivity.this, (List)locall.getObject());
        if (LeaseInvalidActivity.b(LeaseInvalidActivity.this).size() >= 1)
        {
          LeaseInvalidActivity.c(LeaseInvalidActivity.this).setLeaseList(LeaseInvalidActivity.b(LeaseInvalidActivity.this));
          LeaseInvalidActivity.c(LeaseInvalidActivity.this).notifyDataSetChanged();
        }
      }
      LeaseInvalidActivity.d(LeaseInvalidActivity.this);
    }
  };
  
  private void a()
  {
    this.g = ((TextView)findViewById(2131689533));
    this.f = ((ImageView)findViewById(2131691914));
    this.e = ((ImageView)findViewById(2131693303));
    this.e.setVisibility(8);
    this.b = ((ListView)findViewById(2131696612));
    this.c = new com.ziroom.ziroomcustomer.adapter.f(this.a, this, true);
    this.b.setAdapter(this.c);
    this.c.setSetOnItemClick(new f.b()
    {
      public void onItem(LeaseListEntity paramAnonymousLeaseListEntity)
      {
        if (paramAnonymousLeaseListEntity.getZryuContractInfo() == null)
        {
          localIntent = new Intent(LeaseInvalidActivity.a(LeaseInvalidActivity.this), NewLeaseInfoActivity.class);
          localIntent.putExtra("contract_code", paramAnonymousLeaseListEntity.getContractCode());
          localIntent.putExtra("sysContractId", paramAnonymousLeaseListEntity.getSysContractId());
          localIntent.putExtra("isInvalid", "isInvalid");
          LeaseInvalidActivity.this.startActivity(localIntent);
          return;
        }
        Intent localIntent = new Intent(LeaseInvalidActivity.this, ZryuLeaseInfoActivity.class);
        localIntent.putExtra("contractId", paramAnonymousLeaseListEntity.getZryuContractInfo().getContractId());
        localIntent.putExtra("deCode", "XQ");
        LeaseInvalidActivity.this.startActivity(localIntent);
      }
      
      public void showHousekeeper(String paramAnonymousString) {}
      
      public void toEvaluatePage(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public void toIntent(LeaseListEntity paramAnonymousLeaseListEntity, Class paramAnonymousClass)
      {
        LeaseInvalidActivity.this.showToast("失效合同不能进行操作。");
      }
      
      public void toPay(LeaseListEntity paramAnonymousLeaseListEntity) {}
      
      public void toPropertyState(LeaseListEntity paramAnonymousLeaseListEntity)
      {
        LeaseInvalidActivity.this.showToast("失效合同不能进行操作。");
      }
    });
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setText("失效合同");
  }
  
  private void b()
  {
    if (checkNet(this))
    {
      j.zryuInvalidContractList(this, new c(this, new com.ziroom.ziroomcustomer.e.c.f(ZryuContactList.class))
      {
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          super.onFailure(paramAnonymousThrowable);
          LeaseInvalidActivity.e(LeaseInvalidActivity.this);
        }
        
        public void onSuccess(int paramAnonymousInt, ZryuContactList paramAnonymousZryuContactList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousZryuContactList);
          LeaseInvalidActivity.a(LeaseInvalidActivity.this, paramAnonymousZryuContactList);
          LeaseInvalidActivity.e(LeaseInvalidActivity.this);
        }
      });
      return;
    }
    af.showToast(this, "请检查您的网络，稍后再试！");
  }
  
  private void e()
  {
    if ((this.r != null) && (this.r.getContractList() != null) && (this.r.getContractList().size() > 0))
    {
      if (this.a == null) {
        this.a = new ArrayList();
      }
      int i = 0;
      while (i < this.r.getContractList().size())
      {
        LeaseListEntity localLeaseListEntity = new LeaseListEntity();
        localLeaseListEntity.setZryuContractInfo((ZryuContractItem)this.r.getContractList().get(i));
        this.a.add(localLeaseListEntity);
        i += 1;
      }
      this.c.setLeaseList(this.a);
      this.c.notifyDataSetChanged();
    }
    if ((this.a == null) || (this.a.size() == 0))
    {
      finish();
      showToast("您暂时没有失效合同");
    }
    dismissProgress();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131693303: 
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904832);
    this.d = this;
    a();
    showProgress("");
    d.getLease(this.d, this.s, "1", 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/activity/LeaseInvalidActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */