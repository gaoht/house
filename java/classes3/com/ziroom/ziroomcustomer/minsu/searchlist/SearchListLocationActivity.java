package com.ziroom.ziroomcustomer.minsu.searchlist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.ziroom.ziroomcustomer.flux.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.searchlist.base.c;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.LocationInfoBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.LocationInfoBean.DataBeanXX;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.LocationInfoBean.DataBeanXX.ListBean;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.LocationInfoBean.DataBeanXX.ListBean.DataBeanX;
import com.ziroom.ziroomcustomer.minsu.searchlist.model.LocationInfoBean.DataBeanXX.ListBean.DataBeanX.DataBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchListLocationActivity
  extends BaseFluxActivity
{
  private Context b;
  private Unbinder c;
  private com.ziroom.ziroomcustomer.minsu.searchlist.a.a d;
  private com.ziroom.ziroomcustomer.minsu.searchlist.c.a e;
  private LocationInfoBean f;
  private a g;
  @BindView(2131691553)
  ListView lv_level_1;
  @BindView(2131691554)
  ListView lv_level_2;
  @BindView(2131691555)
  ListView lv_level_3;
  private a r;
  private a s;
  private int t;
  private int u;
  private int v;
  
  private void a()
  {
    this.lv_level_1.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        SearchListLocationActivity.a(SearchListLocationActivity.this, paramAnonymousInt);
        SearchListLocationActivity.this.lv_level_3.setVisibility(8);
        SearchListLocationActivity.a(SearchListLocationActivity.this, 2, (SearchListLocationActivity.b)SearchListLocationActivity.a(SearchListLocationActivity.this).getData().get(paramAnonymousInt));
        SearchListLocationActivity.a(SearchListLocationActivity.this).setSelected(paramAnonymousInt);
      }
    });
    this.lv_level_2.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        SearchListLocationActivity.b(SearchListLocationActivity.this, paramAnonymousInt);
        SearchListLocationActivity.a(SearchListLocationActivity.this, 3, (SearchListLocationActivity.b)SearchListLocationActivity.b(SearchListLocationActivity.this).getData().get(paramAnonymousInt));
        SearchListLocationActivity.b(SearchListLocationActivity.this).setSelected(paramAnonymousInt);
        if (SearchListLocationActivity.c(SearchListLocationActivity.this).getData().size() == 0)
        {
          SearchListLocationActivity.c(SearchListLocationActivity.this, 2);
          return;
        }
        SearchListLocationActivity.this.lv_level_3.setVisibility(0);
      }
    });
    this.lv_level_3.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        SearchListLocationActivity.d(SearchListLocationActivity.this, paramAnonymousInt);
        SearchListLocationActivity.a(SearchListLocationActivity.this, 4, (SearchListLocationActivity.b)SearchListLocationActivity.c(SearchListLocationActivity.this).getData().get(paramAnonymousInt));
        SearchListLocationActivity.c(SearchListLocationActivity.this).setSelected(paramAnonymousInt);
        SearchListLocationActivity.c(SearchListLocationActivity.this, 3);
      }
    });
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
      this.g.getData().clear();
      paramb = this.f.getData().getList().iterator();
      while (paramb.hasNext())
      {
        localObject = (LocationInfoBean.DataBeanXX.ListBean)paramb.next();
        localb = new b(null);
        localb.a = ((LocationInfoBean.DataBeanXX.ListBean)localObject).getName();
        localb.c = ((LocationInfoBean.DataBeanXX.ListBean)localObject).getKey();
        localb.d = null;
        localb.e = null;
        localb.b = null;
        localb.f = paramInt;
        localb.g = ((LocationInfoBean.DataBeanXX.ListBean)localObject).getData();
        this.g.getData().add(localb);
      }
      this.g.notifyDataSetChanged();
      return;
    case 2: 
      paramb = (List)paramb.g;
      this.r.getData().clear();
      if (paramb != null)
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          localObject = (LocationInfoBean.DataBeanXX.ListBean.DataBeanX)paramb.next();
          localb = new b(null);
          localb.a = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX)localObject).getName();
          localb.b = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX)localObject).getValue();
          localb.d = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX)localObject).getLatitude();
          localb.e = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX)localObject).getLongitude();
          localb.c = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX)localObject).getKey();
          localb.f = paramInt;
          localb.g = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX)localObject).getData();
          this.r.getData().add(localb);
        }
      }
      this.r.notifyDataSetChanged();
      return;
    }
    paramb = (List)paramb.g;
    this.s.getData().clear();
    if (paramb != null)
    {
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        localObject = (LocationInfoBean.DataBeanXX.ListBean.DataBeanX.DataBean)paramb.next();
        localb = new b(null);
        localb.a = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX.DataBean)localObject).getName();
        localb.b = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX.DataBean)localObject).getValue();
        localb.d = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX.DataBean)localObject).getLatitude();
        localb.e = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX.DataBean)localObject).getLongitude();
        localb.c = null;
        localb.f = paramInt;
        localb.g = null;
        localb.i = ((LocationInfoBean.DataBeanXX.ListBean.DataBeanX.DataBean)localObject).getUnlimited();
        this.s.getData().add(localb);
      }
    }
    this.s.notifyDataSetChanged();
  }
  
  private void b()
  {
    this.g = new a(this.b);
    this.r = new a(this.b);
    this.s = new a(this.b);
    this.lv_level_1.setAdapter(this.g);
    this.lv_level_2.setAdapter(this.r);
    this.lv_level_3.setAdapter(this.s);
    this.d.getLocationInfo(this, this);
  }
  
  private void b(int paramInt)
  {
    c.getInstance().clearSupplementMap();
    Intent localIntent = getIntent();
    switch (paramInt)
    {
    }
    for (;;)
    {
      setResult(-1);
      finish();
      return;
      c.getInstance().addSupplementElement(((b)this.g.getData().get(this.t)).c, ((b)this.r.getData().get(this.u)).b);
      c.getInstance().setLocationCache(this.t, this.u, -1);
      c.getInstance().setLocationName(((b)this.r.getData().get(this.u)).a);
      localIntent.putExtra("latitude", ((b)this.r.getData().get(this.u)).d);
      localIntent.putExtra("longitude", ((b)this.r.getData().get(this.u)).e);
      c.getInstance().setLocLatLon(((b)this.r.getData().get(this.u)).d, ((b)this.r.getData().get(this.u)).e);
      continue;
      if (((b)this.s.getData().get(this.v)).i == 1)
      {
        c.getInstance().addSupplementElement(((b)this.g.getData().get(this.t)).c, ((b)this.r.getData().get(this.u)).b);
        c.getInstance().setLocationCache(this.t, this.u, -1);
        c.getInstance().setLocationName(((b)this.r.getData().get(this.u)).a);
        c.getInstance().setLocLatLon(((b)this.r.getData().get(this.u)).d, ((b)this.r.getData().get(this.u)).e);
      }
      else
      {
        c.getInstance().addSupplementElement(((b)this.r.getData().get(this.u)).c, ((b)this.s.getData().get(this.v)).b);
        c.getInstance().setLocationCache(this.t, this.u, this.v);
        c.getInstance().setLocationName(((b)this.s.getData().get(this.v)).a);
        c.getInstance().setLocLatLon(((b)this.s.getData().get(this.v)).d, ((b)this.s.getData().get(this.v)).e);
      }
    }
  }
  
  private void e()
  {
    this.e = new com.ziroom.ziroomcustomer.minsu.searchlist.c.a(this);
    this.a.register(this.e);
    this.d = com.ziroom.ziroomcustomer.minsu.searchlist.a.a.getInstance(this.a);
  }
  
  @OnClick({2131690460, 2131691673})
  public void OnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690460: 
      finish();
      return;
    }
    setResult(11);
    finish();
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903328);
    this.b = this;
    this.c = ButterKnife.bind(this);
    a();
    e();
    b();
  }
  
  protected void onDestroy()
  {
    this.a.unregister(this.e);
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
      do
      {
        do
        {
          do
          {
            return;
            if (!parama.equals("location_info")) {
              break;
            }
            i = 0;
            break;
            if (!parama.equals("location_info_error")) {
              break;
            }
            i = 1;
            break;
            this.f = this.e.getLocationInfoBean();
          } while ((this.f == null) || (this.f.getData() == null) || (this.f.getData().getList() == null) || (this.f.getData().getList().get(0) == null));
          parama = c.getInstance().getSupplementMap();
          if ((parama == null) || (parama.size() <= 0)) {
            break label423;
          }
          a(1, null);
        } while ((c.getInstance().getLocationPosition1() == null) || (c.getInstance().getLocationPosition1().intValue() < 0));
        this.g.setSelected(c.getInstance().getLocationPosition1().intValue());
        a(2, (b)this.g.getData().get(c.getInstance().getLocationPosition1().intValue()));
        this.t = c.getInstance().getLocationPosition1().intValue();
        this.lv_level_1.smoothScrollToPosition(this.t);
      } while ((c.getInstance().getLocationPosition2() == null) || (c.getInstance().getLocationPosition2().intValue() < 0));
      this.r.setSelected(c.getInstance().getLocationPosition2().intValue());
      a(3, (b)this.r.getData().get(c.getInstance().getLocationPosition2().intValue()));
      this.u = c.getInstance().getLocationPosition2().intValue();
      this.lv_level_2.smoothScrollToPosition(this.u);
      this.lv_level_3.setVisibility(0);
    } while ((c.getInstance().getLocationPosition3() == null) || (c.getInstance().getLocationPosition3().intValue() < 0));
    this.s.setSelected(c.getInstance().getLocationPosition3().intValue());
    this.v = c.getInstance().getLocationPosition3().intValue();
    this.lv_level_3.smoothScrollToPosition(this.v);
    return;
    label423:
    this.lv_level_3.setVisibility(8);
    a(1, null);
    a(2, (b)this.g.getData().get(0));
    this.g.setSelected(0);
  }
  
  private class a
    extends BaseAdapter
  {
    private Context b;
    private List<SearchListLocationActivity.b> c;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public int getCount()
    {
      if (this.c == null) {
        return 0;
      }
      return this.c.size();
    }
    
    public List<SearchListLocationActivity.b> getData()
    {
      if (this.c == null) {
        this.c = new ArrayList();
      }
      return this.c;
    }
    
    public Object getItem(int paramInt)
    {
      return this.c.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.b).inflate(2130904328, paramViewGroup, false);
        paramView = new a();
        paramView.a = ((TextView)localView.findViewById(2131695287));
        localView.setTag(paramView);
      }
      paramView = (a)localView.getTag();
      paramView.a.setText(((SearchListLocationActivity.b)this.c.get(paramInt)).a);
      if (((SearchListLocationActivity.b)this.c.get(paramInt)).h)
      {
        paramView.a.setTextColor(Color.parseColor("#ffa000"));
        return localView;
      }
      paramView.a.setTextColor(Color.parseColor("#444444"));
      return localView;
    }
    
    public void setData(List<SearchListLocationActivity.b> paramList)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
    
    public void setSelected(int paramInt)
    {
      if ((this.c != null) && (paramInt < this.c.size()))
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
          ((SearchListLocationActivity.b)localIterator.next()).h = false;
        }
        ((SearchListLocationActivity.b)this.c.get(paramInt)).h = true;
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
    String c;
    Double d;
    Double e;
    int f;
    Object g;
    boolean h;
    int i;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/searchlist/SearchListLocationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */