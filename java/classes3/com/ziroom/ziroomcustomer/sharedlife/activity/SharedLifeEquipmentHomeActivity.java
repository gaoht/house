package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.sharedlife.c.g;
import java.util.ArrayList;
import java.util.List;

public class SharedLifeEquipmentHomeActivity
  extends BaseActivity
{
  private Context a;
  private ImageView b;
  private ImageView c;
  private ListView d;
  private TextView e;
  private String f;
  private List<g> g = new ArrayList();
  private String r;
  private com.ziroom.ziroomcustomer.sharedlife.a.e s;
  
  private void a()
  {
    this.e = ((TextView)findViewById(2131689541));
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ImageView)findViewById(2131689689));
    this.d = ((ListView)findViewById(2131692358));
  }
  
  private void b()
  {
    this.f = getIntent().getStringExtra("rentContractCode");
    this.r = getIntent().getStringExtra("villageName");
    this.e.setText(this.r);
    this.s = new com.ziroom.ziroomcustomer.sharedlife.a.e(this.a, this.g);
    this.d.setAdapter(this.s);
    e();
  }
  
  private void e()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {
      com.ziroom.ziroomcustomer.sharedlife.a.getSharedLifeEqTypes(this, localUserInfo.getUid(), this.f, new d(this, new com.ziroom.ziroomcustomer.e.c.e(g.class))
      {
        public void onSuccess(int paramAnonymousInt, List<g> paramAnonymousList)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousList);
          if (paramAnonymousList != null)
          {
            SharedLifeEquipmentHomeActivity.a(SharedLifeEquipmentHomeActivity.this).clear();
            SharedLifeEquipmentHomeActivity.a(SharedLifeEquipmentHomeActivity.this).addAll(paramAnonymousList);
            SharedLifeEquipmentHomeActivity.b(SharedLifeEquipmentHomeActivity.this).notifyDataSetChanged();
          }
        }
      });
    }
  }
  
  private void f()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharedLifeEquipmentHomeActivity.this.finish();
      }
    });
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new Intent(SharedLifeEquipmentHomeActivity.c(SharedLifeEquipmentHomeActivity.this), SharedLifeOrdersActivity.class);
        paramAnonymousView.putExtra("rentContractCode", SharedLifeEquipmentHomeActivity.d(SharedLifeEquipmentHomeActivity.this));
        SharedLifeEquipmentHomeActivity.this.startActivity(paramAnonymousView);
      }
    });
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((SharedLifeEquipmentHomeActivity.a(SharedLifeEquipmentHomeActivity.this) == null) || (SharedLifeEquipmentHomeActivity.a(SharedLifeEquipmentHomeActivity.this).size() == 0)) {
          return;
        }
        paramAnonymousAdapterView = new Intent(SharedLifeEquipmentHomeActivity.c(SharedLifeEquipmentHomeActivity.this), SharedLifeEquipmentListActivity.class);
        paramAnonymousAdapterView.putExtra("rentContractCode", SharedLifeEquipmentHomeActivity.d(SharedLifeEquipmentHomeActivity.this));
        paramAnonymousAdapterView.putExtra("deviceType", ((g)SharedLifeEquipmentHomeActivity.a(SharedLifeEquipmentHomeActivity.this).get(paramAnonymousInt)).getDeviceType());
        paramAnonymousAdapterView.putExtra("deviceTypeName", ((g)SharedLifeEquipmentHomeActivity.a(SharedLifeEquipmentHomeActivity.this).get(paramAnonymousInt)).getDeviceTypeName());
        SharedLifeEquipmentHomeActivity.this.startActivity(paramAnonymousAdapterView);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903484);
    this.a = this;
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeEquipmentHomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */