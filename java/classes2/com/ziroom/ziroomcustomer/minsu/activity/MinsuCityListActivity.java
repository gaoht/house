package com.ziroom.ziroomcustomer.minsu.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.b.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityItemBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCityKeyBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHistoryBean;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.f.x;
import com.ziroom.ziroomcustomer.minsu.f.z;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.minsu.view.MyLetterView;
import com.ziroom.ziroomcustomer.minsu.view.MyLetterView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MinsuCityListActivity
  extends BaseActivity
{
  private ListView a;
  private MyLetterView b;
  private String c;
  private CommonTitle d;
  private List<MinsuCityKeyBean> e;
  private List<MinsuCityItemBean> f;
  private List<MinsuCityItemBean> g;
  private boolean r = false;
  private boolean s = false;
  private TextView t;
  private a u;
  private com.ziroom.ziroomcustomer.minsu.adapter.b v;
  private Handler w;
  
  private void a()
  {
    this.d = ((CommonTitle)findViewById(2131691272));
    this.d.setLeftButtonType(4);
    this.d.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuCityListActivity.this.finish();
      }
    });
    this.d.setBottomLineAlpha(0.0F);
    this.a = ((ListView)findViewById(2131691267));
    this.t = ((TextView)findViewById(2131691268));
    this.b = ((MyLetterView)findViewById(2131691270));
    this.b.setOnSlidingListener(new MyLetterView.a()
    {
      public void sliding(String paramAnonymousString)
      {
        MinsuCityListActivity.a(MinsuCityListActivity.this, false);
        if (MinsuCityListActivity.a(MinsuCityListActivity.this).a.get(paramAnonymousString) != null)
        {
          int i = ((Integer)MinsuCityListActivity.a(MinsuCityListActivity.this).a.get(paramAnonymousString)).intValue();
          if (MinsuCityListActivity.b(MinsuCityListActivity.this))
          {
            paramAnonymousString = ((MinsuCityKeyBean)MinsuCityListActivity.c(MinsuCityListActivity.this).get(i)).key;
            MinsuCityListActivity.d(MinsuCityListActivity.this).setText(paramAnonymousString);
            MinsuCityListActivity.d(MinsuCityListActivity.this).setVisibility(0);
            MinsuCityListActivity.f(MinsuCityListActivity.this).removeCallbacks(MinsuCityListActivity.e(MinsuCityListActivity.this));
            MinsuCityListActivity.f(MinsuCityListActivity.this).postDelayed(MinsuCityListActivity.e(MinsuCityListActivity.this), 1000L);
          }
          MinsuCityListActivity.g(MinsuCityListActivity.this).setSelection(i);
        }
      }
    });
    this.a.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      @SuppressLint({"DefaultLocale"})
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (!MinsuCityListActivity.h(MinsuCityListActivity.this)) {}
        label27:
        label185:
        for (;;)
        {
          return;
          if (paramAnonymousInt1 == 0)
          {
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(0);
            if (paramAnonymousAbsListView == null)
            {
              paramAnonymousInt2 = 0;
              float f = Math.abs(paramAnonymousInt2) / 100.0F;
              MinsuCityListActivity.i(MinsuCityListActivity.this).setBottomLineAlpha(f);
            }
          }
          for (;;)
          {
            if (!MinsuCityListActivity.b(MinsuCityListActivity.this)) {
              break label185;
            }
            paramAnonymousAbsListView = ((MinsuCityKeyBean)MinsuCityListActivity.c(MinsuCityListActivity.this).get(paramAnonymousInt1)).name;
            if (paramAnonymousInt1 < 2) {
              break;
            }
            paramAnonymousAbsListView = ((MinsuCityKeyBean)MinsuCityListActivity.c(MinsuCityListActivity.this).get(paramAnonymousInt1)).key;
            MinsuCityListActivity.d(MinsuCityListActivity.this).setText(paramAnonymousAbsListView);
            MinsuCityListActivity.d(MinsuCityListActivity.this).setVisibility(0);
            MinsuCityListActivity.f(MinsuCityListActivity.this).removeCallbacks(MinsuCityListActivity.e(MinsuCityListActivity.this));
            MinsuCityListActivity.f(MinsuCityListActivity.this).postDelayed(MinsuCityListActivity.e(MinsuCityListActivity.this), 1000L);
            return;
            paramAnonymousInt2 = paramAnonymousAbsListView.getTop();
            break label27;
            MinsuCityListActivity.i(MinsuCityListActivity.this).setBottomLineAlpha(1.0F);
          }
        }
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2)) {
          MinsuCityListActivity.a(MinsuCityListActivity.this, true);
        }
      }
    });
  }
  
  private void a(MinsuCityItemBean paramMinsuCityItemBean)
  {
    if (paramMinsuCityItemBean == null) {
      return;
    }
    MinsuSearchHistoryBean localMinsuSearchHistoryBean = new MinsuSearchHistoryBean();
    localMinsuSearchHistoryBean.cityCode = paramMinsuCityItemBean.code;
    localMinsuSearchHistoryBean.cityName = paramMinsuCityItemBean.name;
    localMinsuSearchHistoryBean.city_latitude = paramMinsuCityItemBean.latitude;
    localMinsuSearchHistoryBean.city_longitude = paramMinsuCityItemBean.longitude;
    localMinsuSearchHistoryBean.startDate = "";
    localMinsuSearchHistoryBean.endDate = "";
    z.putSearchHistory(this, localMinsuSearchHistoryBean);
  }
  
  private void a(List<MinsuCityKeyBean> paramList)
  {
    this.f = com.ziroom.ziroomcustomer.minsu.d.b.getIntance(this).getHotCityList();
    this.e = new ArrayList();
    Object localObject = z.getSearchHistory(this);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.g = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MinsuSearchHistoryBean localMinsuSearchHistoryBean = (MinsuSearchHistoryBean)((Iterator)localObject).next();
        MinsuCityItemBean localMinsuCityItemBean = new MinsuCityItemBean();
        localMinsuCityItemBean.code = localMinsuSearchHistoryBean.cityCode;
        localMinsuCityItemBean.name = localMinsuSearchHistoryBean.cityName;
        localMinsuCityItemBean.latitude = localMinsuSearchHistoryBean.city_latitude;
        localMinsuCityItemBean.longitude = localMinsuSearchHistoryBean.city_longitude;
        this.g.add(localMinsuCityItemBean);
      }
    }
    if ((this.g != null) && (!this.g.isEmpty()))
    {
      localObject = new MinsuCityKeyBean();
      ((MinsuCityKeyBean)localObject).name = "最近";
      ((MinsuCityKeyBean)localObject).key = "0";
      this.e.add(localObject);
    }
    if ((this.f != null) && (!this.f.isEmpty()))
    {
      localObject = new MinsuCityKeyBean();
      ((MinsuCityKeyBean)localObject).name = "热门";
      ((MinsuCityKeyBean)localObject).key = "1";
      this.e.add(localObject);
    }
    this.e.addAll(paramList);
    paramList = (String[])com.ziroom.ziroomcustomer.minsu.d.b.getIntance(this).getCityKeyList().toArray(new String[0]);
    this.b.setLetter(paramList);
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.e)) {
      return;
    }
    e();
    this.s = true;
  }
  
  private void b()
  {
    List localList = com.ziroom.ziroomcustomer.minsu.d.b.getIntance(this).getCityKeyNameMapList();
    if ((localList == null) || (localList.isEmpty()))
    {
      com.ziroom.ziroomcustomer.minsu.d.b.getIntance(this).getCityNameList(new x()
      {
        public void onError(Object paramAnonymousObject) {}
        
        public void onSuccess(Object paramAnonymousObject)
        {
          MinsuCityListActivity.j(MinsuCityListActivity.this);
        }
      });
      return;
    }
    a(localList);
  }
  
  private void e()
  {
    this.v = new com.ziroom.ziroomcustomer.minsu.adapter.b(this, this.e, this.f, this.g);
    this.v.setOnItemClickListener(new b.a()
    {
      public void onItmClick(String paramAnonymousString)
      {
        MinsuCityListActivity.a(MinsuCityListActivity.this, com.ziroom.ziroomcustomer.minsu.d.b.getIntance(MinsuCityListActivity.this).getCode(paramAnonymousString));
        com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setCityCode(MinsuCityListActivity.k(MinsuCityListActivity.this));
        com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setCityName(paramAnonymousString);
        com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setCityBean(com.ziroom.ziroomcustomer.minsu.d.b.getIntance(MinsuCityListActivity.this).getCityBean(MinsuCityListActivity.k(MinsuCityListActivity.this)));
        MinsuCityListActivity.this.setResult(-1, MinsuCityListActivity.this.getIntent());
        MinsuCityListActivity.a(MinsuCityListActivity.this, com.ziroom.ziroomcustomer.minsu.d.b.getIntance(MinsuCityListActivity.this).getCityBean(MinsuCityListActivity.k(MinsuCityListActivity.this)));
        v.onClick(MinsuCityListActivity.this, "M-Begin_search_" + MinsuCityListActivity.k(MinsuCityListActivity.this));
        if ("map".equals(MinsuCityListActivity.this.getIntent().getStringExtra("from")))
        {
          k.toMinsuMap(MinsuCityListActivity.this);
          MinsuCityListActivity.this.finish();
          return;
        }
        MinsuCityListActivity.this.finish();
      }
    });
    this.a.setAdapter(this.v);
  }
  
  public void finish()
  {
    super.finish();
    k.animFinishAlpha(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903263);
    a();
    b();
    this.w = new Handler();
    this.u = new a(null);
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      MinsuCityListActivity.d(MinsuCityListActivity.this).setVisibility(4);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuCityListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */