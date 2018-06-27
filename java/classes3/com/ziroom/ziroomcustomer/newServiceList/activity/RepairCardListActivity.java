package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newServiceList.a.f;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CleanCard;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RepairCardListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private RelativeLayout A;
  private BroadcastReceiver B = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("refresh_card"))
      {
        if (RepairCardListActivity.a(RepairCardListActivity.this) != null) {
          RepairCardListActivity.a(RepairCardListActivity.this).clear();
        }
        if (RepairCardListActivity.b(RepairCardListActivity.this) != null) {
          RepairCardListActivity.b(RepairCardListActivity.this).clear();
        }
        if (RepairCardListActivity.c(RepairCardListActivity.this) != null) {
          RepairCardListActivity.c(RepairCardListActivity.this).clear();
        }
        RepairCardListActivity.d(RepairCardListActivity.this);
      }
    }
  };
  private Context a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private ListViewForScrollView e;
  private TextView f;
  private TextView g;
  private TextView r;
  private List<CleanCard> s = new ArrayList();
  private List<CleanCard> t = new ArrayList();
  private List<CleanCard> u = new ArrayList();
  private f v;
  private Intent w;
  private int x = 111;
  private RelativeLayout y;
  private RelativeLayout z;
  
  private void a()
  {
    j.getRepairCardList(this.a, null, new a());
  }
  
  private void b()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131689541));
    this.c.setText("自如维修卡");
    this.d = ((TextView)findViewById(2131690242));
    this.e = ((ListViewForScrollView)findViewById(2131690240));
    this.f = ((TextView)findViewById(2131690247));
    this.g = ((TextView)findViewById(2131690244));
    this.r = ((TextView)findViewById(2131690191));
    this.y = ((RelativeLayout)findViewById(2131690202));
    this.z = ((RelativeLayout)findViewById(2131690246));
    this.A = ((RelativeLayout)findViewById(2131690248));
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.v = new f(this.a, this.t);
    this.e.setAdapter(this.v);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("refresh_card");
    registerReceiver(this.B, localIntentFilter);
  }
  
  private void e()
  {
    this.w = new Intent(this.a, RepairActiviteCardActivity.class);
    startActivityForResult(this.w, this.x);
  }
  
  private void f()
  {
    this.w = new Intent(this.a, RepairBuyCardActivity.class);
    startActivity(this.w);
  }
  
  private void g()
  {
    this.w = new Intent(this.a, RepairCardDetailActivity.class);
    startActivity(this.w);
  }
  
  private void h()
  {
    this.w = new Intent(this.a, RepairOverdueCardActivity.class);
    this.w.putExtra("overdueCardList", (Serializable)this.u);
    startActivity(this.w);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == this.x) && (paramInt2 == -1))
    {
      if (this.s != null) {
        this.s.clear();
      }
      if (this.t != null) {
        this.t.clear();
      }
      if (this.u != null) {
        this.u.clear();
      }
      a();
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
    case 2131689492: 
      finish();
      return;
    case 2131690242: 
      g();
      return;
    case 2131690247: 
      h();
      return;
    case 2131690246: 
      h();
      return;
    case 2131690248: 
      h();
      return;
    case 2131690244: 
      f();
      return;
    }
    e();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903442);
    w.onEvent(this.a, "page_store_card");
    this.a = this;
    b();
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.B != null) {
        unregisterReceiver(this.B);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(a.parseArray(paramString.get("data").toString(), CleanCard.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        RepairCardListActivity.a(RepairCardListActivity.this, (List)paramk.getObject());
        RepairCardListActivity.b(RepairCardListActivity.this).clear();
        if ((RepairCardListActivity.a(RepairCardListActivity.this) != null) && (RepairCardListActivity.a(RepairCardListActivity.this).size() > 0))
        {
          paramk = RepairCardListActivity.a(RepairCardListActivity.this).iterator();
          while (paramk.hasNext())
          {
            CleanCard localCleanCard = (CleanCard)paramk.next();
            if (localCleanCard.getCardState() == 2) {
              RepairCardListActivity.b(RepairCardListActivity.this).add(localCleanCard);
            } else {
              RepairCardListActivity.c(RepairCardListActivity.this).add(localCleanCard);
            }
          }
          RepairCardListActivity.e(RepairCardListActivity.this).notifyDataSetChanged();
          if (RepairCardListActivity.b(RepairCardListActivity.this).size() == 0)
          {
            RepairCardListActivity.f(RepairCardListActivity.this).setVisibility(0);
            RepairCardListActivity.g(RepairCardListActivity.this).setVisibility(8);
            RepairCardListActivity.h(RepairCardListActivity.this).setVisibility(0);
          }
          if (RepairCardListActivity.b(RepairCardListActivity.this).size() > 0)
          {
            RepairCardListActivity.f(RepairCardListActivity.this).setVisibility(8);
            RepairCardListActivity.g(RepairCardListActivity.this).setVisibility(0);
            RepairCardListActivity.h(RepairCardListActivity.this).setVisibility(8);
          }
        }
      }
      do
      {
        return;
        RepairCardListActivity.f(RepairCardListActivity.this).setVisibility(0);
        RepairCardListActivity.g(RepairCardListActivity.this).setVisibility(8);
        RepairCardListActivity.h(RepairCardListActivity.this).setVisibility(0);
        return;
        RepairCardListActivity.f(RepairCardListActivity.this).setVisibility(0);
        RepairCardListActivity.g(RepairCardListActivity.this).setVisibility(8);
        RepairCardListActivity.h(RepairCardListActivity.this).setVisibility(0);
      } while (TextUtils.isEmpty(paramk.getMessage()));
      g.textToast(RepairCardListActivity.i(RepairCardListActivity.this), paramk.getMessage());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairCardListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */