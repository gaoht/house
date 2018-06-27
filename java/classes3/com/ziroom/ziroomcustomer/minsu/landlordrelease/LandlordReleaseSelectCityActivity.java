package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCityTreeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCityTreeBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCityTreeBean.DataBean.CityTreeListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX.NodesBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LandlordReleaseSelectCityActivity
  extends BaseFluxActivity
{
  private Context b;
  @BindView(2131690460)
  View btn_cancel;
  private Unbinder c;
  private c d;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b e;
  private LandlordReleaseCityTreeBean f;
  private String[] g = new String[4];
  @BindView(2131691553)
  ListView lv_city_level_1;
  @BindView(2131691554)
  ListView lv_city_level_2;
  @BindView(2131691555)
  ListView lv_city_level_3;
  @BindView(2131691556)
  ListView lv_city_level_4;
  private a r;
  private a s;
  private a t;
  private a u;
  private int v;
  private int w;
  private int x;
  private int y;
  
  private void a()
  {
    this.d = new c(this);
    this.a.register(this.d);
    this.e = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void a(int paramInt, b paramb)
  {
    Object localObject;
    b localb;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.r.getList().clear();
      paramb = this.f.getData().getCityTreeList().iterator();
      while (paramb.hasNext())
      {
        localObject = (LandlordReleaseCityTreeBean.DataBean.CityTreeListBean)paramb.next();
        localb = new b(null);
        localb.a = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean)localObject).getText();
        localb.b = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean)localObject).getCode();
        localb.c = paramInt;
        localb.d = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean)localObject).getNodes();
        this.r.getList().add(localb);
      }
      this.r.notifyDataSetChanged();
      return;
    case 2: 
      paramb = (List)paramb.d;
      this.s.getList().clear();
      if (paramb != null)
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          localObject = (LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX)paramb.next();
          localb = new b(null);
          localb.a = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX)localObject).getText();
          localb.b = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX)localObject).getCode();
          localb.c = paramInt;
          localb.d = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX)localObject).getNodes();
          this.s.getList().add(localb);
        }
      }
      this.s.notifyDataSetChanged();
      return;
    case 3: 
      paramb = (List)paramb.d;
      this.t.getList().clear();
      if (paramb != null)
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          localObject = (LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX)paramb.next();
          localb = new b(null);
          localb.a = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX)localObject).getText();
          localb.b = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX)localObject).getCode();
          localb.c = paramInt;
          localb.d = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX)localObject).getNodes();
          this.t.getList().add(localb);
        }
      }
      this.t.notifyDataSetChanged();
      return;
    }
    paramb = (List)paramb.d;
    this.u.getList().clear();
    if (paramb != null)
    {
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        localObject = (LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX.NodesBean)paramb.next();
        localb = new b(null);
        localb.a = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX.NodesBean)localObject).getText();
        localb.b = ((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX.NodesBeanX.NodesBean)localObject).getCode();
        localb.c = paramInt;
        localb.d = null;
        this.u.getList().add(localb);
      }
    }
    this.u.notifyDataSetChanged();
  }
  
  private void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.g[0] = paramString;
      this.g[1] = null;
      this.g[2] = null;
      this.g[3] = null;
      return;
    case 2: 
      this.g[1] = paramString;
      this.g[2] = null;
      this.g[3] = null;
      return;
    case 3: 
      this.g[2] = paramString;
      this.g[3] = null;
      return;
    }
    this.g[3] = paramString;
  }
  
  private void b()
  {
    this.r = new a(null);
    this.s = new a(null);
    this.t = new a(null);
    this.u = new a(null);
    this.lv_city_level_1.setAdapter(this.r);
    this.lv_city_level_2.setAdapter(this.s);
    this.lv_city_level_3.setAdapter(this.t);
    this.lv_city_level_4.setAdapter(this.u);
    this.e.getCityTree(this, this);
  }
  
  private void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = this.g;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localStringBuilder.append((String)localObject2).append(" ");
        i += 1;
      }
      else if (localStringBuilder.length() > 0)
      {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
    }
    localObject1 = getIntent();
    Object localObject2 = new StringBuilder();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("cityCode", ((StringBuilder)localObject2).toString());
      ((Intent)localObject1).putExtra("address", localStringBuilder.toString());
      setResult(-1, (Intent)localObject1);
      finish();
      return;
      ((StringBuilder)localObject2).append(((b)this.r.getList().get(this.v)).b).append(",").append(((b)this.s.getList().get(this.w)).b);
      continue;
      ((StringBuilder)localObject2).append(((b)this.r.getList().get(this.v)).b).append(",").append(((b)this.s.getList().get(this.w)).b).append(",").append(((b)this.t.getList().get(this.x)).b);
      continue;
      ((StringBuilder)localObject2).append(((b)this.r.getList().get(this.v)).b).append(",").append(((b)this.s.getList().get(this.w)).b).append(",").append(((b)this.t.getList().get(this.x)).b).append(",").append(((b)this.u.getList().get(this.y)).b);
    }
  }
  
  private void e()
  {
    this.lv_city_level_1.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, paramAnonymousInt);
        LandlordReleaseSelectCityActivity.this.lv_city_level_3.setVisibility(8);
        LandlordReleaseSelectCityActivity.this.lv_city_level_4.setVisibility(8);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, 2, (LandlordReleaseSelectCityActivity.b)LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this).getList().get(paramAnonymousInt));
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this).setSelected(paramAnonymousInt);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, 1, ((LandlordReleaseSelectCityActivity.b)LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this).getList().get(paramAnonymousInt)).a);
      }
    });
    this.lv_city_level_2.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        LandlordReleaseSelectCityActivity.b(LandlordReleaseSelectCityActivity.this, paramAnonymousInt);
        LandlordReleaseSelectCityActivity.this.lv_city_level_4.setVisibility(8);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, 3, (LandlordReleaseSelectCityActivity.b)LandlordReleaseSelectCityActivity.b(LandlordReleaseSelectCityActivity.this).getList().get(paramAnonymousInt));
        LandlordReleaseSelectCityActivity.b(LandlordReleaseSelectCityActivity.this).setSelected(paramAnonymousInt);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, 2, ((LandlordReleaseSelectCityActivity.b)LandlordReleaseSelectCityActivity.b(LandlordReleaseSelectCityActivity.this).getList().get(paramAnonymousInt)).a);
        if (LandlordReleaseSelectCityActivity.c(LandlordReleaseSelectCityActivity.this).getList().size() == 0)
        {
          LandlordReleaseSelectCityActivity.c(LandlordReleaseSelectCityActivity.this, 2);
          return;
        }
        LandlordReleaseSelectCityActivity.this.lv_city_level_3.setVisibility(0);
      }
    });
    this.lv_city_level_3.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        LandlordReleaseSelectCityActivity.d(LandlordReleaseSelectCityActivity.this, paramAnonymousInt);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, 4, (LandlordReleaseSelectCityActivity.b)LandlordReleaseSelectCityActivity.c(LandlordReleaseSelectCityActivity.this).getList().get(paramAnonymousInt));
        LandlordReleaseSelectCityActivity.c(LandlordReleaseSelectCityActivity.this).setSelected(paramAnonymousInt);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, 3, ((LandlordReleaseSelectCityActivity.b)LandlordReleaseSelectCityActivity.c(LandlordReleaseSelectCityActivity.this).getList().get(paramAnonymousInt)).a);
        if (LandlordReleaseSelectCityActivity.d(LandlordReleaseSelectCityActivity.this).getList().size() == 0)
        {
          LandlordReleaseSelectCityActivity.c(LandlordReleaseSelectCityActivity.this, 3);
          return;
        }
        LandlordReleaseSelectCityActivity.this.lv_city_level_4.setVisibility(0);
      }
    });
    this.lv_city_level_4.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        LandlordReleaseSelectCityActivity.e(LandlordReleaseSelectCityActivity.this, paramAnonymousInt);
        LandlordReleaseSelectCityActivity.d(LandlordReleaseSelectCityActivity.this).setSelected(paramAnonymousInt);
        LandlordReleaseSelectCityActivity.a(LandlordReleaseSelectCityActivity.this, 4, ((LandlordReleaseSelectCityActivity.b)LandlordReleaseSelectCityActivity.d(LandlordReleaseSelectCityActivity.this).getList().get(paramAnonymousInt)).a);
        LandlordReleaseSelectCityActivity.c(LandlordReleaseSelectCityActivity.this, 4);
      }
    });
  }
  
  @OnClick({2131690460})
  public void OnClick(View paramView)
  {
    if (paramView != null) {}
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
    setContentView(2130903305);
    this.b = this;
    this.c = ButterKnife.bind(this);
    a();
    b();
    e();
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.d);
    this.c.unbind();
    com.freelxl.baselibrary.d.a.cancel(this);
    super.onDestroy();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    do
    {
      return;
      if (!parama.equals("get_city_tree")) {
        break;
      }
      i = 0;
      break;
      if (!parama.equals("get_city_tree_error")) {
        break;
      }
      i = 1;
      break;
      this.f = this.d.getLandlordReleaseCityTreeBean();
    } while ((this.f == null) || (this.f.getData() == null) || (this.f.getData().getCityTreeList() == null) || (this.f.getData().getCityTreeList().size() <= 0) || (((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean)this.f.getData().getCityTreeList().get(0)).getNodes().size() <= 0) || (((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean.NodesBeanXX)((LandlordReleaseCityTreeBean.DataBean.CityTreeListBean)this.f.getData().getCityTreeList().get(0)).getNodes().get(0)).getNodes().size() <= 0));
    this.lv_city_level_3.setVisibility(8);
    this.lv_city_level_4.setVisibility(8);
    a(1, null);
    a(2, (b)this.r.getList().get(0));
    this.r.setSelected(0);
    a(1, ((b)this.r.getList().get(0)).a);
    a(2, ((b)this.s.getList().get(0)).a);
  }
  
  private class a
    extends BaseAdapter
  {
    private List<LandlordReleaseSelectCityActivity.b> b;
    
    private a() {}
    
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
    
    public List<LandlordReleaseSelectCityActivity.b> getList()
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      return this.b;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(LandlordReleaseSelectCityActivity.e(LandlordReleaseSelectCityActivity.this)).inflate(2130904328, paramViewGroup, false);
        paramView = new a();
        paramView.a = ((TextView)localView.findViewById(2131695287));
        localView.setTag(paramView);
      }
      paramView = (a)localView.getTag();
      paramView.a.setText(((LandlordReleaseSelectCityActivity.b)this.b.get(paramInt)).a);
      if (((LandlordReleaseSelectCityActivity.b)this.b.get(paramInt)).e)
      {
        paramView.a.setTextColor(Color.parseColor("#ffa000"));
        return localView;
      }
      paramView.a.setTextColor(Color.parseColor("#444444"));
      return localView;
    }
    
    public void setList(List<LandlordReleaseSelectCityActivity.b> paramList)
    {
      this.b = paramList;
      notifyDataSetChanged();
    }
    
    public void setSelected(int paramInt)
    {
      if ((this.b != null) && (paramInt < this.b.size()))
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
          ((LandlordReleaseSelectCityActivity.b)localIterator.next()).e = false;
        }
        ((LandlordReleaseSelectCityActivity.b)this.b.get(paramInt)).e = true;
        notifyDataSetChanged();
      }
    }
    
    class a
    {
      TextView a;
      
      a() {}
    }
  }
  
  private class b
  {
    String a;
    String b;
    int c;
    Object d;
    boolean e;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LandlordReleaseSelectCityActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */