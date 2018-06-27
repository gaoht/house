package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.d.ax;
import com.ziroom.ziroomcustomer.newrepair.a.k;
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InternalRepairSelectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Context a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private ListView e;
  private ExpandableListView f;
  private ArrayList<String> g = new ArrayList();
  private List<ax> r = new ArrayList();
  private boolean s = false;
  private k t;
  private com.ziroom.ziroomcustomer.newrepair.a.a u;
  private Map<Integer, com.ziroom.ziroomcustomer.newrepair.a.e> v = new HashMap();
  private boolean w = false;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((TextView)findViewById(2131691024));
    this.e = ((ListView)findViewById(2131691025));
    this.f = ((ExpandableListView)findViewById(2131691026));
    this.d = ((TextView)findViewById(2131691027));
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private void e()
  {
    this.w = getIntent().getBooleanExtra("isMyFragment", false);
    f();
  }
  
  private void f()
  {
    n.getInternalRepairGoodList(this.a, new com.ziroom.ziroomcustomer.e.a.a(this.a, new l(ax.class, new com.ziroom.ziroomcustomer.e.c.a.e()))
    {
      public void onSuccess(int paramAnonymousInt, List<ax> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        u.d("sdjgkd", "========    getInternalRepairGoodList=" + com.alibaba.fastjson.a.toJSONString(paramAnonymousList));
        if (paramAnonymousList != null)
        {
          InternalRepairSelectActivity.a(InternalRepairSelectActivity.this, paramAnonymousList);
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            ax localax = (ax)paramAnonymousList.next();
            InternalRepairSelectActivity.a(InternalRepairSelectActivity.this).add(localax.getTypeName());
          }
          InternalRepairSelectActivity.b(InternalRepairSelectActivity.this);
        }
      }
    });
  }
  
  private void g()
  {
    int j = 0;
    this.d.setText((CharSequence)this.g.get(0));
    this.t = new k(this.a, this.g);
    this.e.setAdapter(this.t);
    float f1 = j.getRepairSelectWidth(this.a);
    int i = 0;
    while (i < this.r.size())
    {
      this.v.put(Integer.valueOf(i), new com.ziroom.ziroomcustomer.newrepair.a.e(this.a, ((ax)this.r.get(i)).getGoodsList(), f1, this.w));
      i += 1;
    }
    this.u = new com.ziroom.ziroomcustomer.newrepair.a.a(this.a, this.g, this.v);
    this.f.setGroupIndicator(null);
    this.e.setAdapter(this.t);
    this.f.setAdapter(this.u);
    i = j;
    while (i < this.u.getGroupCount())
    {
      this.f.expandGroup(i);
      i += 1;
    }
    this.e.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        InternalRepairSelectActivity.c(InternalRepairSelectActivity.this).setSelectItem(paramAnonymousInt);
        InternalRepairSelectActivity.c(InternalRepairSelectActivity.this).notifyDataSetChanged();
        InternalRepairSelectActivity.d(InternalRepairSelectActivity.this).setText((CharSequence)InternalRepairSelectActivity.a(InternalRepairSelectActivity.this).get(paramAnonymousInt));
        InternalRepairSelectActivity.e(InternalRepairSelectActivity.this).setSelectedGroup(paramAnonymousInt);
        InternalRepairSelectActivity.a(InternalRepairSelectActivity.this, true);
      }
    });
    this.f.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (InternalRepairSelectActivity.f(InternalRepairSelectActivity.this) == true) {
          InternalRepairSelectActivity.a(InternalRepairSelectActivity.this, false);
        }
        do
        {
          return;
          paramAnonymousInt1 = InternalRepairSelectActivity.a(InternalRepairSelectActivity.this).indexOf(((ax)InternalRepairSelectActivity.g(InternalRepairSelectActivity.this).get(paramAnonymousInt1 / 2)).getTypeName());
        } while (paramAnonymousInt1 < 0);
        InternalRepairSelectActivity.c(InternalRepairSelectActivity.this).setSelectItem(paramAnonymousInt1);
        InternalRepairSelectActivity.c(InternalRepairSelectActivity.this).notifyDataSetChanged();
        InternalRepairSelectActivity.d(InternalRepairSelectActivity.this).setText((CharSequence)InternalRepairSelectActivity.a(InternalRepairSelectActivity.this).get(paramAnonymousInt1));
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
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
    }
    paramView = new Intent(this.a, InternalRepairSearchActivity.class);
    paramView.putExtra("isMyFragment", this.w);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903231);
    this.a = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */