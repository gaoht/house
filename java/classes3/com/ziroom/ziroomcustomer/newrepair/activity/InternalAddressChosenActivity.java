package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.alibaba.fastjson.a;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.newrepair.a.b;
import com.ziroom.ziroomcustomer.newrepair.b.i;
import com.ziroom.ziroomcustomer.widget.MyCleanListView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.ArrayList;
import java.util.List;

public class InternalAddressChosenActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView a;
  private View b;
  private ObservableScrollView c;
  private MyCleanListView d;
  private Context e;
  private List<i> f = new ArrayList();
  private List<i> g = new ArrayList();
  private b r;
  private i s;
  
  private void a()
  {
    this.e = this;
    this.a = ((ImageView)findViewById(2131690588));
    this.b = findViewById(2131689853);
    this.c = ((ObservableScrollView)findViewById(2131689506));
    this.d = ((MyCleanListView)findViewById(2131690995));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
  }
  
  private void e()
  {
    String str = getIntent().getStringExtra("addressChosenStr");
    Object localObject = getIntent().getStringExtra("addressListJsonStr");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.g = a.parseArray((String)localObject, i.class);
    }
    if ((this.g != null) && (!this.g.isEmpty())) {}
    for (this.r = new b(this.e, this.g);; this.r = new b(this.e, this.g))
    {
      this.d.setAdapter(this.r);
      this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          int i = 0;
          while (i < InternalAddressChosenActivity.a(InternalAddressChosenActivity.this).size())
          {
            ((i)InternalAddressChosenActivity.a(InternalAddressChosenActivity.this).get(i)).setChosen(false);
            i += 1;
          }
          ((i)InternalAddressChosenActivity.a(InternalAddressChosenActivity.this).get(paramAnonymousInt)).setChosen(true);
          paramAnonymousAdapterView = new Intent(InternalAddressChosenActivity.b(InternalAddressChosenActivity.this), InternalRepairFaultCommitActivity.class);
          paramAnonymousView = a.toJSONString(InternalAddressChosenActivity.a(InternalAddressChosenActivity.this));
          paramAnonymousAdapterView.putExtra("addressPosition", paramAnonymousInt);
          paramAnonymousAdapterView.putExtra("addressListJsonStr", paramAnonymousView);
          InternalAddressChosenActivity.this.setResult(-1, paramAnonymousAdapterView);
          InternalAddressChosenActivity.this.finish();
        }
      });
      return;
      localObject = a.parseArray(getIntent().getStringExtra("mContractList"), Contract.class);
      int i;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          i locali = new i();
          locali.setAddress(((Contract)((List)localObject).get(i)).getAddress());
          locali.setChosen(false);
          this.f.add(locali);
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(str))
      {
        i = 0;
        if (i < this.f.size())
        {
          if (str.equals(((i)this.f.get(i)).getAddress())) {
            ((i)this.f.get(i)).setChosen(true);
          }
          for (;;)
          {
            this.s = new i();
            this.s.setChosen(((i)this.f.get(i)).isChosen());
            this.s.setAddress(((i)this.f.get(i)).getAddress());
            this.g.add(this.s);
            i += 1;
            break;
            ((i)this.f.get(i)).setChosen(false);
          }
        }
      }
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
    setContentView(2130903224);
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalAddressChosenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */