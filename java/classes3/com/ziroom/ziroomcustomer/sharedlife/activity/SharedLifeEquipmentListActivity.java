package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.sharedlife.c.c.a;
import java.util.ArrayList;
import java.util.List;

public class SharedLifeEquipmentListActivity
  extends BaseActivity
{
  List<c.a> a = new ArrayList();
  private Context b;
  private ImageView c;
  private MyGridView d;
  private TextView e;
  private String f;
  private String g;
  private com.ziroom.ziroomcustomer.sharedlife.c.c r;
  private com.ziroom.ziroomcustomer.sharedlife.a.c s;
  
  private void a()
  {
    j.requestFocus(findViewById(2131689541));
    this.e = ((TextView)findViewById(2131689541));
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((MyGridView)findViewById(2131692359));
  }
  
  private void b()
  {
    this.f = getIntent().getStringExtra("rentContractCode");
    this.g = getIntent().getStringExtra("deviceType");
    String str = getIntent().getStringExtra("deviceTypeName");
    this.e.setText(str);
    this.s = new com.ziroom.ziroomcustomer.sharedlife.a.c(this.b, this.a, this.f);
    this.d.setAdapter(this.s);
    e();
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeEqViaType(this, localUserInfo.getUid(), this.f, this.g, new d(this, new f(com.ziroom.ziroomcustomer.sharedlife.c.c.class))
      {
        public void onSuccess(int paramAnonymousInt, com.ziroom.ziroomcustomer.sharedlife.c.c paramAnonymousc)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousc);
          if (paramAnonymousc != null)
          {
            SharedLifeEquipmentListActivity.a(SharedLifeEquipmentListActivity.this, paramAnonymousc);
            if ((SharedLifeEquipmentListActivity.a(SharedLifeEquipmentListActivity.this).getTbDeviceList() != null) && (SharedLifeEquipmentListActivity.a(SharedLifeEquipmentListActivity.this).getTbDeviceList().size() > 0))
            {
              SharedLifeEquipmentListActivity.this.a.clear();
              SharedLifeEquipmentListActivity.this.a.addAll(SharedLifeEquipmentListActivity.a(SharedLifeEquipmentListActivity.this).getTbDeviceList());
              SharedLifeEquipmentListActivity.b(SharedLifeEquipmentListActivity.this).notifyDataSetChanged();
            }
          }
        }
      });
    }
  }
  
  private void f()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharedLifeEquipmentListActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903485);
    this.b = this;
    a();
    b();
    f();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeEquipmentListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */