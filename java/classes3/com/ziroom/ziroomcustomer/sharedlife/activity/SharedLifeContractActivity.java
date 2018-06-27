package com.ziroom.ziroomcustomer.sharedlife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.alibaba.fastjson.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.sharedlife.a.b;
import com.ziroom.ziroomcustomer.sharedlife.c.a.a;
import java.util.ArrayList;
import java.util.List;

public class SharedLifeContractActivity
  extends BaseActivity
{
  private SharedLifeContractActivity a;
  private ImageView b;
  private ListView c;
  private LinearLayout d;
  private List<String> e = new ArrayList();
  private List<a.a> f;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ListView)findViewById(2131691156));
    this.d = ((LinearLayout)findViewById(2131691155));
  }
  
  private void b()
  {
    Object localObject = getIntent().getStringExtra("tbRentContracts");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.d.setVisibility(8);
      this.c.setVisibility(0);
      this.f = a.parseArray((String)localObject, a.a.class);
      int i = 0;
      while (i < this.f.size())
      {
        this.e.add(((a.a)this.f.get(i)).getVillage());
        i += 1;
      }
      localObject = new b(this.a, this.e);
      this.c.setAdapter((ListAdapter)localObject);
      return;
    }
    this.d.setVisibility(0);
    this.c.setVisibility(8);
  }
  
  private void e()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        SharedLifeContractActivity.this.finish();
      }
    });
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((SharedLifeContractActivity.a(SharedLifeContractActivity.this) != null) && (SharedLifeContractActivity.a(SharedLifeContractActivity.this).size() > 0))
        {
          paramAnonymousAdapterView = new Intent(SharedLifeContractActivity.b(SharedLifeContractActivity.this), SharedLifeEquipmentHomeActivity.class);
          paramAnonymousAdapterView.putExtra("rentContractCode", ((a.a)SharedLifeContractActivity.a(SharedLifeContractActivity.this).get(paramAnonymousInt)).getRentContractCode());
          paramAnonymousAdapterView.putExtra("villageName", ((a.a)SharedLifeContractActivity.a(SharedLifeContractActivity.this).get(paramAnonymousInt)).getVillage());
          SharedLifeContractActivity.this.startActivity(paramAnonymousAdapterView);
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903254);
    this.a = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/activity/SharedLifeContractActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */